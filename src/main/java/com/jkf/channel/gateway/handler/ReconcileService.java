package com.jkf.channel.gateway.handler;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.XlBizTypeEnum;
import com.jkf.channel.gateway.dao.ChannelInfoMapper;
import com.jkf.channel.gateway.entity.ChannelInfo;
import com.jkf.channel.gateway.entity.ChannelMchtXl;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.service.ChannelMchtXlService;
import com.jkf.channel.gateway.service.ChannelProService;
import com.jkf.channel.gateway.utils.AssertUtils;
import com.jkf.channel.gateway.utils.GuoMISignUtils;
import com.jkf.channel.gateway.utils.GuoMiCryptoUtils;
import com.jkf.channel.gateway.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.net.ssl.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/**
 * 对账文件服务
 */
@Slf4j
@Service
public class ReconcileService {

    @Resource
    private ChannelInfoMapper channelInfoMapper;
    @Resource
    private ChannelProService channelProService;
    @Resource
    private ChannelMchtXlService channelMchtXlService;

    @Value("${file.temp}")
    private String fileTemp;

    @Resource(name = "downloadExecutor")
    private Executor downloadExecutor;

    /**
     * 下载某一天的对账文件
     *
     * @param date yyyyMMdd
     * @return
     */
    public void downloadXinLianFile(String date) {
        //信联支付  所有商户都要去下载
        //查信联所有商户表
        List<ChannelMchtXl> channelMchtXlList = channelMchtXlService.getAll();
        if (CollUtil.isNotEmpty(channelMchtXlList)) {
            log.info("需要下载对账文件的商户数：{}", channelMchtXlList.size());
            ChannelMchtXl channelMchtXl = channelMchtXlList.get(0);
            ChannelInfo channelInfo = channelInfoMapper.selectByPrimaryKey(channelMchtXl.getChannelId());
            AssertUtils.customNotNull(channelInfo, ErrorCode.PARAM_ERROR.getErrorCode(), "机构未配置渠道");
            //查询通道的所有属性
            Map<String, String> proMap = channelProService.findProByChannelId(channelInfo.getId());
            for (ChannelMchtXl item : channelMchtXlList) {
                String tradeTaskName = "对账文件申请（交易）";
                //每个商户，依次申请并下载  交易文件
                downloadExecutor.execute(() -> {
                    String respBody = "";
                    try {
                        //申请    交易文件
                        respBody = apply(date, XlBizTypeEnum.CheckPayOrder.getBizType(),"01", proMap, item.getChannelMchtNo());
                    } catch (Exception e) {
                        log.info(tradeTaskName + "异常", e);
                        return;
                    }
                    JSONObject respData = JSONObject.parseObject(respBody);
                    if (!"0".equals(respData.get("status"))) {
//                        if ("RRB-08000057".equals(respData.get("status"))) {
//                            log.info("返回结果，无可下载项");
//                        }
                        log.info(tradeTaskName + "失败,返回结果，status:{},message:{}", respData.get("status"), respData.get("message"));
                        return;
                    }
                    String downloadTradeTaskName = "对账文件下载（交易）";
                    JSONObject data = respData.getJSONObject("data");
                    if (data != null && !StringUtils.isEmpty(data.getString("downloadUrl"))) {
                        String downloadUrl = data.getString("downloadUrl");
                        String downloadToken = data.getString("downloadToken");
                        log.info(downloadTradeTaskName + "成功，返回downloadUrl:{}，downloadToken：{}", downloadUrl, downloadToken);
                        //对账日期，格式应为yyyy-MM-dd
                        String dateStr = DateUtil.format(DateUtil.parse(date, DatePattern.PURE_DATE_PATTERN), DatePattern.NORM_DATE_FORMAT);
                        //存储路径  home/file/merBill/2023-12-06/
                        String saveDir = fileTemp + "merBill/" + dateStr + "/";
                        //文件名 直接取返回的连接文件名   格式： 商户号_时间戳_文件类型
                        // 如 1656438344850440193_20231206013010_01
                        //   文件类型 01-收单类 03-付款
                        //https://testrans.xlpayment.com/api/oss/merBill/2023-12-06/1656438344850440193_20231206013010_01.txt
                        URI uri = URI.create(downloadUrl);
                        String path = uri.getPath();
                        String filename = path.substring(path.lastIndexOf('/') + 1);
                        //下载文件
                        try {
                            downloadFile(downloadUrl, downloadToken, saveDir, filename);
                        } catch (Exception e) {
                            log.error(downloadTradeTaskName + "异常", e);
                        }
                    } else {
                        log.info(tradeTaskName + "失败");
                    }
                });

                //每个商户，依次申请并下载 结算文件
                String settleTaskName = "对账文件申请（结算）";
                downloadExecutor.execute(() -> {
                    String respBody = "";
                    try {
                        //申请    结算文件
                        respBody = apply(date, XlBizTypeEnum.CheckPaymentOrder.getBizType(),"03", proMap, item.getChannelMchtNo());
                    } catch (Exception e) {
                        log.info(settleTaskName + "异常", e);
                        return;
                    }
                    JSONObject respData = JSONObject.parseObject(respBody);
                    if (!"0".equals(respData.get("status"))) {
                        log.info(settleTaskName + "失败,返回结果，status:{},message:{}", respData.get("status"), respData.get("message"));
                        return;
                    }
                    String downloadSettleTaskName = "对账文件下载（交易）";
                    JSONObject data = respData.getJSONObject("data");
                    if (data != null && !StringUtils.isEmpty(data.getString("downloadUrl"))) {
                        String downloadUrl = data.getString("downloadUrl");
                        String downloadToken = data.getString("downloadToken");
                        log.info(downloadSettleTaskName + "成功，返回downloadUrl:{}，downloadToken：{}", downloadUrl, downloadToken);
                        //对账日期，格式应为yyyy-MM-dd
                        String dateStr = DateUtil.format(DateUtil.parse(date, DatePattern.PURE_DATE_PATTERN), DatePattern.NORM_DATE_FORMAT);
                        //存储路径  home/file/settleBill/2023-12-06/
                        String saveDir = fileTemp + "settleBill/" + dateStr + "/";
                        //文件名 直接取返回的连接文件名   格式： 商户号_时间戳_文件类型
                        // 如 1656438344850440193_20231206013010_01
                        //   文件类型 01-收单类 03-付款
                        //https://testrans.xlpayment.com/api/oss/merBill/2023-12-06/1656438344850440193_20231206013010_01.txt
                        URI uri = URI.create(downloadUrl);
                        String path = uri.getPath();
                        String filename = path.substring(path.lastIndexOf('/') + 1);
                        //下载文件
                        try {
                            downloadFile(downloadUrl, downloadToken, saveDir, filename);
                        } catch (Exception e) {
                            log.error(downloadSettleTaskName + "异常", e);
                        }
                    } else {
                        log.info(settleTaskName + "失败");
                    }
                });

            }
        }

    }

    /**
     * 信联下载对账文件申请
     *
     * @param date          yyyyMMdd
     * @param bizType       业务类型    CheckPayOrder-收单对账文件，CheckPaymentOrder-付款对账文件
     * @param billType       文件类型，01-收单类  03-付款类
     * @param channelProMap 信联渠道参数
     * @param partnerId     合作伙伴标识  channelMchtNo
     */
    private static String apply(String date, String bizType, String billType,Map<String, String> channelProMap, String partnerId) {
        Map<String, String> params = new HashMap<>();
        // 业务类型
        params.put("bizType", bizType);
        // 合作伙伴标识，替换为信联支付分配的唯一标识   商户号（不是服务商号）
        params.put("partnerId", partnerId);
        params.put("keyId",channelProMap.get("keyId"));
        //对账日期，格式应为yyyy-MM-dd
        String dateStr = DateUtil.format(DateUtil.parse(date, DatePattern.PURE_DATE_PATTERN), DatePattern.NORM_DATE_FORMAT);
        params.put("checkDt", dateStr);
        // 文件类型，01-收单类
        params.put("billType", billType);
        String respBody = commonRequest(params, bizType, channelProMap);
        return respBody;
    }


    /**
     * @param business      业务参数
     * @param bizType       请求业务类型
     * @param channelProMap 渠道参数
     * @return
     */
    private static String commonRequest(Map<String, String> business, String bizType, Map<String, String> channelProMap) {
        business.put("timestamp", System.currentTimeMillis() + "");
        business.put("random", UUID.fastUUID().toString(true));
        business.put("signType", "SM2");
        business.put("keyId", channelProMap.get("keyId"));
        business.put("versionNo", "1.0.0");
        business.put("bizType", bizType);
        String signature = "";
        String sm2Pass = channelProMap.get("sm2Pass");
        try {
            //使用sm2加密生成签名
            signature = GuoMISignUtils.getSignature(business, channelProMap.get("merSm2KeyText"), sm2Pass);
        } catch (Exception e) {
            log.error("出现异常", e);
            throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(), "签名失败");
        }
        business.put("signature", signature);//签名
        //url= 网关地址 registerUrl + 请求路径 path
        String url = channelProMap.get("registerUrl") + channelProMap.get("path");
        log.info("请求的地址:{}", url);
        log.info("请求的参数:{}", business);
        //使用平台的公钥进行加密
        String requestData = "";
        try {
            requestData = GuoMiCryptoUtils.sm2AndSm4Encrypt(channelProMap.get("payCenterPublicKey"), JsonUtils.toJson(business));

          /*  String keyId=GuoMiCryptoUtils.sm2AndSm4Encrypt(payCenterPublicKey,"ae06b5c8ffa73bc3bdb83c193082010a");
            log.info("keyId:{}",keyId);*/
        } catch (Exception e) {
            log.error("出现异常", e);
            throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(), "请求报文加密失败");
        }
        log.info("请求数据加密:{}", requestData);
        String resBody = "";
        try {
            HttpResponse response = cn.hutool.http.HttpUtil.createPost(url)
                    .contentType(ContentType.build(ContentType.TEXT_PLAIN.getValue(), CharsetUtil.CHARSET_UTF_8))
                    .charset(CharsetUtil.CHARSET_UTF_8)
                    .body(requestData)
                    .execute();
            resBody = response.body();
            log.info("返回数据原文：{}", resBody);
        } catch (Exception e) {
            log.error("出现异常", e);
            throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(), "请求失败");
        }
        //  返回值解密
        //用商户的私钥解密
        String resBodyDecrypt = "";
        try {
            resBodyDecrypt = GuoMiCryptoUtils.sm2AndSm4Decrypt(channelProMap.get("merSm2DecKeyFile"), resBody, sm2Pass);
            log.info("响应数据解密后：{}", resBodyDecrypt);
        } catch (Exception e) {
            log.error("出现异常", e);
            throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(), "响应报文解密失败");
        }
        //验签,使用平台公钥验证签名
        try {
            if (GuoMISignUtils.validateSign(resBodyDecrypt)) {
                log.info("验签通过");
            } else {
                log.info("验签失败");
            }
        } catch (Exception e) {
            log.error("验签异常", e);
        }
        return resBodyDecrypt;
    }

    /**
     * 下载信联文件
     *
     * @param fileURL
     * @param downloadToken
     * @param saveDir
     * @param fileName
     * @throws Exception
     */
    public static void downloadFile(String fileURL, String downloadToken, String saveDir, String fileName) throws Exception {
        // 创建信任所有SSL证书的TrustManager
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    @Override
                    public void checkClientTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
        };

        // 设置信任所有SSL证书的SSLContext
        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        // 应用自定义的SSLContext
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        // 创建URL对象
        URL url = new URL(fileURL);
        // 打开连接
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // 忽略SSL证书验证
        if (conn instanceof HttpsURLConnection) {
            ((HttpsURLConnection) conn).setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        }

        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("GET");

        // 在header里面加downloadToken参数
        httpConn.setRequestProperty("DownloadToken", downloadToken);
        int responseCode = httpConn.getResponseCode();
        // 检查服务器响应
        if (responseCode == HttpURLConnection.HTTP_OK) {
            //如果不存在,创建目录
            File saveDirFile = new File(saveDir);
            if (!saveDirFile.exists()) {
                //可以创建多级目录
                saveDirFile.mkdirs();
//                log.info("The directory will be created at: " + saveDirFile.getAbsolutePath());
            }
            // 打开输入流
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + "/" + fileName;
            // 打开输出流
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
            int bytesRead = -1;
            byte[] buffer = new byte[4096];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();
            log.info("文件下载成功,fileName：{}", fileName);
        } else {
            log.info("文件下载失败.响应码 HTTP code: {}", responseCode);
        }
        httpConn.disconnect();
    }

    /**
     * 信联对某一天的账
     * 对缺少的新增，并加入到待通知表里面
     *
     * @param date yyyyMMdd
     */
    public void xinLianReconcile(String date) {
        //TODO
        // 从文件读取数据

        //有文件则继续，无则退出

        //获取参数

        //比较订单
        //存在则跳过，不存在则新增订单和订单通知

    }


    public static void main(String[] args) throws Exception {
        String url = "https://lmg.jj20.com/up/allimg/1113/042220121425/200422121425-3-1200.jpg";
        downloadFile(url, "aa", "temp2", "aa.jpg");
    }
}

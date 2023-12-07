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
import com.jkf.channel.gateway.entity.*;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.service.*;
import com.jkf.channel.gateway.utils.AssertUtils;
import com.jkf.channel.gateway.utils.GuoMISignUtils;
import com.jkf.channel.gateway.utils.GuoMiCryptoUtils;
import com.jkf.channel.gateway.utils.JsonUtils;
import com.jkf.channel.gateway.vo.XlTradeInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
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
    @Resource
    private ReconcileDataDealService reconcileDataDealService;
    @Resource
    private MchInfoService mchInfoService;
    @Resource
    private OrgInfoService orgInfoService;
    @Resource
    private OrgInterfceKeyService orgInterfceKeyService;

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
                //下载信联对账文件 T0 用1.51接口，D0用1.52接口
                //每个商户，依次申请并下载  交易T1文件  1.51     CheckPayOrder,billType:01
                downloadByBizType(date,channelMchtXl.getChannelMchtNo(),XlBizTypeEnum.CheckPayOrder.getBizType(), "01",proMap);
                //每个商户，依次申请并下载 交易D0文件   1.52 CheckPaymentOrder,billType:03
                downloadByBizType(date,channelMchtXl.getChannelMchtNo(),XlBizTypeEnum.CheckPaymentOrder.getBizType(), "03",proMap);
                //TODO 信联暂时没提供这个接口  每个商户，依次申请并下载 结算文件
            }
        }

    }



    /**
     * 信联下载对账文件申请
     *
     * @param date          yyyyMMdd
     * @param bizType       业务类型    CheckPayOrder-收单对账文件，CheckPaymentOrder-付款对账文件
     * @param billType      文件类型，01-收单类  03-付款类
     * @param channelProMap 信联渠道参数
     * @param partnerId     合作伙伴标识  channelMchtNo
     */
    private static String apply(String date, String bizType, String billType, Map<String, String> channelProMap, String partnerId) {
        Map<String, String> params = new HashMap<>();
        // 业务类型
        params.put("bizType", bizType);
        // 合作伙伴标识，替换为信联支付分配的唯一标识   商户号（不是服务商号）
        params.put("partnerId", partnerId);
        params.put("keyId", channelProMap.get("keyId"));
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
     *
     * @param date
     * @param channelMchtNo 渠道商户号
     * @param bizType   业务类型    CheckPayOrder-收单对账文件 T1，CheckPaymentOrder-付款对账文件 D0
     * @param billType  文件类型，01-收单类  03-付款类
     * @param proMap    渠道参数
     * @throws Exception
     */
    private void downloadByBizType(String date,String channelMchtNo,String bizType,String billType, Map<String, String> proMap) {
        String tradeTaskName;
        if (bizType.equals(XlBizTypeEnum.CheckPayOrder.getBizType())){
            tradeTaskName = "对账文件申请（交易T1）";
        }else {
            tradeTaskName = "对账文件申请（交易D0）";
        }
        downloadExecutor.execute(() -> {
            String respBody = "";
            try {
                //申请    交易文件
                respBody = apply(date, bizType, billType, proMap, channelMchtNo);
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
            String downloadTradeTaskName = "对账文件下载";
            JSONObject data = respData.getJSONObject("data");
            if (data != null && !StringUtils.isEmpty(data.getString("downloadUrl"))) {
                String downloadUrl = data.getString("downloadUrl");
                String downloadToken = data.getString("downloadToken");
                log.info(downloadTradeTaskName + "成功，返回downloadUrl:{}，downloadToken：{}", downloadUrl, downloadToken);
                //对账日期，格式应为yyyy-MM-dd
                String dateStr = DateUtil.format(DateUtil.parse(date, DatePattern.PURE_DATE_PATTERN), DatePattern.NORM_DATE_FORMAT);
                //存储路径  home/file/merBill/2023-12-06/
                String path;
                //交易账单
                path="merBill";
                String saveDir = fileTemp + path +"/" + dateStr + "/";
                //文件名 格式： 商户号_时间戳_文件类型
                // 如 1656438344850440193_20231206_01
                //https://testrans.xlpayment.com/api/oss/merBill/2023-12-06/1656438344850440193_20231206_01.txt
                //yyyyMMdd 保证一天只有一个类型的文件
                String filename = channelMchtNo + "_" + date + "_" + billType + ".txt";
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
        // 从文件读取数据
        //先处理交易文件
        //对账日期，格式应为yyyy-MM-dd
        String dateStr = DateUtil.format(DateUtil.parse(date, DatePattern.PURE_DATE_PATTERN), DatePattern.NORM_DATE_FORMAT);
        //存储路径  home/file/merBill/2023-12-06/
        String tradeDir = fileTemp + "merBill/" + dateStr + "/";
        //有文件则继续，无则退出
        File directory = new File(tradeDir);
        if (directory.exists()) {
            // 遍历目录
            if (directory.isDirectory()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        downloadExecutor.execute(() -> {
                            // 处理文件
                            //文件名 格式： 商户号_时间戳yyyyMMdd_文件类型
                            // 如 1656438344850440193_20231206_01
                            //billType 文件类型，01-收单类  03-付款类
                            String fileAbsolutePath = file.getAbsolutePath();
                            String fileName = file.getAbsoluteFile().getName();
                            //文件名前缀
                            String filePrefix = fileName.substring(0, fileName.lastIndexOf('.'));
                            //文件名 格式： 商户号_时间戳_文件类型
                            String[] split = filePrefix.split("_");
                            String channelMchtNo = split[0];
                            ChannelMchtXl channelMchtXl = channelMchtXlService.getByChannelMchtNo(channelMchtNo);
                            MchInfo mchInfo = mchInfoService.selectByPrimaryKey(channelMchtXl.getMchId());
                            OrgInfo orgInfo = orgInfoService.selectByPrimaryKey(mchInfo.getOrgId());
                            String orgNo = orgInfo.getOrgNo();
                            OrgInterfceKey orgInterfceKey = orgInterfceKeyService.getFromCache(orgNo);
                            //billType 文件类型，01-收单类(实际T1)  03-付款类(实际D0)
                            String billType = split[2];
                            Map<String, Object> fileMap = parseTextTest(fileAbsolutePath);
//                        Map firstMap = (Map)fileMap.get("firstMap");
                            ArrayList secondHeaderList = (ArrayList) fileMap.get("secondHeaderList");
                            ArrayList<ArrayList> secondDataListList = (ArrayList<ArrayList>) fileMap.get("secondDataList");
                            log.info("fileMap:{}", fileMap);
                            ArrayList<XlTradeInfo> xlTradeInfoList = convert2TradeInfoList(secondHeaderList, secondDataListList);
                            //排序 先交易后退款，避免退款找不到原订单
                            Collections.sort(xlTradeInfoList, Comparator.comparing(XlTradeInfo::getTransactionType));
                            if (CollUtil.isEmpty(xlTradeInfoList)) {
                                return;
                            }
                            //业务处理
                            for (XlTradeInfo xlTradeInfo : xlTradeInfoList) {
                                try{
                                    reconcileDataDealService.xlDealTradeInfo(xlTradeInfo, channelMchtXl, mchInfo, orgInterfceKey);
                                }catch (Exception e){
                                    log.error("reconcileDataDealService.xlDealTradeInfo 发生异常",e);
                                }
                            }

                        });

                    }
                }
            }
        }


        //处理结算文件
        //存结算表 mch_trade_settle
        log.info("对账完成：{}",date);
    }


    /**
     * 解析文件
     *
     * @param fileAbsolutePath 完整路径 带文件名
     */
    private Map<String, Object> parseTextTest(String fileAbsolutePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileAbsolutePath))) {
            String line;
            String[] firstHeaders = null;
            String[] secondHeaders = null;
            int lineNum = 1;
            //第一种标题格式
            ArrayList<String> firstHeaderList = new ArrayList<>();
            ArrayList<String> firstHeaderValueList = new ArrayList<>();
            Map<String, String> firstHeaderMap = new HashMap<>();
            //第二种标题格式
            ArrayList<String> secondHeaderList = new ArrayList<>();
            ArrayList<ArrayList> secondHeaderValueListList = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                if (lineNum == 1) {
                    // 处理第一种标题行
                    firstHeaders = line.split("\\|");
                    log.info("firstHeaders大小:{}", firstHeaders.length);
                    firstHeaderList = new ArrayList(Arrays.asList(firstHeaders));
                } else if (lineNum == 2) {
                    //处理第一种标题行数据行
                    String[] firstFields = line.split("\\|", -1);
                    log.info("firstFields大小:{}", firstFields.length);
                    firstHeaderValueList = new ArrayList(Arrays.asList(firstFields));
                    for (int i = 0; i < firstHeaderList.size(); i++) {
                        //标题行和数据对应
                        firstHeaderMap.put(firstHeaderList.get(i), firstHeaderValueList.get(i));
                    }
                } else if (lineNum == 3) {
                    // 处理第2种标题行
                    secondHeaders = line.split("\\|");
                    log.info("secondHeaders大小:{}", secondHeaders.length);
                    secondHeaderList = new ArrayList(Arrays.asList(secondHeaders));
                    secondHeaderValueListList = new ArrayList<>(secondHeaderList.size());
                    // 创建 secondHeaders.length 个空的 ArrayList
                    for (int i = 0; i < secondHeaders.length; i++) {
                        secondHeaderValueListList.add(new ArrayList<>());
                    }
                } else {
                    // 处理第2种标题行和数据
                    String[] secondFields = line.split("\\|", -1);
                    log.info("secondFields大小:{}", secondFields.length);
                    // 将标题行的数据和数据行的数据对应起来
                    Map<String, String> dataMap = new HashMap<>();
                    for (int i = 0; i < secondHeaders.length; i++) {
                        secondHeaderValueListList.get(i).add(secondFields[i]);
//                        log.info("secondHeaders:{},secondFields:{}", secondHeaders[i],secondFields[i]);
                    }
                }
                lineNum++;
            }
            log.info("firstHeaderMap:{}，secondHeaderList:{},secondHeaderValueListList：{}", firstHeaderMap, secondHeaderList, secondHeaderValueListList);
            Map<String, Object> map = new HashMap<>();
            map.put("firstMap", firstHeaderMap);
            map.put("secondHeaderList", secondHeaderList);
            map.put("secondDataList", secondHeaderValueListList);
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 文件数据 转为交易实体类
     *
     * @param secondHeaderList
     * @param secondDataListList
     */
    private static ArrayList<XlTradeInfo> convert2TradeInfoList(ArrayList secondHeaderList, ArrayList<ArrayList> secondDataListList) {
        ArrayList<XlTradeInfo> tradeInfoArrayList = new ArrayList<>();
        if (CollUtil.isNotEmpty(secondDataListList)) {
            ArrayList firstColumList = secondDataListList.get(0);
            if (CollUtil.isNotEmpty(firstColumList)) {
                //填充
                for (int i = 0; i < firstColumList.size(); i++) {
                    XlTradeInfo tradeInfo = new XlTradeInfo();
                    for (int j = 0; j < secondDataListList.size(); j++) {
                        ArrayList arrayList = secondDataListList.get(j);
                        String header = (String) secondHeaderList.get(j);
                        //订单发起日期|订单发起时间|交易日期|交易时间|商户订单号|支付方式|交易类型|交易状态|订单金额|手续费|信联支付流水号|客户标识|订单来源|退汇状态
                        if (arrayList.get(i) != null) {
                            String value = (String) arrayList.get(i);
                            switch (header) {
                                case "订单发起日期":
                                    tradeInfo.setOrderStartDate(value);
                                    break;
                                case "订单发起时间":
                                    tradeInfo.setOrderStartTime(value);
                                    break;
                                case "交易日期":
                                    tradeInfo.setTradeDate(value);
                                    break;
                                case "交易时间":
                                    tradeInfo.setTradeTime(value);
                                    break;
                                case "商户订单号":
                                    tradeInfo.setOriOrderId(value);
                                    break;
                                case "支付方式":
                                    tradeInfo.setTrxCtgy(value);
                                    break;
                                case "交易类型":
                                    tradeInfo.setTransactionType(value);
                                    break;
                                case "交易状态":
                                    tradeInfo.setTrxStatus(value);
                                    break;
                                case "订单金额":
                                    tradeInfo.setTrxAmt(value);
                                    break;
                                case "手续费":
                                    tradeInfo.setChargeAmt(value);
                                    break;
                                case "信联支付流水号":
                                    tradeInfo.setXlSerialNo(value);
                                    break;
                                case "客户标识":
                                    tradeInfo.setCustomerIdentifier(value);
                                    break;
                                case "订单来源":
                                    tradeInfo.setOrderSource(value);
                                    break;
                                case "退汇状态":
                                    tradeInfo.setRefundStatus(value);
                                    break;
                                default:
                                    // 默认情况下的处理逻辑
                                    break;
                            }
                        }
                    }
                    tradeInfoArrayList.add(tradeInfo);
                }
            }
        }

        log.debug("转换后的数据tradeInfoArrayList:{}", tradeInfoArrayList);
        return tradeInfoArrayList;
    }

    public static void main(String[] args) throws Exception {
        String url = "https://lmg.jj20.com/up/allimg/1113/042220121425/200422121425-3-1200.jpg";
        downloadFile(url, "aa", "temp2", "aa.jpg");
    }

}

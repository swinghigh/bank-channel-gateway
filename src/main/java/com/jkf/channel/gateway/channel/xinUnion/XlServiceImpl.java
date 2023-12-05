package com.jkf.channel.gateway.channel.xinUnion;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.BusNotifyEnum;
import com.jkf.channel.gateway.constant.ChannelCode;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.dao.*;
import com.jkf.channel.gateway.entity.*;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.service.ChannelProService;
import com.jkf.channel.gateway.service.IBussinessNotifyService;
import com.jkf.channel.gateway.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/12/4 15:23
 */
@Service
@Slf4j
public class XlServiceImpl implements IXlService {
    @Resource
    private ChannelInfoMapper channelInfoMapper;
    @Resource
    private ChannelMchtXlMapper channelMchtXlMapper;
    @Autowired
    private ChannelProService channelProService;
    @Resource
    private ChannelMchRouteMapper channelMchRouteMapper;
    @Resource
    private MchInfoMapper mchInfoMapper;
    @Autowired
    private IBussinessNotifyService bussinessNotifyService;
    @Value("${buss.xinlianRegisterNotifyUrl}")
    private String registerNotifyUrl;

    @Override
    public Map<String, Object> register(JSONObject param) {
        log.info("接收前置发过来的参数:{}", param);
        List<ChannelInfo> channelInfos = channelInfoMapper.selectChannelByOrgIdAndChannelCompanyNo(param.getLong("orgId"), ChannelCode.XINLIAN.getChannelCompanyCode());
        AssertUtils.collectIsEmpty(channelInfos, ErrorCode.PARAM_ERROR.getErrorCode(), "机构未配置信联的渠道");
        ChannelInfo channelInfo = channelInfos.get(0);
        //查询渠道的参数
        Map<String, String> proMap = channelProService.findProByChannelId(channelInfo.getId());
        String keyId = proMap.get("keyId");
        String partnerId = proMap.get("partnerId");
        Long mchId = param.getLong("mchId");
        String outApplyId = param.getString("outApplyId");
        if (StringUtils.isEmpty(outApplyId)) {
            outApplyId = param.getString("outMchtNo");
        }
        //先计划规则,一个商户只允许进件一次信联，因为信联支持幕等操作
        ChannelMchtXlExample example = new ChannelMchtXlExample();
        example.createCriteria().andChannelIdEqualTo(channelInfo.getId())
                .andMchIdEqualTo(mchId)
                .andOutApplyIdEqualTo(outApplyId);
        List<ChannelMchtXl> channelMchtXls = channelMchtXlMapper.selectByExample(example);
        ChannelMchtXl channelMchtXl = null;
        String orderId = UUID.randomUUID().toString().replaceAll("-", "");
        if (channelMchtXls != null && channelMchtXls.size() > 0) {
            channelMchtXl = channelMchtXls.get(0);
            if ("30".equals(channelMchtXl.getCheckStatus())) {
//                throw new BusinessException(ErrorCode.HAS_OPEN_SUCCESS.getErrorCode(),"商户已经入网渠道成功");
                Map<String, Object> result = ResultUtils.businessResult(ErrorCode.HAS_OPEN_SUCCESS.getErrorCode(), "商户已经入网渠道成功");
                result.put("channelMchtNo", channelMchtXl.getChannelMchtNo());
                return result;
            }
            orderId = channelMchtXl.getOrderId();
            channelMchtXl.setCheckStatus("2");//入网中
            channelMchtXl.setUpdateTime(new Date());
            channelMchtXlMapper.updateByPrimaryKeySelective(channelMchtXl);
        } else {
            //保存请求参数:
            channelMchtXl = new ChannelMchtXl();
            channelMchtXl.setMchId(mchId);
            channelMchtXl.setChannelId(channelInfo.getId());
            channelMchtXl.setChannelMchtName(param.getString("mchName"));
            channelMchtXl.setOrderId(orderId);
            channelMchtXl.setOutApplyId(outApplyId);
            channelMchtXl.setUserName(param.getString("username"));
            channelMchtXl.setLoginPassword(AESUtil.encrypt(param.getString("loginPwd"), AESUtil.key));
            channelMchtXl.setNotifyUrl(param.getString("notifyUrl"));
            channelMchtXl.setCheckStatus("2");
            channelMchtXl.setCreateId(0L);
            channelMchtXl.setCreateTime(new Date());
            channelMchtXlMapper.insertSelective(channelMchtXl);
        }
        //组建请求参数:
        Map<String, String> business = new HashMap<>();
        business.put("partnerId", partnerId);
        business.put("orderId", orderId);
        try {
            business.put("username", GuoMIEncryptUtil.demoSM4EncryptMessage(GuoMIEncryptUtil.getSession(), param.getString("username"), keyId));//使用sm4加密
            business.put("loginPwd", GuoMIEncryptUtil.demoSM4EncryptMessage(GuoMIEncryptUtil.getSession(), param.getString("loginPwd"), keyId));//使用sm4加密
        } catch (Exception e) {
            log.error("敏感信息加密异常", e);
            throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(), "敏感信息加密失败");
        }
        business.put("merName", param.getString("mchName"));//商户名称
        business.put("informUrl", registerNotifyUrl + "/" + orderId);//通知地址
        business.put("keyId", keyId);
        try {
            String respBody = common(business, "PosMerApiRegist", "/api/wc/payTransaction", proMap);
            JSONObject respData = JSONObject.parseObject(respBody);
            JSONObject data = respData.getJSONObject("data");
            if (data != null && !StringUtils.isEmpty(data.getString("merCstNo"))) {
                log.info("开户成功:{}", data.getString("merCstNo"));
                channelMchtXl.setCheckStatus("3");
                channelMchtXl.setCheckMessage("");
                channelMchtXl.setUpdateTime(new Date());
                channelMchtXl.setChannelMchtNo(data.getString("merCstNo"));
                channelMchtXlMapper.updateByPrimaryKeySelective(channelMchtXl);
                //存入路由
                ChannelMchRouteExample routeExample = new ChannelMchRouteExample();
                routeExample.createCriteria().andMchIdEqualTo(channelMchtXl.getMchId())
                        .andChannelMchtNoEqualTo(channelMchtXl.getChannelMchtNo());
                List<ChannelMchRoute> channelMchRoutes = channelMchRouteMapper.selectByExample(routeExample);
                if(channelMchRoutes==null||channelMchRoutes.size()==0) {
                    ChannelMchRoute route = new ChannelMchRoute();
                    route.setMchId(param.getLong("mchId"));
                    route.setChannelId(channelInfo.getId());
                    route.setChannelMchtNo(data.getString("merCstNo"));
                    route.setChannelOrder(channelInfo.getChannelOrder());
                    route.setCreateTime(new Date());
                    route.setCreateId(0L);
                    channelMchRouteMapper.insertSelective(route);
                }
                //插入路由
                Map<String, Object> result = ResultUtils.businessResult(ErrorCode.SUCCESS.getErrorCode(), "通道审核中");
                result.put("channelMchtNo", channelMchtXl.getChannelMchtNo());
                return result;
            } else {
                String message = respData.getString("message");
                log.info("开户失败:{}", message);
                channelMchtXl.setCheckStatus("4");
                channelMchtXl.setCheckMessage(message);
                channelMchtXl.setUpdateTime(new Date());
                channelMchtXlMapper.updateByPrimaryKeySelective(channelMchtXl);
                return ResultUtils.businessResult(ErrorCode.OPEN_FAIL.getErrorCode(), message);
            }
        } catch (BusinessException e) {
            //开户失败
            channelMchtXl.setCheckStatus("4");
            channelMchtXl.setCheckMessage(e.getMessage());
            channelMchtXl.setUpdateTime(new Date());
            channelMchtXlMapper.updateByPrimaryKeySelective(channelMchtXl);
            return ResultUtils.businessResult(e.getCode(), e.getMessage());
        }
    }

    @Override
    public Map<String, Object> queryStatus(JSONObject param) {
        String outApplyId = param.getString("outApplyId");
        if (StringUtils.isEmpty(outApplyId)) {
            outApplyId = param.getString("outMchtNo");
        }
        ChannelMchtXlExample example = new ChannelMchtXlExample();
        example.createCriteria().andMchIdEqualTo(param.getLong("mchId"))
                .andOutApplyIdEqualTo(outApplyId);
        List<ChannelMchtXl> channelMchtXls = channelMchtXlMapper.selectByExample(example);
        if (channelMchtXls == null || channelMchtXls.size() == 0) {
            return ResultUtils.businessResult(ErrorCode.FAIL.getErrorCode(), "商户不存在");
        }
        ChannelMchtXl channelMchtXl = channelMchtXls.get(0);
        if ("3".equals(channelMchtXl.getCheckStatus())) {
            //通道审核中,查询通道的状态
            //组建请求参数:
            //查询渠道的参数
            Map<String, String> proMap = channelProService.findProByChannelId(channelMchtXl.getChannelId());
            Map<String, String> business = new HashMap<>();
            business.put("partnerId", proMap.get("partnerId"));
            business.put("orderId", channelMchtXl.getOrderId());
            business.put("merCstNo", channelMchtXl.getChannelMchtNo());
            String respBody = common(business, "PosMerApiQuery", "/api/wc/payTransaction", proMap);
            JSONObject respData = JSONObject.parseObject(respBody);
            JSONObject data = respData.getJSONObject("data");
            if (data != null && !StringUtils.isEmpty(data.getString("regMerAuditStatus"))) {
                String merStatus = data.getString("merStatus");//目前查询接口返回的10 是审核中和审核拒绝是同一个状态，无法区分，所以我们就当审核中了
                //商户注册审核状态 00-待录入 10-待审核，20-审核拒绝，30-审核通过
                String regMerAuditStatus = data.getString("regMerAuditStatus");//
                if ("20".equals(regMerAuditStatus) || "30".equals(regMerAuditStatus)) {
                    //修改状态
                    channelMchtXl.setCheckStatus("30".equals(regMerAuditStatus) ? "0" : "5");
                    if ("30".equals(regMerAuditStatus)) {
                        channelMchtXl.setCheckTime(new Date());
                    }
//                    channelMchtXlMapper.updateByPrimaryKey(channelMchtXl);
                    //修改商户资料的状态
                    //通知前置系统,做成异步的
                    if ("0".equals(channelMchtXl.getNotifyFlag())) {
                        channelMchtXl.setNotifyFlag("3");
                    }
                    ztDeal(channelMchtXl);
                }
            }
        }
        Map<String, Object> result = ResultUtils.businessResult(ErrorCode.SUCCESS.getErrorCode(), "查询成功");
        result.put("channelMchtNo", channelMchtXl.getChannelMchtNo());
        result.put("mchName", channelMchtXl.getChannelMchtName());
        result.put("status", channelMchtXl.getCheckStatus());
        result.put("reason", channelMchtXl.getCheckMessage());
        return result;
    }

    /**
     * 处理终态
     *
     * @param channelMchtXl
     */
    public void ztDeal(ChannelMchtXl channelMchtXl) {
        if ("0".equals(channelMchtXl.getCheckStatus()) || "5".equals(channelMchtXl.getCheckStatus())) {
            //
            channelMchtXlMapper.updateByPrimaryKey(channelMchtXl);
            //插入路由
            ChannelMchRouteExample routeExample = new ChannelMchRouteExample();
            routeExample.createCriteria().andMchIdEqualTo(channelMchtXl.getMchId())
                    .andChannelMchtNoEqualTo(channelMchtXl.getChannelMchtNo());
            List<ChannelMchRoute> channelMchRoutes = channelMchRouteMapper.selectByExample(routeExample);
            if (channelMchRoutes == null || channelMchRoutes.size() == 0) {
                ChannelInfo channelInfo = channelInfoMapper.selectByPrimaryKey(channelMchtXl.getChannelId());
                //存入路由
                ChannelMchRoute route = new ChannelMchRoute();
                route.setMchId(channelMchtXl.getMchId());
                route.setChannelId(channelMchtXl.getChannelId());
                route.setChannelMchtNo(channelMchtXl.getChannelMchtNo());
                route.setChannelOrder(channelInfo.getChannelOrder());
                route.setCreateTime(new Date());
                route.setCreateId(0L);
                channelMchRouteMapper.insertSelective(route);
            }
            //修改主商户状态
            MchInfo mchInfo = mchInfoMapper.selectByPrimaryKey(channelMchtXl.getMchId());
            if (mchInfo != null && !"0".equals(mchInfo.getMchStatus())) {
                mchInfo.setMchStatus(channelMchtXl.getCheckStatus());
                if ("0".equals(channelMchtXl.getCheckStatus())) {
                    mchInfo.setPassTime(DateUtil.getFormat(new Date(), "yyyy-MM-dd HH:mm:ss"));
                }
                mchInfoMapper.updateByPrimaryKeySelective(mchInfo);
            }
            //进件通知
            if (!StringUtils.isEmpty(channelMchtXl.getNotifyUrl()) && "3".equals(channelMchtXl.getNotifyFlag())) {
                //通知给业务方
                Map<String, Object> bussMap = new HashMap<>();
                bussMap.put("outMchtNo", mchInfo.getOutMchNo());
                bussMap.put("mchNo", mchInfo.getMchNo());
                bussMap.put("mchId", channelMchtXl.getMchId());
                bussMap.put("channelMchtNo", channelMchtXl.getChannelMchtNo());
                bussMap.put("mchName", channelMchtXl.getChannelMchtName());
                bussMap.put("status", channelMchtXl.getCheckStatus());
                bussMap.put("reason", channelMchtXl.getCheckMessage());
                bussMap.put("outApplyId", channelMchtXl.getOutApplyId());
                //这里添加异步
                bussinessNotifyService.busNotify(bussMap, mchInfo.getOrgId(), channelMchtXl.getNotifyUrl(),
                        "1", "10", BusNotifyEnum.XL_REGISTER.getBussType());
            } else {
                log.info("{}不满足通知条件", channelMchtXl.getChannelMchtNo());
            }
        }
    }


    @Override
    public Map<String, Object> registerNotify(String bodyParam, String orderId) {
        Map<String, Object> result = new HashMap<>();
        result.put("resultCode", ErrorCode.SUCCESS.getErrorCode());
        ChannelMchtXlExample xlexample = new ChannelMchtXlExample();
        xlexample.createCriteria().andOrderIdEqualTo(orderId);
        List<ChannelMchtXl> channelMchtXls = channelMchtXlMapper.selectByExample(xlexample);
        if (channelMchtXls == null || channelMchtXls.size() == 0) {
            result.put("resultCode", ErrorCode.PARAM_ERROR.getErrorCode());
            result.put("resultMsg", "orderId非法");
            return result;
        }
        ChannelMchtXl channelMchtXl = channelMchtXls.get(0);
        JSONObject respData = JSONObject.parseObject(bodyParam);
//        商户状态：10 代表审核未通过，需要商户登录万贯收银 APP 修改资料再次提交，并联系运营人员审核，新的审核也触发新的通知；
//        商户状态：30 表示审核成功且商户正常可用；
        String merStatus = respData.getString("merStatus");//
        //商户注册审核状态 00-待录入 10-待审核，20-审核拒绝，30-审核通过
        String regMerAuditStatus = respData.getString("regMerAuditStatus");//
        if (!("10".equals(regMerAuditStatus) || "20".equals(regMerAuditStatus) || "30".equals(regMerAuditStatus))) {
            log.error("其他的状态暂时先不处理");
            result.put("resultMsg", "未知状态");
            return result;
        }
        if ("10".equals(regMerAuditStatus)) {//待审核
            channelMchtXl.setCheckStatus("3");
            channelMchtXl.setCheckMessage("通道审核拒绝");
        }
        if ("20".equals(regMerAuditStatus)) {//拒绝
            channelMchtXl.setCheckStatus("5");
            channelMchtXl.setCheckMessage("通道审核拒绝");
        }
        if ("30".equals(regMerAuditStatus)) {//拒绝
            //修改状态
            channelMchtXl.setCheckStatus("0");
            channelMchtXl.setCheckTime(new Date());
        }
        channelMchtXl.setNotifyFlag("3");
        ztDeal(channelMchtXl);
        return result;
    }

    private String common(Map<String, String> business, String bizType, String path, Map<String, String> proMap) {
        business.put("timestamp", System.currentTimeMillis() + "");
        business.put("random", UUID.fastUUID().toString(true));
        business.put("signType", "SM2");
        business.put("versionNo", "1.0.0");
        business.put("bizType", bizType);
        String signature = "";
        try {
            //使用sm2加密生成签名
            signature = GuoMISignUtils.getSignature(business, proMap.get("merSm2KeyText"), proMap.get("sm2Pass"));
        } catch (Exception e) {
            log.error("出现异常", e);
            throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(), "签名失败");
        }
        business.put("signature", signature);//签名
        log.info("请求的地址:{}", proMap.get("registerUrl") + path);
        log.info("请求的参数:{}", business);
        //使用平台的公钥进行加密
        String requestData = "";
        try {
            requestData = GuoMiCryptoUtils.sm2AndSm4Encrypt(proMap.get("payCenterPublicKey"), JsonUtils.toJson(business));

          /*  String keyId=GuoMiCryptoUtils.sm2AndSm4Encrypt(payCenterPublicKey,"ae06b5c8ffa73bc3bdb83c193082010a");
            log.info("keyId:{}",keyId);*/
        } catch (Exception e) {
            log.error("出现异常", e);
            throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(), "请求报文加密失败");
        }
        log.info("请求数据加密:{}", requestData);
        String resBody = "";
        try {
            HttpResponse response = cn.hutool.http.HttpUtil.createPost(proMap.get("registerUrl") + path)
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
            resBodyDecrypt = GuoMiCryptoUtils.sm2AndSm4Decrypt(proMap.get("merSm2DecKeyFile"), resBody, proMap.get("sm2Pass"));
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

}

package com.jkf.channel.gateway.controller;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.channel.xinUnion.IXlBizNotifyHandler;
import com.jkf.channel.gateway.channel.xinUnion.IXlService;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.dao.ChannelMchtXlMapper;
import com.jkf.channel.gateway.entity.ChannelMchtXl;
import com.jkf.channel.gateway.entity.ChannelMchtXlExample;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.service.ChannelProService;
import com.jkf.channel.gateway.utils.GuoMISignUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.CharEncoding;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/12/4 16:01
 */
@RestController
@RequestMapping("xinlianNotify")
@Slf4j
public class XlNotifyController {
    @Resource
    private ChannelMchtXlMapper channelMchtXlMapper;
    @Autowired
    private List<IXlBizNotifyHandler> xlBizNotifyHandlers;
    @Autowired
    private ChannelProService channelProService;

    /**
     * 根据业务类型获取业务处理类
     *
     * @param bizType
     * @return
     */
    private IXlBizNotifyHandler getHandlerByBizType(String bizType) {
        if (StringUtils.isEmpty(bizType)) {
            return null;
        }
        if (CollectionUtils.isEmpty(xlBizNotifyHandlers)) {
            return null;
        }
        for (IXlBizNotifyHandler temp : xlBizNotifyHandlers) {
            if (bizType.equals(temp.getBizType())) {
                return temp;
            }
        }
        return null;
    }
    //{"oriTrxDtTm":"20231205135824","bizType":"PayNotify","settlemtDt":"20231205","signature":"MIID/wYKKoEcz1UGAQQCAqCCA+8wggPrAgEBMQ4wDAYIKoEcz1UBgxEFADARBgoqgRzPVQYBBAIBoAMEAWKgggLrMIIC5zCCAougAwIBAgIFEEgICCYwDAYIKoEcz1UBg3UFADBcMQswCQYDVQQGEwJDTjEwMC4GA1UECgwnQ2hpbmEgRmluYW5jaWFsIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MRswGQYDVQQDDBJDRkNBIFRFU1QgU00yIE9DQTEwHhcNMjIwMjA4MDgwODQ0WhcNMjIwODA4MDgwODQ0WjCBizELMAkGA1UEBhMCQ04xDDAKBgNVBAoMA0JPQzETMBEGA1UECwwKQ0ZDQVRlY2hURTEZMBcGA1UECwwQT3JnYW5pemF0aW9uYWwtMjE+MDwGA1UEAww1Q0ZDQVRlY2hURUDkv6HogZTmlK/ku5jlm73lr4blj4zor4HmtYvor5VAWjExMTExMTExQDEwWTATBgcqhkjOPQIBBggqgRzPVQGCLQNCAAR3CJx7gJheFkuIyrd9MkDU+fYXa2p/GX6+S3bwfzVR1T5NhpJzo9NKt0AjuGKUnJ5/2pMA6RqpvX79EiO2MQSoo4IBBjCCAQIwHwYDVR0jBBgwFoAUa/4Y2o9COqa4bbMuiIM6NKLBMOEwDAYDVR0TAQH/BAIwADBIBgNVHSAEQTA/MD0GCGCBHIbvKgEBMDEwLwYIKwYBBQUHAgEWI2h0dHA6Ly93d3cuY2ZjYS5jb20uY24vdXMvdXMtMTQuaHRtMDkGA1UdHwQyMDAwLqAsoCqGKGh0dHA6Ly91Y3JsLmNmY2EuY29tLmNuL1NNMi9jcmwyOTkxNS5jcmwwDgYDVR0PAQH/BAQDAgbAMB0GA1UdDgQWBBSZQYQ90WdD82Dt3CiE1anENsJQGjAdBgNVHSUEFjAUBggrBgEFBQcDAgYIKwYBBQUHAwQwDAYIKoEcz1UBg3UFAANIADBFAiEArrWzDB2I+z6jHswZJx6z3q7cgavXs4aq1K2mu+fV3doCIFskV5SJho4H7r8ub32dOryrpX4UR30m1Ul8mkXTCXhvMYHTMIHQAgEBMGUwXDELMAkGA1UEBhMCQ04xMDAuBgNVBAoMJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEbMBkGA1UEAwwSQ0ZDQSBURVNUIFNNMiBPQ0ExAgUQSAgIJjAMBggqgRzPVQGDEQUAMA0GCSqBHM9VAYItAQUABEcwRQIgaCHrKVobbJMWGs6JAj+ksHlQl9duEAmowfxLn+8fvj4CIQCtTngnWsvm/h4FZcLB9xa2m9mTHc8ic/pauE0aRlT5TA==","trxStatus":"90","trxCtgy":"22","oriOrderId":"1701755882763000","messageDesc":"TRADE_SUCCESS","signType":"SM2","partnerId":"1656438344850440193","trxAmt":"11"}
    //进件通知:{"bizType":"PosMerAuditNotify","signature":"MIID/wYKKoEcz1UGAQQCAqCCA+8wggPrAgEBMQ4wDAYIKoEcz1UBgxEFADARBgoqgRzPVQYBBAIBoAMEAWKgggLrMIIC5zCCAougAwIBAgIFEEgICCYwDAYIKoEcz1UBg3UFADBcMQswCQYDVQQGEwJDTjEwMC4GA1UECgwnQ2hpbmEgRmluYW5jaWFsIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MRswGQYDVQQDDBJDRkNBIFRFU1QgU00yIE9DQTEwHhcNMjIwMjA4MDgwODQ0WhcNMjIwODA4MDgwODQ0WjCBizELMAkGA1UEBhMCQ04xDDAKBgNVBAoMA0JPQzETMBEGA1UECwwKQ0ZDQVRlY2hURTEZMBcGA1UECwwQT3JnYW5pemF0aW9uYWwtMjE+MDwGA1UEAww1Q0ZDQVRlY2hURUDkv6HogZTmlK/ku5jlm73lr4blj4zor4HmtYvor5VAWjExMTExMTExQDEwWTATBgcqhkjOPQIBBggqgRzPVQGCLQNCAAR3CJx7gJheFkuIyrd9MkDU+fYXa2p/GX6+S3bwfzVR1T5NhpJzo9NKt0AjuGKUnJ5/2pMA6RqpvX79EiO2MQSoo4IBBjCCAQIwHwYDVR0jBBgwFoAUa/4Y2o9COqa4bbMuiIM6NKLBMOEwDAYDVR0TAQH/BAIwADBIBgNVHSAEQTA/MD0GCGCBHIbvKgEBMDEwLwYIKwYBBQUHAgEWI2h0dHA6Ly93d3cuY2ZjYS5jb20uY24vdXMvdXMtMTQuaHRtMDkGA1UdHwQyMDAwLqAsoCqGKGh0dHA6Ly91Y3JsLmNmY2EuY29tLmNuL1NNMi9jcmwyOTkxNS5jcmwwDgYDVR0PAQH/BAQDAgbAMB0GA1UdDgQWBBSZQYQ90WdD82Dt3CiE1anENsJQGjAdBgNVHSUEFjAUBggrBgEFBQcDAgYIKwYBBQUHAwQwDAYIKoEcz1UBg3UFAANIADBFAiEArrWzDB2I+z6jHswZJx6z3q7cgavXs4aq1K2mu+fV3doCIFskV5SJho4H7r8ub32dOryrpX4UR30m1Ul8mkXTCXhvMYHTMIHQAgEBMGUwXDELMAkGA1UEBhMCQ04xMDAuBgNVBAoMJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEbMBkGA1UEAwwSQ0ZDQSBURVNUIFNNMiBPQ0ExAgUQSAgIJjAMBggqgRzPVQGDEQUAMA0GCSqBHM9VAYItAQUABEcwRQIgRx47Bfl8bwid7EeG6IWjdefMxSAQ2p5p4fQVoi7Z5vUCIQDjf+cEvghSIVLsR5+33meHershx+gLxSDViqY9bwjLQA==","merCstNo":"1656771045902401540","signType":"SM2","partnerId":"1643703350196977666","regMerAuditStatus":"30","merStatus":"25"}
    /**
     * 信联的注册回调处理
     *
     * @return
     */
    @RequestMapping("commonNotify/{orderId}")
    public String commonNotify(HttpServletRequest request, @PathVariable("orderId") String orderId) throws Exception {
        //从request中获取body数据
        try {
            String bodyParam = IOUtils.toString(request.getInputStream(), CharEncoding.UTF_8);
            log.info("得到的信联的通知参数为:{}", bodyParam);
            ChannelMchtXlExample xlexample = new ChannelMchtXlExample();
            xlexample.createCriteria().andOrderIdEqualTo(orderId);
            List<ChannelMchtXl> channelMchtXls = channelMchtXlMapper.selectByExample(xlexample);
            if (channelMchtXls == null || channelMchtXls.size() == 0) {
                throw new BusinessException(ErrorCode.FAIL.getErrorCode(), "orderId非法");
            }
            ChannelMchtXl channelMchtXl = channelMchtXls.get(0);
            Map<String, String> proMap = channelProService.findProByChannelId(channelMchtXl.getChannelId());
            if (proMap == null || proMap.size() == 0) {
                throw new BusinessException(ErrorCode.FAIL.getErrorCode(), "渠道密钥未配置");
            }
            //验证签名
            if (GuoMISignUtils.validateSign(bodyParam)) {
                log.info("验签通过");
            } else {
                log.info("验签失败");
                throw new BusinessException(ErrorCode.FAIL.getErrorCode(), "验签失败");
            }
            JSONObject respData = JSONObject.parseObject(bodyParam);
            String bizType = respData.getString("bizType");
            IXlBizNotifyHandler handler = getHandlerByBizType(bizType);
            if(handler==null){
                throw new BusinessException(ErrorCode.FAIL.getErrorCode(), bizType+"类业务通知未实现");
            }
            handler.notifyHandler(bodyParam,orderId);
            return "SUCCESS";
        } catch (Exception e) {
            log.error("出现异常", e);
            throw e;
        }
    }
}

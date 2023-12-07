package com.jkf.channel.gateway.test;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.utils.GuoMIEncryptUtil;
import com.jkf.channel.gateway.utils.GuoMISignUtils;
import com.jkf.channel.gateway.utils.GuoMiCryptoUtils;
import com.jkf.channel.gateway.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/12/1 10:27
 */
@Slf4j
public class XinUnionTest {
    private static final String SING_PROPERTY = "signature";

    /**
     * 商户自行生成的 sm2 签名私钥
     */
    static final String sm2Pass = "xlzf1234";
    //商户加密私钥
    static final String merSm2KeyText = "MIIDSgIBATBHBgoqgRzPVQYBBAIBBgcqgRzPVQFoBDDDqEfQfVQuxZA3Y2YacJf9lM/h+zTld2Fb\n" +
            "pAowSs+U/x8mDaUAJ2tgQrJ/RJHvF+cwggL6BgoqgRzPVQYBBAIBBIIC6jCCAuYwggKLoAMCAQIC\n" +
            "BUBEl2CDMAwGCCqBHM9VAYN1BQAwYTELMAkGA1UEBhMCQ04xMDAuBgNVBAoMJ0NoaW5hIEZpbmFu\n" +
            "Y2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEgMB4GA1UEAwwXQ0ZDQSBBQ1MgVEVTVCBTTTIg\n" +
            "T0NBMzEwHhcNMjMwMTE3MDI1MDU0WhcNMjQwMTE3MDI1MDU0WjCBkjELMAkGA1UEBhMCQ04xIDAe\n" +
            "BgNVBAoMF0NGQ0EgQUNTIFRFU1QgU00yIE9DQTMxMREwDwYDVQQLDAhMb2NhbCBSQTEZMBcGA1UE\n" +
            "CwwQT3JnYW5pemF0aW9uYWwtMjEzMDEGA1UEAwwqMDUxQDcwU0hBTkdIVU1JTkc3MEBOOTEzNzAx\n" +
            "MDBNQTNRQUJNNDNZQDE1MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEDB/jiyrUFo2UiQ7VmrBy\n" +
            "kWmv7MUEw4Tgv64if/RLBC6K/fMc+bL3VLIp2XK6bua4D6eHH8OqePRxpRKyGOxWYaOB+zCB+DA/\n" +
            "BggrBgEFBQcBAQQzMDEwLwYIKwYBBQUHMAGGI2h0dHA6Ly9vY3NwdGVzdC5jZmNhLmNvbS5jbjo4\n" +
            "MC9vY3NwMB8GA1UdIwQYMBaAFATHvPlZAWk+jDQ2IGIYPN68tbsMMAwGA1UdEwEB/wQCMAAwOAYD\n" +
            "VR0fBDEwLzAtoCugKYYnaHR0cDovLzIxMC43NC40Mi4zL09DQTMxL1NNMi9jcmwyMDIuY3JsMA4G\n" +
            "A1UdDwEB/wQEAwIGwDAdBgNVHQ4EFgQUeDG21Bzg7ROTyuarDXJJuZLq1pswHQYDVR0lBBYwFAYI\n" +
            "KwYBBQUHAwIGCCsGAQUFBwMEMAwGCCqBHM9VAYN1BQADRwAwRAIgD358NlvcL7tCg2NQx1PEe282\n" +
            "KX7dAq1/g/alZlN8EacCIBG8ikLjj80zn1RmNYqdxKm4nLh/KHXVm01yYqTKAsXO";
    /**
     * 商户签名公钥（机构使用该公钥对请求报文验签）
     */
    static final String merSm2PubKeyText = "MIIC5jCCAougAwIBAgIFQESXYIMwDAYIKoEcz1UBg3UFADBhMQswCQYDVQQGEwJD\n" +
            "TjEwMC4GA1UECgwnQ2hpbmEgRmluYW5jaWFsIENlcnRpZmljYXRpb24gQXV0aG9y\n" +
            "aXR5MSAwHgYDVQQDDBdDRkNBIEFDUyBURVNUIFNNMiBPQ0EzMTAeFw0yMzAxMTcw\n" +
            "MjUwNTRaFw0yNDAxMTcwMjUwNTRaMIGSMQswCQYDVQQGEwJDTjEgMB4GA1UECgwX\n" +
            "Q0ZDQSBBQ1MgVEVTVCBTTTIgT0NBMzExETAPBgNVBAsMCExvY2FsIFJBMRkwFwYD\n" +
            "VQQLDBBPcmdhbml6YXRpb25hbC0yMTMwMQYDVQQDDCowNTFANzBTSEFOR0hVTUlO\n" +
            "RzcwQE45MTM3MDEwME1BM1FBQk00M1lAMTUwWTATBgcqhkjOPQIBBggqgRzPVQGC\n" +
            "LQNCAAQMH+OLKtQWjZSJDtWasHKRaa/sxQTDhOC/riJ/9EsELor98xz5svdUsinZ\n" +
            "crpu5rgPp4cfw6p49HGlErIY7FZho4H7MIH4MD8GCCsGAQUFBwEBBDMwMTAvBggr\n" +
            "BgEFBQcwAYYjaHR0cDovL29jc3B0ZXN0LmNmY2EuY29tLmNuOjgwL29jc3AwHwYD\n" +
            "VR0jBBgwFoAUBMe8+VkBaT6MNDYgYhg83ry1uwwwDAYDVR0TAQH/BAIwADA4BgNV\n" +
            "HR8EMTAvMC2gK6AphidodHRwOi8vMjEwLjc0LjQyLjMvT0NBMzEvU00yL2NybDIw\n" +
            "Mi5jcmwwDgYDVR0PAQH/BAQDAgbAMB0GA1UdDgQWBBR4MbbUHODtE5PK5qsNckm5\n" +
            "kurWmzAdBgNVHSUEFjAUBggrBgEFBQcDAgYIKwYBBQUHAwQwDAYIKoEcz1UBg3UF\n" +
            "AANHADBEAiAPfnw2W9wvu0KDY1DHU8R7bzYpft0CrX+D9qVmU3wRpwIgEbyKQuOP\n" +
            "zTOfVGY1ip3EqbicuH8oddWbTXJipMoCxc4=";

    /**
     * 商户解密私钥（用于支付机构响应回来的报文解密）
     */
    static final String merSm2DecKeyFile = "MIIDSwIBATBHBgoqgRzPVQYBBAIBBgcqgRzPVQFoBDCo9kqMgvBC7KPo7wFX7LiNjp3z1WySqJxa\n" +
            "5ElMWkMYjN5zJ6VexFn8tf02Ky96IL4wggL7BgoqgRzPVQYBBAIBBIIC6zCCAucwggKLoAMCAQIC\n" +
            "BUBEl2CEMAwGCCqBHM9VAYN1BQAwYTELMAkGA1UEBhMCQ04xMDAuBgNVBAoMJ0NoaW5hIEZpbmFu\n" +
            "Y2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEgMB4GA1UEAwwXQ0ZDQSBBQ1MgVEVTVCBTTTIg\n" +
            "T0NBMzEwHhcNMjMwMTE3MDI1MDU0WhcNMjQwMTE3MDI1MDU0WjCBkjELMAkGA1UEBhMCQ04xIDAe\n" +
            "BgNVBAoMF0NGQ0EgQUNTIFRFU1QgU00yIE9DQTMxMREwDwYDVQQLDAhMb2NhbCBSQTEZMBcGA1UE\n" +
            "CwwQT3JnYW5pemF0aW9uYWwtMjEzMDEGA1UEAwwqMDUxQDcwU0hBTkdIVU1JTkc3MEBOOTEzNzAx\n" +
            "MDBNQTNRQUJNNDNZQDE1MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAE5petaDwRUPpr2It+AJ0l\n" +
            "bVTrGe5rfduhp0Kn//bjaemdfrYAQfndpL2KUCSDEt7tVDewOFT+x4YNmT1Rx4OIYKOB+zCB+DA/\n" +
            "BggrBgEFBQcBAQQzMDEwLwYIKwYBBQUHMAGGI2h0dHA6Ly9vY3NwdGVzdC5jZmNhLmNvbS5jbjo4\n" +
            "MC9vY3NwMB8GA1UdIwQYMBaAFATHvPlZAWk+jDQ2IGIYPN68tbsMMAwGA1UdEwEB/wQCMAAwOAYD\n" +
            "VR0fBDEwLzAtoCugKYYnaHR0cDovLzIxMC43NC40Mi4zL09DQTMxL1NNMi9jcmwyMDIuY3JsMA4G\n" +
            "A1UdDwEB/wQEAwIDODAdBgNVHQ4EFgQUagUO8LthZ+f9ka1HWANukgmcva0wHQYDVR0lBBYwFAYI\n" +
            "KwYBBQUHAwIGCCsGAQUFBwMEMAwGCCqBHM9VAYN1BQADSAAwRQIgE5yoeQqcaSklcqfikS7vCAhm\n" +
            "5TSbyJakeABQSR4HZtkCIQDUwYWGrTKpVPeOa7EujqS7PPIDYLTF5dh5HEOrMSYPaQ==";


    /**
     * 商户解密公钥(支付机构使用该公钥加密)
     */
    static final String merSm2DecPubKeyFile = "MIIC5jCCAougAwIBAgIFQESXYHIwDAYIKoEcz1UBg3UFADBhMQswCQYDVQQGEwJD\n" +
            "TjEwMC4GA1UECgwnQ2hpbmEgRmluYW5jaWFsIENlcnRpZmljYXRpb24gQXV0aG9y\n" +
            "aXR5MSAwHgYDVQQDDBdDRkNBIEFDUyBURVNUIFNNMiBPQ0EzMTAeFw0yMzAxMTcw\n" +
            "MjQ3MTlaFw0yNDAxMTcwMjQ3MTlaMIGSMQswCQYDVQQGEwJDTjEgMB4GA1UECgwX\n" +
            "Q0ZDQSBBQ1MgVEVTVCBTTTIgT0NBMzExETAPBgNVBAsMCExvY2FsIFJBMRkwFwYD\n" +
            "VQQLDBBPcmdhbml6YXRpb25hbC0yMTMwMQYDVQQDDCowNTFANzBTSEFOR0hVTUlO\n" +
            "RzcwQE45MTM3MDEwME1BM1FBQk00M1lAMTQwWTATBgcqhkjOPQIBBggqgRzPVQGC\n" +
            "LQNCAAQ44P0UECRcuoxqcJbP692K0wlwwQenEPvsRwkwNAt8rfhsKLLlcrvXRbew\n" +
            "gnKKre3irNjeE2+cwX+9KkQNqYECo4H7MIH4MD8GCCsGAQUFBwEBBDMwMTAvBggr\n" +
            "BgEFBQcwAYYjaHR0cDovL29jc3B0ZXN0LmNmY2EuY29tLmNuOjgwL29jc3AwHwYD\n" +
            "VR0jBBgwFoAUBMe8+VkBaT6MNDYgYhg83ry1uwwwDAYDVR0TAQH/BAIwADA4BgNV\n" +
            "HR8EMTAvMC2gK6AphidodHRwOi8vMjEwLjc0LjQyLjMvT0NBMzEvU00yL2NybDIw\n" +
            "Mi5jcmwwDgYDVR0PAQH/BAQDAgM4MB0GA1UdDgQWBBQAmxlR8TRdldFkOo8906cC\n" +
            "rJU+KTAdBgNVHSUEFjAUBggrBgEFBQcDAgYIKwYBBQUHAwQwDAYIKoEcz1UBg3UF\n" +
            "AANHADBEAiAar5/rKRNXX7QOCE2V8Y8Qoosfn1uV8EmruJgWcJfEcAIgCLfpvciV\n" +
            "wt1rQBFAVP90pZDm99Ul8ESGCfVeQ5AQMr8=";
    /**
     * 支付平台加密公钥（商户使用该公钥对请求报文加密）
     */
    static final String payCenterPublicKey = "MIIC5zCCAougAwIBAgIFEEgICCcwDAYIKoEcz1UBg3UFADBcMQswCQYDVQQGEwJD\n" +
            "TjEwMC4GA1UECgwnQ2hpbmEgRmluYW5jaWFsIENlcnRpZmljYXRpb24gQXV0aG9y\n" +
            "aXR5MRswGQYDVQQDDBJDRkNBIFRFU1QgU00yIE9DQTEwHhcNMjIwMjA4MDgwODQ0\n" +
            "WhcNMjIwODA4MDgwODQ0WjCBizELMAkGA1UEBhMCQ04xDDAKBgNVBAoMA0JPQzET\n" +
            "MBEGA1UECwwKQ0ZDQVRlY2hURTEZMBcGA1UECwwQT3JnYW5pemF0aW9uYWwtMjE+\n" +
            "MDwGA1UEAww1Q0ZDQVRlY2hURUDkv6HogZTmlK/ku5jlm73lr4blj4zor4HmtYvo\n" +
            "r5VAWjExMTExMTExQDEwWTATBgcqhkjOPQIBBggqgRzPVQGCLQNCAASCdc6ecId5\n" +
            "Ida3w8yOnsZLfLB1szIwCbsi1hTA82TwVNB3PbPtVTW/uEGjkQHXPXqt8daRhy31\n" +
            "c2y+nR3geumeo4IBBjCCAQIwHwYDVR0jBBgwFoAUa/4Y2o9COqa4bbMuiIM6NKLB\n" +
            "MOEwDAYDVR0TAQH/BAIwADBIBgNVHSAEQTA/MD0GCGCBHIbvKgEBMDEwLwYIKwYB\n" +
            "BQUHAgEWI2h0dHA6Ly93d3cuY2ZjYS5jb20uY24vdXMvdXMtMTQuaHRtMDkGA1Ud\n" +
            "HwQyMDAwLqAsoCqGKGh0dHA6Ly91Y3JsLmNmY2EuY29tLmNuL1NNMi9jcmwyOTkx\n" +
            "NS5jcmwwDgYDVR0PAQH/BAQDAgM4MB0GA1UdDgQWBBRVupUbJ0iIb3kNLtlLmR5E\n" +
            "HaHwQTAdBgNVHSUEFjAUBggrBgEFBQcDAgYIKwYBBQUHAwQwDAYIKoEcz1UBg3UF\n" +
            "AANIADBFAiApwzA/aPHiNsq2KGCSSXaGDbNC4dzUXUXLoaaVMmcdmwIhAOIG6mhk\n" +
            "90ovF9izic2Tyja4GV0WXOYdYkkoutjl0hRF";
    /**
     * 支付平台网关地址
     */
    static String PAY_CENTER_GATEWAY = "https://testrans.xlpayment.com/";
    //敏感信息使用sm4加密

    //合作伙伴id 通过注册后获得的
    static String partnerId="1656438344850440193";

    private String common(Map<String, String> business, String bizType, String path,String keyId) {
        business.put("timestamp", System.currentTimeMillis() + "");
        business.put("random", UUID.fastUUID().toString(true));
        business.put("signType", "SM2");
        business.put("keyId", keyId);
        business.put("versionNo", "1.0.0");
        business.put("bizType", bizType);
        String signature = "";
        try {
            //使用sm2加密生成签名
            signature = GuoMISignUtils.getSignature(business, merSm2KeyText, sm2Pass);
        } catch (Exception e) {
            log.error("出现异常", e);
            throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(), "签名失败");
        }
        business.put("signature", signature);//签名
        log.info("请求的地址:{}", PAY_CENTER_GATEWAY + path);
        log.info("请求的参数:{}", business);
        //使用平台的公钥进行加密
        String requestData = "";
        try {
            requestData = GuoMiCryptoUtils.sm2AndSm4Encrypt(payCenterPublicKey, JsonUtils.toJson(business));

          /*  String keyId=GuoMiCryptoUtils.sm2AndSm4Encrypt(payCenterPublicKey,"ae06b5c8ffa73bc3bdb83c193082010a");
            log.info("keyId:{}",keyId);*/
        } catch (Exception e) {
            log.error("出现异常", e);
            throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(), "请求报文加密失败");
        }
        log.info("请求数据加密:{}", requestData);
        String resBody = "";
        try {
            HttpResponse response = cn.hutool.http.HttpUtil.createPost(PAY_CENTER_GATEWAY + path)
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
        String resBodyDecrypt="";
        try {
            resBodyDecrypt=GuoMiCryptoUtils.sm2AndSm4Decrypt(merSm2DecKeyFile, resBody, sm2Pass);
            log.info("响应数据解密后：{}", resBodyDecrypt);
        }catch (Exception e){
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
        }catch (Exception e){
            log.error("验签异常",e);
        }
        return resBodyDecrypt;
    }


    @Test
    public void registerTest() {
        try {
            String keyId="ae06b5c8ffa73bc3bdb83c193082010a";
            Map<String, String> business = new HashMap<>();
            business.put("partnerId", "1643703350196977666");
            business.put("orderId", "111111");
            business.put("username", GuoMIEncryptUtil.demoSM4EncryptMessage(GuoMIEncryptUtil.getSession(), "18607115128",keyId));//使用sm4加密
            business.put("loginPwd", GuoMIEncryptUtil.demoSM4EncryptMessage(GuoMIEncryptUtil.getSession(), "12345qa!",keyId));//使用sm4加密
            business.put("merName", "测试商户");//商户名称
            business.put("informUrl", "https://willcard.com.cn/asy/opentest");//通知地址
            String  respBody=common(business, "PosMerApiRegist", "/api/wc/payTransaction",keyId);
            JSONObject respData=JSONObject.parseObject(respBody);
            JSONObject data=respData.getJSONObject("data");
            if(data!=null&& !StringUtils.isEmpty(data.getString("merCstNo"))){
                log.info("开户成功:{}",data.getString("merCstNo"));
            }else{
                log.info("开户失败:");
            }
            //{"code":200,"data":{"merCstNo":"1656319357076471813"}}
        } catch (Exception e) {
            log.error("出现异常", e);
        }
    }


    /**
     * 文件申请
     */
    @Test
    public void applyTest() {
        try {
            String keyId="ae06b5c8ffa73bc3bdb83c193082010a";
            Map<String, String> business = new HashMap<>();
//            business.put("partnerId", "1643703350196977666");//之前用的
            business.put("partnerId", "1656438344850440193");

            business.put("checkDt","2023-12-05");//
            //文件类型 01-收单类 03-付款
            business.put("billType", "01");//
            //CheckPayOrder-收单对账文件
            String  respBody=common(business, "CheckPayOrder", "/api/wc/payTransaction",keyId);
            JSONObject respData=JSONObject.parseObject(respBody);
            JSONObject data=respData.getJSONObject("data");
            //{"downloadUrl":"https://testrans.xlpayment.com/api/oss/merBill/2023-12-05/1656438344850440193_20231205013009_01.txt","downloadToken":"b7a652d5c8b252b0324915abd67f98267c7180db226fcbaff6ee50bf4d5a105b","fileMac":"aa912de994c493926faf2b5059de5e67","partnerId":"1656438344850440193"}
            if(data!=null&& !StringUtils.isEmpty(data.getString("downloadUrl"))){
                log.info("申请成功,downloadUrl:{}",data.getString("downloadUrl"));
                log.info("downloadToken:{}",data.getString("downloadToken"));
            }else{
                log.info("申请失败:");
            }
            //{"code":200,"data":{"merCstNo":"1656319357076471813"}}
        } catch (Exception e) {
            log.error("出现异常", e);
        }
    }

    /**
     * 付款对账文件申请 D0 调用的是1.52接口 billType传03，bizType传CheckPaymentOrder
     * @param date  2023-12-04
     * @param partnerId  合作伙伴id 信联唯一商户号 channelMchtNo
     */
    public Map<String,String> applyCheckPaymentOrderTest(String date,String partnerId) {
        Map<String,String> map=new HashMap<>();
        try {
            String keyId="ae06b5c8ffa73bc3bdb83c193082010a";
            Map<String, String> business = new HashMap<>();
            business.put("partnerId", partnerId);
            business.put("checkDt",date);//yyyy-MM-dd
            //文件类型 01-收单类 03-付款
            business.put("billType", "03");
            //CheckPayOrder-收单对账文件
            String  respBody=common(business, "CheckPaymentOrder", "/api/wc/payTransaction",keyId);
            JSONObject respData=JSONObject.parseObject(respBody);
            JSONObject data=respData.getJSONObject("data");
            //{"downloadUrl":"https://testrans.xlpayment.com/api/oss/merBill/2023-12-05/1656438344850440193_20231205013009_01.txt","downloadToken":"b7a652d5c8b252b0324915abd67f98267c7180db226fcbaff6ee50bf4d5a105b","fileMac":"aa912de994c493926faf2b5059de5e67","partnerId":"1656438344850440193"}
            if(data!=null&& !StringUtils.isEmpty(data.getString("downloadUrl"))){
                log.info("申请成功,downloadUrl:{}",data.getString("downloadUrl"));
                log.info("downloadToken:{}",data.getString("downloadToken"));
                map.put("downloadUrl",data.getString("downloadUrl"));
                map.put("downloadToken",data.getString("downloadToken"));
                return map;
            }else{
                log.info("申请失败:{}",data);
            }
            //{"code":200,"signature":"MIID/wYKKoEcz1UGAQQCAqCCA+8wggPrAgEBMQ4wDAYIKoEcz1UBgxEFADARBgoqgRzPVQYBBAIBoAMEAWOgggLrMIIC5zCCAougAwIBAgIFEEgICCYwDAYIKoEcz1UBg3UFADBcMQswCQYDVQQGEwJDTjEwMC4GA1UECgwnQ2hpbmEgRmluYW5jaWFsIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MRswGQYDVQQDDBJDRkNBIFRFU1QgU00yIE9DQTEwHhcNMjIwMjA4MDgwODQ0WhcNMjIwODA4MDgwODQ0WjCBizELMAkGA1UEBhMCQ04xDDAKBgNVBAoMA0JPQzETMBEGA1UECwwKQ0ZDQVRlY2hURTEZMBcGA1UECwwQT3JnYW5pemF0aW9uYWwtMjE+MDwGA1UEAww1Q0ZDQVRlY2hURUDkv6HogZTmlK/ku5jlm73lr4blj4zor4HmtYvor5VAWjExMTExMTExQDEwWTATBgcqhkjOPQIBBggqgRzPVQGCLQNCAAR3CJx7gJheFkuIyrd9MkDU+fYXa2p/GX6+S3bwfzVR1T5NhpJzo9NKt0AjuGKUnJ5/2pMA6RqpvX79EiO2MQSoo4IBBjCCAQIwHwYDVR0jBBgwFoAUa/4Y2o9COqa4bbMuiIM6NKLBMOEwDAYDVR0TAQH/BAIwADBIBgNVHSAEQTA/MD0GCGCBHIbvKgEBMDEwLwYIKwYBBQUHAgEWI2h0dHA6Ly93d3cuY2ZjYS5jb20uY24vdXMvdXMtMTQuaHRtMDkGA1UdHwQyMDAwLqAsoCqGKGh0dHA6Ly91Y3JsLmNmY2EuY29tLmNuL1NNMi9jcmwyOTkxNS5jcmwwDgYDVR0PAQH/BAQDAgbAMB0GA1UdDgQWBBSZQYQ90WdD82Dt3CiE1anENsJQGjAdBgNVHSUEFjAUBggrBgEFBQcDAgYIKwYBBQUHAwQwDAYIKoEcz1UBg3UFAANIADBFAiEArrWzDB2I+z6jHswZJx6z3q7cgavXs4aq1K2mu+fV3doCIFskV5SJho4H7r8ub32dOryrpX4UR30m1Ul8mkXTCXhvMYHTMIHQAgEBMGUwXDELMAkGA1UEBhMCQ04xMDAuBgNVBAoMJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEbMBkGA1UEAwwSQ0ZDQSBURVNUIFNNMiBPQ0ExAgUQSAgIJjAMBggqgRzPVQGDEQUAMA0GCSqBHM9VAYItAQUABEcwRQIgbMJa5LFAho1FzlN+24nfTubfVu1STuxlhwzd6GZ9PjYCIQDwkwMFB388ifjC83yGy5yQnj4aDKcNCeR64ywneEFshg==","message":"无可下载项","success":false,"signType":"SM2","status":"RRB-08000057"}
            //{"code":200,"data":{"merCstNo":"1656319357076471813"}}
        } catch (Exception e) {
            log.error("出现异常", e);
        }
        return map;
    }

    /**
     * 付款对账文件申请 T1 调用的是1.51接口 billType传01，bizType传CheckPayOrder
     * @param date  2023-12-04
     * @param partnerId  合作伙伴id 信联唯一商户号 channelMchtNo
     */
    public Map<String,String> applyCheckPayOrderTest(String date,String partnerId) {
        Map<String,String> map=new HashMap<>();
        try {
            String keyId="ae06b5c8ffa73bc3bdb83c193082010a";
            Map<String, String> business = new HashMap<>();
            business.put("partnerId", partnerId);
            business.put("checkDt",date);//yyyy-MM-dd
            //文件类型 01-收单类 03-付款
            business.put("billType", "01");
            //CheckPayOrder-收单对账文件
            String  respBody=common(business, "CheckPayOrder", "/api/wc/payTransaction",keyId);
            JSONObject respData=JSONObject.parseObject(respBody);
            JSONObject data=respData.getJSONObject("data");
            //{"downloadUrl":"https://testrans.xlpayment.com/api/oss/merBill/2023-12-05/1656438344850440193_20231205013009_01.txt","downloadToken":"b7a652d5c8b252b0324915abd67f98267c7180db226fcbaff6ee50bf4d5a105b","fileMac":"aa912de994c493926faf2b5059de5e67","partnerId":"1656438344850440193"}
            if(data!=null&& !StringUtils.isEmpty(data.getString("downloadUrl"))){
                log.info("申请成功,downloadUrl:{}",data.getString("downloadUrl"));
                log.info("downloadToken:{}",data.getString("downloadToken"));
                map.put("downloadUrl",data.getString("downloadUrl"));
                map.put("downloadToken",data.getString("downloadToken"));
                return map;
            }else{
                log.info("申请失败:");
            }
            //{"code":200,"signature":"MIID/wYKKoEcz1UGAQQCAqCCA+8wggPrAgEBMQ4wDAYIKoEcz1UBgxEFADARBgoqgRzPVQYBBAIBoAMEAWOgggLrMIIC5zCCAougAwIBAgIFEEgICCYwDAYIKoEcz1UBg3UFADBcMQswCQYDVQQGEwJDTjEwMC4GA1UECgwnQ2hpbmEgRmluYW5jaWFsIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MRswGQYDVQQDDBJDRkNBIFRFU1QgU00yIE9DQTEwHhcNMjIwMjA4MDgwODQ0WhcNMjIwODA4MDgwODQ0WjCBizELMAkGA1UEBhMCQ04xDDAKBgNVBAoMA0JPQzETMBEGA1UECwwKQ0ZDQVRlY2hURTEZMBcGA1UECwwQT3JnYW5pemF0aW9uYWwtMjE+MDwGA1UEAww1Q0ZDQVRlY2hURUDkv6HogZTmlK/ku5jlm73lr4blj4zor4HmtYvor5VAWjExMTExMTExQDEwWTATBgcqhkjOPQIBBggqgRzPVQGCLQNCAAR3CJx7gJheFkuIyrd9MkDU+fYXa2p/GX6+S3bwfzVR1T5NhpJzo9NKt0AjuGKUnJ5/2pMA6RqpvX79EiO2MQSoo4IBBjCCAQIwHwYDVR0jBBgwFoAUa/4Y2o9COqa4bbMuiIM6NKLBMOEwDAYDVR0TAQH/BAIwADBIBgNVHSAEQTA/MD0GCGCBHIbvKgEBMDEwLwYIKwYBBQUHAgEWI2h0dHA6Ly93d3cuY2ZjYS5jb20uY24vdXMvdXMtMTQuaHRtMDkGA1UdHwQyMDAwLqAsoCqGKGh0dHA6Ly91Y3JsLmNmY2EuY29tLmNuL1NNMi9jcmwyOTkxNS5jcmwwDgYDVR0PAQH/BAQDAgbAMB0GA1UdDgQWBBSZQYQ90WdD82Dt3CiE1anENsJQGjAdBgNVHSUEFjAUBggrBgEFBQcDAgYIKwYBBQUHAwQwDAYIKoEcz1UBg3UFAANIADBFAiEArrWzDB2I+z6jHswZJx6z3q7cgavXs4aq1K2mu+fV3doCIFskV5SJho4H7r8ub32dOryrpX4UR30m1Ul8mkXTCXhvMYHTMIHQAgEBMGUwXDELMAkGA1UEBhMCQ04xMDAuBgNVBAoMJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEbMBkGA1UEAwwSQ0ZDQSBURVNUIFNNMiBPQ0ExAgUQSAgIJjAMBggqgRzPVQGDEQUAMA0GCSqBHM9VAYItAQUABEcwRQIgbMJa5LFAho1FzlN+24nfTubfVu1STuxlhwzd6GZ9PjYCIQDwkwMFB388ifjC83yGy5yQnj4aDKcNCeR64ywneEFshg==","message":"无可下载项","success":false,"signType":"SM2","status":"RRB-08000057"}
            //{"code":200,"data":{"merCstNo":"1656319357076471813"}}
        } catch (Exception e) {
            log.error("出现异常", e);
        }
        return null;
    }

    /**
     * 文件下载
     */
    @Test
    public void downloadFileTest() throws Exception{
        //下载日期
        String date="2023-12-06";
//        Map<String, String> map = applyCheckPaymentOrderTest(date,partnerId);
        Map<String, String> map = applyCheckPayOrderTest(date,partnerId);
        if (StrUtil.isNotEmpty(map.get("downloadUrl"))){
            //        String url = "https://testrans.xlpayment.com/api/oss/merBill/2023-12-06/1656438344850440193_20231206013010_01.txt";
            String url =map.get("downloadUrl");
            String downloadToken = map.get("downloadToken");
            String fileName=partnerId+"_"+date+"_"+"01"+".txt";;
            downloadFile(url, downloadToken, "temp2", fileName);
        }else {
            log.info("申请文件失败");
        }
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
        TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkClientTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
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
     * 解析文件
     */
    @Test
    public void parseTextTest() {
        String filePath = "temp2/1656438344850440193_20231205013009_01.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] firstHeaders = null;
            String[] secondHeaders = null;
            int lineNum=1;
            //第一种标题格式
            ArrayList<String> firstHeaderList=new ArrayList<>();
            ArrayList<String> firstHeaderValueList=new ArrayList<>();
            Map<String,String> firstHeaderMap=new HashMap<>();
            //第二种标题格式
            ArrayList<String> secondHeaderList=new ArrayList<>();
            ArrayList<ArrayList> secondHeaderValueListList=new ArrayList<>();
            while ((line = br.readLine()) != null) {
                if (lineNum==1) {
                    // 处理第一种标题行
                    firstHeaders = line.split("\\|",-1);
                    firstHeaderList=new ArrayList(Arrays.asList(firstHeaders));
                }else if (lineNum==2){
                    //处理第一种标题行数据行
                    String[] firstFields = line.split("\\|");
                    firstHeaderValueList=new ArrayList(Arrays.asList(firstFields));
                    for (int i = 0; i < firstHeaderList.size(); i++) {
                        //标题行和数据对应
                        firstHeaderMap.put(firstHeaderList.get(i),firstHeaderValueList.get(i));
                    }
                }else if (lineNum==3){
                    // 处理第2种标题行
                    secondHeaders = line.split("\\|");
                    secondHeaderList=new ArrayList(Arrays.asList(secondHeaders));
                    secondHeaderValueListList=new ArrayList<>(secondHeaderList.size());
                    // 创建 secondHeaders.length 个空的 ArrayList
                    for (int i = 0; i < secondHeaders.length; i++) {
                        secondHeaderValueListList.add(new ArrayList<>());
                    }
                }else {
                    // 处理第2种标题行和数据
                    String[] secondFields = line.split("\\|",-1);
                    // 将标题行的数据和数据行的数据对应起来
                    Map<String, String> dataMap = new HashMap<>();
                    for (int i = 0; i < secondHeaders.length; i++) {
                        secondHeaderValueListList.get(i).add(secondFields[i]);
                       log.info("secondHeaders:{},secondFields:{}", secondHeaders[i],secondFields[i]);
                    }
                }
                lineNum++;
            }

            log.info("firstHeaderMap:{}，secondHeaderValueListList：{}",firstHeaderMap,secondHeaderValueListList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

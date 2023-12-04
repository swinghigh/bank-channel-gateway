package com.jkf.channel.gateway.test;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

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


}

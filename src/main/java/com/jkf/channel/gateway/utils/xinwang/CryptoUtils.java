package com.jkf.channel.gateway.utils.xinwang;

import cfca.sadk.algorithm.common.Mechanism;
import cfca.sadk.algorithm.common.PKIException;
import cfca.sadk.algorithm.sm2.SM2PublicKey;
import cfca.sadk.lib.crypto.JCrypto;
import cfca.sadk.lib.crypto.Session;
import cfca.sadk.org.bouncycastle.jce.provider.BouncyCastleProvider;
import cfca.sadk.tls.kse.KeystoreUtils;
import cfca.sadk.tls.sun.security.ssl.JSSEProvider;
import cfca.sadk.util.CertUtil;
import cfca.sadk.util.EncryptUtil;
import cfca.sadk.util.EnvelopeUtil;
import cfca.sadk.util.KeyUtil;
import cfca.sadk.x509.certificate.X509Cert;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.RandomUtil;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Security;

/**
 * 新网   对请求数据加密，解密 工具类
 * @author Vensin
 * @Classname CryptoUtils
 * @Date 2022/4/18 2:32 PM
 * @Created by Vensin
 */
public class CryptoUtils {

    private static final String BASE_STRING = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 生成SM4秘钥
     *
     * @return
     */
    public static String generateSm4SecretKey() {

        return RandomUtil.randomString(BASE_STRING, 16);
    }
    /**
     * sm2加密
     *
     * @param publicKeyBase64 公钥base64
     * @param plainData    待加密数据
     * @return
     */
    public static String sm2AndSm4Encrypt(String publicKeyBase64, String plainData) throws PKIException, UnsupportedEncodingException {

        // 加密库初始化
        String deviceName = JCrypto.JSOFT_LIB;
        JCrypto.getInstance().initialize(deviceName, null);
        Session session = JCrypto.getInstance().openSession(deviceName);
        X509Cert encryptCert = new X509Cert(Base64.decode(publicKeyBase64));
        byte[] cmsEnvelopedDataBase64 = EnvelopeUtil.envelopeMessage(plainData.getBytes(StandardCharsets.UTF_8), Mechanism.SM4_CBC, new X509Cert[] { encryptCert }, session);

        return new String(cmsEnvelopedDataBase64);

    }

    /**
     * 数字信封解密
     * @param sm2FileText   商户解密私钥（用于支付机构响应回来的报文解密）
     * @param plainData 原数据
     * @param sm2FilePass   商户自行生成的 sm2 签名私钥
     * @return
     * @throws PKIException
     * @throws UnsupportedEncodingException
     */
    public static String sm2AndSm4Decrypt(String sm2FileText, String plainData,String sm2FilePass) throws PKIException, UnsupportedEncodingException {
        String deviceName = JCrypto.JSOFT_LIB;
        JCrypto.getInstance().initialize(deviceName, null);
        Session session = JCrypto.getInstance().openSession(deviceName);
        X509Cert encryptCert = CertUtil.getCertFromSM2(sm2FileText.getBytes());
        PrivateKey decryptPriKey = KeyUtil.getPrivateKeyFromSM2(sm2FileText.getBytes(), sm2FilePass);
        byte[] decryptData = EnvelopeUtil.openEvelopedMessage(plainData.getBytes(StandardCharsets.UTF_8), decryptPriKey, encryptCert, session);

        return new String(decryptData);

    }
    /**
     * sm2加密
     *
     * @param publicKeyHex 公钥16进制串
     * @param plainData    待加密数据
     * @return
     */
    public static String sm2Encrypt(String publicKeyHex, String plainData) throws PKIException, UnsupportedEncodingException {


        // 加密库初始化
        String deviceName = JCrypto.JSOFT_LIB;
        JCrypto.getInstance().initialize(deviceName, null);
        Session session = JCrypto.getInstance().openSession(deviceName);

        final Mechanism mechanism = new Mechanism(Mechanism.SM2);

        byte[] bytes = HexUtil.decodeHex(publicKeyHex);
        SM2PublicKey publicKey = new SM2PublicKey(bytes);
        // SM2公钥加密：长度通常限定为136字节内
        byte[] base64Bytes = EncryptUtil.encrypt(mechanism, publicKey, plainData.getBytes(StandardCharsets.UTF_8), session);

        return new String(base64Bytes);

    }

    /**
     * SM4 加密
     *
     * @param secretKey SM4秘钥串
     * @param plainData 待加密数据
     * @return
     */
    public static String sm4Encrypt(String secretKey, String plainData) throws PKIException {


        // 加密库初始化
        String deviceName = JCrypto.JSOFT_LIB;
        JCrypto.getInstance().initialize(deviceName, null);
        Session session = JCrypto.getInstance().openSession(deviceName);

        Key key = KeyUtil.generateKey(new Mechanism(Mechanism.SM4_KEY), secretKey.getBytes(StandardCharsets.UTF_8));
        byte[] encrypt = EncryptUtil.encrypt(new Mechanism(Mechanism.SM4_ECB), key, plainData.getBytes(StandardCharsets.UTF_8), session);

        return new String(encrypt);
    }

    public static String sm2Decrypt(String cipherText, String encKey, String sm2Pass) throws PKIException, UnsupportedEncodingException {

        // 加密库初始化
        String deviceName = JCrypto.JSOFT_LIB;
        JCrypto.getInstance().initialize(deviceName, null);
        Session session = JCrypto.getInstance().openSession(deviceName);
        final Mechanism mechanism = new Mechanism(Mechanism.SM2);
        PrivateKey priKey = KeyUtil.getPrivateKeyFromSM2(encKey.getBytes(), sm2Pass);
        // SM2私钥解密：长度通常限定为136字节内
        byte[] decryptText = EncryptUtil.decrypt(mechanism, priKey, cipherText.getBytes(StandardCharsets.UTF_8), session);
        return new String(decryptText, StandardCharsets.UTF_8);
    }

    public static PreferredSSLSocketFactory buildPreferredSSLSocketFactory(String gmTrustCertBase64) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        X509Cert[] x509Certs = new X509Cert[]{new X509Cert(Base64.decode(gmTrustCertBase64))};
        TrustManager[] trustManagers = KeystoreUtils.INSTANCE.buildTrustManager(x509Certs);
        SSLContext sslContext = SSLContext.getInstance("GMTLSv1.1", JSSEProvider.getInstance());
        sslContext.init(null, trustManagers, new SecureRandom());
        return new PreferredSSLSocketFactory(sslContext.getSocketFactory());
    }

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


    public static void main(String[] args) throws PKIException, UnsupportedEncodingException {

        try {
            //加密
            //待加密数据 plainData
            String plainData="{\"currencyType\":\"CNY\",\"bizType\":\"TransactionQuery\",\"signature\":\"MIID/wYKKoEcz1UGAQQCAqCCA+8wggPrAgEBMQ4wDAYIKoEcz1UBgxEFADAMBgoqgRzPVQYBBAIBoIIC6jCCAuYwggKLoAMCAQICBUBEl2CDMAwGCCqBHM9VAYN1BQAwYTELMAkGA1UEBhMCQ04xMDAuBgNVBAoMJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEgMB4GA1UEAwwXQ0ZDQSBBQ1MgVEVTVCBTTTIgT0NBMzEwHhcNMjMwMTE3MDI1MDU0WhcNMjQwMTE3MDI1MDU0WjCBkjELMAkGA1UEBhMCQ04xIDAeBgNVBAoMF0NGQ0EgQUNTIFRFU1QgU00yIE9DQTMxMREwDwYDVQQLDAhMb2NhbCBSQTEZMBcGA1UECwwQT3JnYW5pemF0aW9uYWwtMjEzMDEGA1UEAwwqMDUxQDcwU0hBTkdIVU1JTkc3MEBOOTEzNzAxMDBNQTNRQUJNNDNZQDE1MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEDB/jiyrUFo2UiQ7VmrBykWmv7MUEw4Tgv64if/RLBC6K/fMc+bL3VLIp2XK6bua4D6eHH8OqePRxpRKyGOxWYaOB+zCB+DA/BggrBgEFBQcBAQQzMDEwLwYIKwYBBQUHMAGGI2h0dHA6Ly9vY3NwdGVzdC5jZmNhLmNvbS5jbjo4MC9vY3NwMB8GA1UdIwQYMBaAFATHvPlZAWk+jDQ2IGIYPN68tbsMMAwGA1UdEwEB/wQCMAAwOAYDVR0fBDEwLzAtoCugKYYnaHR0cDovLzIxMC43NC40Mi4zL09DQTMxL1NNMi9jcmwyMDIuY3JsMA4GA1UdDwEB/wQEAwIGwDAdBgNVHQ4EFgQUeDG21Bzg7ROTyuarDXJJuZLq1pswHQYDVR0lBBYwFAYIKwYBBQUHAwIGCCsGAQUFBwMEMAwGCCqBHM9VAYN1BQADRwAwRAIgD358NlvcL7tCg2NQx1PEe282KX7dAq1/g/alZlN8EacCIBG8ikLjj80zn1RmNYqdxKm4nLh/KHXVm01yYqTKAsXOMYHZMIHWAgEBMGowYTELMAkGA1UEBhMCQ04xMDAuBgNVBAoMJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEgMB4GA1UEAwwXQ0ZDQSBBQ1MgVEVTVCBTTTIgT0NBMzECBUBEl2CDMAwGCCqBHM9VAYMRBQAwDQYJKoEcz1UBgi0BBQAESDBGAiEArqkswxzpdwrGl0Mj83GmCrs3Bdbk1qWVCBJr/zH4enkCIQDdJFBx1ASw4Sa+4ZOt8vPsgVscvXZ2rofw/sTqRsstKw==\",\"trxCtgy\":\"2001\",\"random\":\"79fcbcc2619e425d94e28f3371c3e199\",\"oriOrderId\":\"36f0bf66be8644d9b7b70c13e3c8d574\",\"versionNo\":\"1.0.0\",\"signType\":\"SM2\",\"partnerId\":\"1465282209618804736\",\"signMethod\":\"02\",\"timestamp\":1701414673431}";
            String encData = sm2AndSm4Encrypt(payCenterPublicKey, plainData);
            //需要的结果： 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
            System.out.println("encData:"+encData);
            //请求。。。

            //返回结果
            //解密
            //解密数据
            String cipherText = "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\n";
            //数字信封解密
            String decryptData = sm2AndSm4Decrypt(merSm2DecKeyFile, cipherText, "xlzf1234");
            //响应数据解密后需要为： {"code":200,"signature":"MIID/gYKKoEcz1UGAQQCAqCCA+4wggPqAgEBMQ4wDAYIKoEcz1UBgxEFADARBgoqgRzPVQYBBAIBoAMEAWOgggLrMIIC5zCCAougAwIBAgIFEEgICCYwDAYIKoEcz1UBg3UFADBcMQswCQYDVQQGEwJDTjEwMC4GA1UECgwnQ2hpbmEgRmluYW5jaWFsIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MRswGQYDVQQDDBJDRkNBIFRFU1QgU00yIE9DQTEwHhcNMjIwMjA4MDgwODQ0WhcNMjIwODA4MDgwODQ0WjCBizELMAkGA1UEBhMCQ04xDDAKBgNVBAoMA0JPQzETMBEGA1UECwwKQ0ZDQVRlY2hURTEZMBcGA1UECwwQT3JnYW5pemF0aW9uYWwtMjE+MDwGA1UEAww1Q0ZDQVRlY2hURUDkv6HogZTmlK/ku5jlm73lr4blj4zor4HmtYvor5VAWjExMTExMTExQDEwWTATBgcqhkjOPQIBBggqgRzPVQGCLQNCAAR3CJx7gJheFkuIyrd9MkDU+fYXa2p/GX6+S3bwfzVR1T5NhpJzo9NKt0AjuGKUnJ5/2pMA6RqpvX79EiO2MQSoo4IBBjCCAQIwHwYDVR0jBBgwFoAUa/4Y2o9COqa4bbMuiIM6NKLBMOEwDAYDVR0TAQH/BAIwADBIBgNVHSAEQTA/MD0GCGCBHIbvKgEBMDEwLwYIKwYBBQUHAgEWI2h0dHA6Ly93d3cuY2ZjYS5jb20uY24vdXMvdXMtMTQuaHRtMDkGA1UdHwQyMDAwLqAsoCqGKGh0dHA6Ly91Y3JsLmNmY2EuY29tLmNuL1NNMi9jcmwyOTkxNS5jcmwwDgYDVR0PAQH/BAQDAgbAMB0GA1UdDgQWBBSZQYQ90WdD82Dt3CiE1anENsJQGjAdBgNVHSUEFjAUBggrBgEFBQcDAgYIKwYBBQUHAwQwDAYIKoEcz1UBg3UFAANIADBFAiEArrWzDB2I+z6jHswZJx6z3q7cgavXs4aq1K2mu+fV3doCIFskV5SJho4H7r8ub32dOryrpX4UR30m1Ul8mkXTCXhvMYHSMIHPAgEBMGUwXDELMAkGA1UEBhMCQ04xMDAuBgNVBAoMJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEbMBkGA1UEAwwSQ0ZDQSBURVNUIFNNMiBPQ0ExAgUQSAgIJjAMBggqgRzPVQGDEQUAMA0GCSqBHM9VAYItAQUABEYwRAIgcWTQVqei7sCJ/jZfBmCOTt5RSrVN+t5jIZSbuhFl/e0CICqB76/sNN6UXEW9NqD3AeXKTn8fjh6hsAPCx3SnPpo6","message":"订单不存在","success":false,"signType":"SM2","status":"RRB-02000007"}
            System.out.println("decryptData:"+decryptData);
        } catch (PKIException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }


}

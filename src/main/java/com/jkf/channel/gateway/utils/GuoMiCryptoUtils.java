package com.jkf.channel.gateway.utils;

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
 * @author Vensin
 * @Classname CryptoUtils
 * @Date 2022/4/18 2:32 PM
 * @Created by Vensin
 */
public class GuoMiCryptoUtils {

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
     * @param sm2FileText
     * @param plainData
     * @param sm2FilePass
     * @return
     * @throws PKIException
     * @throws UnsupportedEncodingException
     */
    public static String sm2AndSm4Decrypt(String sm2FileText, String plainData, String sm2FilePass) throws PKIException, UnsupportedEncodingException {
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


    public static void main(String[] args) throws PKIException, UnsupportedEncodingException {

        try {
            String encKey = "MIIDSQIBATBHBgoqgRzPVQYBBAIBBgcqgRzPVQFoBDD/KRx84DTgdR8dcHFvQ2RObJYq07ERGTKotGTKv5Ksl9gJOHT3XBNbaYCsDMgRHUwwggL5BgoqgRzPVQYBBAIBBIIC6TCCAuUwggKKoAMCAQICBUA4RWeBMAwGCCqBHM9VAYN1BQAwYTELMAkGA1UEBhMCQ04xMDAuBgNVBAoMJ0NoaW5hIEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTEgMB4GA1UEAwwXQ0ZDQSBBQ1MgVEVTVCBTTTIgT0NBMzEwHhcNMjIwNDExMDcyNTI2WhcNMjMwNDExMDcyNTI2WjCBkTELMAkGA1UEBhMCQ04xIDAeBgNVBAoMF0NGQ0EgQUNTIFRFU1QgU00yIE9DQTMxMREwDwYDVQQLDAhMb2NhbCBSQTEZMBcGA1UECwwQT3JnYW5pemF0aW9uYWwtMjEyMDAGA1UEAwwpMDUxQDcwU0hBTkdIVU1JTkc3MEBOOTEzNzAxMDBNQTNRQUJNNDNZQDgwWTATBgcqhkjOPQIBBggqgRzPVQGCLQNCAATwJ7I5bijPKKXC+uwKSgURnBeOO3kf5wodVAOvbouJaz8tTwFDU4gtfTfUMAyZiGf7n2Ijs42nRlVoldpRgkf1o4H7MIH4MD8GCCsGAQUFBwEBBDMwMTAvBggrBgEFBQcwAYYjaHR0cDovL29jc3B0ZXN0LmNmY2EuY29tLmNuOjgwL29jc3AwHwYDVR0jBBgwFoAUBMe8+VkBaT6MNDYgYhg83ry1uwwwDAYDVR0TAQH/BAIwADA4BgNVHR8EMTAvMC2gK6AphidodHRwOi8vMjEwLjc0LjQyLjMvT0NBMzEvU00yL2NybDE2NS5jcmwwDgYDVR0PAQH/BAQDAgM4MB0GA1UdDgQWBBRAyfwKkZhaQcj//LFGbdXaygmAlzAdBgNVHSUEFjAUBggrBgEFBQcDAgYIKwYBBQUHAwQwDAYIKoEcz1UBg3UFAANHADBEAiAZRuQmb99DzYZpydYq4mC6G2dO1mYNf/UEWwuJ7bX0hAIgF6ZO2ZT+iDTyi8PcFrysfZaJgL2negKYGBlk9pBDoTA=";
            String cipherText = "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";
            System.out.println(sm2AndSm4Decrypt(merSm2DecKeyFile, cipherText, "xlzf1234"));
        } catch (PKIException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}

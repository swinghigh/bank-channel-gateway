package com.jkf.channel.gateway.utils;

import cfca.sadk.algorithm.common.CBCParam;
import cfca.sadk.algorithm.common.Mechanism;
import cfca.sadk.algorithm.common.PKIException;
import cfca.sadk.lib.crypto.JCrypto;
import cfca.sadk.lib.crypto.Session;
import cfca.sadk.util.Base64;
import cfca.sadk.util.CertUtil;
import cfca.sadk.util.EncryptUtil;
import cfca.sadk.util.KeyUtil;
import cfca.sadk.x509.certificate.X509Cert;

import java.security.Key;
import java.security.PrivateKey;

import javax.crypto.spec.SecretKeySpec;

/**
 * @author xiangyu
 * @date 2023/12/1 11:00
 */
public class GuoMIEncryptUtil {
    final static String deviceName = JCrypto.JSOFT_LIB;
    private static Session session=null;
    static {
        try {
            JCrypto.getInstance().initialize(deviceName, null);
            session= JCrypto.getInstance().openSession(deviceName);
        } catch (PKIException e) {
            throw new RuntimeException(e);
        }
    }

    public static Session getSession(){
        return session;
    }



    public static void main(String[] args) throws Exception {

        final String deviceName = JCrypto.JSOFT_LIB;
        JCrypto.getInstance().initialize(deviceName, null);
        final Session session = JCrypto.getInstance().openSession(deviceName);

        GuoMIEncryptUtil demo = new GuoMIEncryptUtil();
        demo.demoSM4EncryptMessage(session, "银行卡","ae06b5c8ffa73bc3bdb83c193082010a");
    }


    /**
     * 文件加密和文件解密（3DES）
     */
    public void demoDES3EncryptFileTwo() throws Exception {
        final String pwd = "0282010100ea6226b38463db95bf4f0cae06b5c8ffa73bc3bdb83c193082010a";

        final String message = "CFCA-MESSAGE-TESTING";
        final String sourceFilePath = "TestData/tmp-data-test.dat";
        final String encryptFilePath = "TestData/tmp-data-test.enc";
        final String plainTextFilePath = "TestData/tmp-data-test.dec";

        TextFileHelper.writeFile(sourceFilePath, message.getBytes("UTF8"));

        // DES3加密文件：前8字节作向量，后24字节作密钥
        EncryptUtil.encryptFileByDES3(sourceFilePath, encryptFilePath, pwd);

        byte[] encryptData = TextFileHelper.readFile(encryptFilePath);

        System.err.println("   demoDES3EncryptFileTwo: " + new String(Base64.encode(encryptData)));

        // DES3解密文件：前8字节作向量，后24字节作密钥
        EncryptUtil.decryptFileByDES3(encryptFilePath, plainTextFilePath, pwd);

        byte[] decryptData = TextFileHelper.readFile(plainTextFilePath);

        System.err.println("   demoDES3EncryptFileTwo: " + message.equals(new String(decryptData, "UTF8")));
    }

    /**
     * 消息加密和消息解密（3DES）
     */
    public void demoDES3EncryptMessageTwo() throws Exception {

        final String pwd = "0282010100ea6226b38463db95bf4f0cae06b5c8ffa73bc3bdb83c193082010a";

        final String message = "CFCA-MESSAGE-TESTING";

        // DES3消息加密：前8字节作向量，后24字节作密钥
        String base64EncryptText = EncryptUtil.encryptMessageByDES3(message, pwd);

        System.err.println("demoDES3EncryptMessageTwo: " + base64EncryptText);

        // DES3消息解密：前8字节作向量，后24字节作密钥
        String decryptText = EncryptUtil.decryptMessageByDES3(base64EncryptText, pwd);

        System.err.println("demoDES3EncryptMessageTwo: " + message.equals(decryptText));

    }

    /**
     * 文件加密和文件解密（3DES）
     */
    public void demoDES3EncryptFile(final Session session) throws Exception {

        final String sourceFilePath = "TestData/tmp-data-test.dat";
        final String encryptFilePath = "TestData/tmp-data-test.enc";
        final String plainTextFilePath = "TestData/tmp-data-test.dec";

        final String ivText = "0282010100ea6226";
        final String kText = "b38463db95bf4f0cae06b5c8ffa73bc3bdb83c193082010a";

        // 指定向量和密钥
        final Mechanism mechanism = new Mechanism(Mechanism.DES3_CBC, new CBCParam(TextHexKit.decode(ivText)));
        final Key key = new SecretKeySpec(TextHexKit.decode(kText), "DESede");

        final String message = "CFCA-MESSAGE-TESTING";
        TextFileHelper.writeFile(sourceFilePath, message.getBytes("UTF8"));

        // DES3文件加密
        EncryptUtil.encrypt(mechanism, key, sourceFilePath, encryptFilePath, session);
        byte[] binaryBytes = TextFileHelper.readFile(encryptFilePath);
        System.err.println("          demoEncryptFile: " + new String(Base64.encode(binaryBytes)));

        // DES3文件解密
        EncryptUtil.decrypt(mechanism, key, encryptFilePath, plainTextFilePath, session);
        byte[] decryptText = TextFileHelper.readFile(plainTextFilePath);

        System.err.println("          demoEncryptFile: " + message.equals(new String(decryptText, "UTF8")));
    }

    /**
     * 消息加密和消息解密（3DES）
     */
    public void demoDES3EncryptMessage(final Session session) throws Exception {

        final String ivText = "0282010100ea6226";
        final String kText = "b38463db95bf4f0cae06b5c8ffa73bc3bdb83c193082010a";

        // 指定向量和密钥
        final Mechanism mechanism = new Mechanism(Mechanism.DES3_CBC, new CBCParam(TextHexKit.decode(ivText)));
        final Key key = new SecretKeySpec(TextHexKit.decode(kText), "DESede");

        final String message = "CFCA-MESSAGE-TESTING";

        // DES3消息加密
        byte[] base64Bytes = EncryptUtil.encrypt(mechanism, key, message.getBytes("UTF8"), session);

        System.err.println("   demoDES3EncryptMessage: " + new String(base64Bytes));

        // DES3消息解密
        byte[] decryptText = EncryptUtil.decrypt(mechanism, key, base64Bytes, session);

        System.err.println("   demoDES3EncryptMessage: " + message.equals(new String(decryptText, "UTF8")));
    }

    /**
     * 消息加密和消息解密（SM4）
     */
    public void demoSM4EncryptMessageTwo(final String kText) throws Exception {

        final String ivText = "0282010100ea6226b38463db95bf4f0c";
//        final String kText = "ae06b5c8ffa73bc3bdb83c193082010a";

        final byte[] iv = TextHexKit.decode(ivText);
        final byte[] key = TextHexKit.decode(kText);

        final String message = "CFCA-MESSAGE-TESTING";

        // SM4消息加密
        byte[] base64Bytes = EncryptUtil.encryptMessageBySM4(message.getBytes("UTF8"), iv, key);

        System.err.println(" demoSM4EncryptMessageTwo: " + new String(base64Bytes));

        // SM4消息解密
        byte[] decryptText = EncryptUtil.decryptMessageBySM4(base64Bytes, iv, key);

        System.err.println(" demoSM4EncryptMessageTwo: " + message.equals(new String(decryptText, "UTF8")));
    }

    /**
     * 消息加密和消息解密（口令派生SM4密钥）
     */
    public void demoSM4EncryptMessageByPassword() throws Exception {

        final String password = "cfca1234";

        final String message = "CFCA-MESSAGE-TESTING";

        // SM4消息加密（SM4口令派生密钥）
        byte[] base64Bytes = EncryptUtil.encryptMessageBySM4(message.getBytes("UTF8"), password);

        System.err.println(" demoSM4EncryptMessageByPassword: " + new String(base64Bytes));

        // SM4消息解密（SM4口令派生密钥）
        byte[] decryptText = EncryptUtil.decryptMessageBySM4(base64Bytes, password);

        System.err.println(" demoSM4EncryptMessageByPassword: " + message.equals(new String(decryptText, "UTF8")));
    }

    /**
     * 消息加密和消息解密（SM4）
     */
    public static String demoSM4EncryptMessage(final Session session,String message,final String kText) throws Exception {

        final String ivText = "0282010100ea6226b38463db95bf4f0c";  //指定向量
//        final String kText = "ae06b5c8ffa73bc3bdb83c193082010a";   //密钥

        // 指定向量和密钥
        final Mechanism mechanism = new Mechanism(Mechanism.SM4_CBC, new CBCParam(TextHexKit.decode(ivText)));
        final Key key = new SecretKeySpec(TextHexKit.decode(kText), "SM4");

        //final String message = "CFCA-MESSAGE-TESTING";

        // SM4消息加密
        byte[] base64Bytes = EncryptUtil.encrypt(mechanism, key, message.getBytes("UTF8"), session);

        System.err.println("    demoSM4EncryptMessage: " + new String(base64Bytes));

        return new String(base64Bytes);

        // SM4消息解密
        //byte[] decryptText = EncryptUtil.decrypt(mechanism, key, base64Bytes, session);

        //System.err.println("    demoSM4EncryptMessage: " + message.equals(new String(decryptText, "UTF8")));
    }

    /**
     * 消息加密和消息解密（RC4）
     */
    public void demoRC4EncryptMessage(final Session session,final String kText) throws Exception {

//        final String kText = "ae06b5c8ffa73bc3bdb83c193082010a";

        // 指定密钥
        final Mechanism mechanism = new Mechanism(Mechanism.RC4);
        final Key key = new SecretKeySpec(TextHexKit.decode(kText), "RC4");

        final String message = "CFCA-MESSAGE-TESTING";

        // RC4消息加密
        byte[] base64Bytes = EncryptUtil.encrypt(mechanism, key, message.getBytes("UTF8"), session);

        System.err.println("    demoRC4EncryptMessage: " + new String(base64Bytes));

        // RC4消息加密
        byte[] decryptText = EncryptUtil.decrypt(mechanism, key, base64Bytes, session);

        System.err.println("    demoRC4EncryptMessage: " + message.equals(new String(decryptText, "UTF8")));
    }

    /**
     * 消息加密和消息解密（SM2）
     */
    public void demoSM2EncryptMessage(final Session session) throws Exception {

        final String sm2FileText = "MIICMAIBATBHBgoqgRzPVQYBBAIBBgcqgRzPVQFoBDB0vnnhR0gsAqT4Uieo84OJ0EV76ea/FvatojLQKofjlQkaRn8SKWAgMLI3IOLnXsMwggHgBgoqgRzPVQYBBAIBBIIB0DCCAcwwggFxoAMCAQICBSAAAACSMAwGCCqBHM9VAYN1BQAwITELMAkGA1UEBhMCQ04xEjAQBgNVBAoMCUNGQ0EgT0NBNjAeFw0xMjExMTkwMjE5NDlaFw0xMzAyMjcwMjE5NDlaMGYxCzAJBgNVBAYTAmNuMRswGQYDVQQKDBJDRkNBIE9wZXJhdGlvbiBDQTIxEDAOBgNVBAsMB0JPQy1UUEMxFDASBgNVBAsMC0luZGl2aWR1YWwyMRIwEAYDVQQDDAlyc2FmZjAwMTEwWTATBgcqhkjOPQIBBggqgRzPVQGCLQNCAAT7sUFLTK4wBDrSnr1q8dwMhr+ws+Lfda9VFNid0J4YYQL0pSikQRPYw+U+/ckrZTe0loRLORr9FAMD9XztA2KGo08wTTAfBgNVHSMEGDAWgBQAkArr76OKEQ0Wwlgl7Q4nkO0YJzALBgNVHQ8EBAMCBsAwHQYDVR0OBBYEFIzMC06btck4k+a3q5jmwdQiohxWMAwGCCqBHM9VAYN1BQADRwAwRAIgF9pesommXwnUg0RCBNQDE9nqdkrVqWd2bBh8wpo+E/kCID5xx7sN61oqaol2T0EvG08U/kPV6QdAws3zWFQmiTw2";
        final String sm2FilePass = "1";

        final Mechanism mechanism = new Mechanism(Mechanism.SM2);
        X509Cert cert = CertUtil.getCertFromSM2(sm2FileText.getBytes());
        PrivateKey priKey = KeyUtil.getPrivateKeyFromSM2(sm2FileText.getBytes(), sm2FilePass);

        final String message = "CFCA-MESSAGE-TESTINGweMIICMAIBATBHBgoqgRzPVQYBBAIBBgcqgRzPVQFoBDB0vnnhR0gsAqT4Uieo84OJ0EV76ea/FvatojLQKofjlQkaRn8SKWAgMLI3IOLnXsMwggHgBgoqgRzPVQYBBAIBBIIB0DCCAcwwggFxoAMCAQICBSAAAACSMAwGCCqBHM9VAYN1BQAwITELMAkGA1UEBhMCQ04xEjAQBgNVBAoMCUNGQ0EgT0NBNjAeFw0xMjExMTkwMjE5NDlaFw0xMzAyMjcwMjE5NDlaMGYxCzAJBgNVBAYTAmNuMRswGQYDVQQKDBJDRkNBIE9wZXJhdGlvbiBDQTIxEDAOBgNVBAsMB0JPQy1UUEMxFDASBgNVBAsMC0luZGl2aWR1YWwyMRIwEAYDVQQDDAlyc2FmZjAwMTEwWTATBgcqhkjOPQIBBggqgRzPVQGCLQNCAAT7sUFLTK4wBDrSnr1q8dwMhr+ws+Lfda9VFNid0J4YYQL0pSikQRPYw+U+/ckrZTe0loRLORr9FAMD9XztA2KGo08wTTAfBgNVHSMEGDAWgBQAkArr76OKEQ0Wwlgl7Q4nkO0YJzALBgNVHQ8EBAMCBsAwHQYDVR0OBBYEFIzMC06btck4k+a3q5jmwdQiohxWMAwGCCqBHM9VAYN1BQADRwAwRAIgF9pesommXwnUg0RCBNQDE9nqdkrVqWd2bBh8wpo+E/kCID5xx7sN61oqaol2T0EvG08U/kPV6QdAws3zWFQmiTw2rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr";

        // SM2公钥加密：长度通常限定为136字节内
        byte[] base64Bytes = EncryptUtil.encrypt(mechanism, cert.getPublicKey(), message.getBytes("UTF8"), session);

        System.err.println("    demoSM2EncryptMessage: " + new String(base64Bytes));

        // SM2私钥解密：长度通常限定为136字节内
        byte[] decryptText = EncryptUtil.decrypt(mechanism, priKey, base64Bytes, session);

        System.err.println("    demoSM2EncryptMessage: " + message.equals(new String(decryptText, "UTF8")));
    }

    /**
     * 消息加密和消息解密（RSA）
     */
    public void demoRSAEncryptMessage(final Session session) throws Exception {

        final String p12FileText = "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";
        final String p12FilePass = "123456";

        // 加密算法："RSA/ECB/PKCS1PADDING"
        final Mechanism mechanism = new Mechanism(Mechanism.RSA_PKCS);
        X509Cert cert = CertUtil.getCertFromPFX(p12FileText.getBytes(), p12FilePass);
        PrivateKey priKey = KeyUtil.getPrivateKeyFromPFX(p12FileText.getBytes(), p12FilePass);

        final String message = "CFCA-MESSAGE-TESTING";
        // RSA公钥加密：长度通常限定（1024密钥为117字节内；2048密钥为245字节内）
        byte[] base64Bytes = EncryptUtil.encrypt(mechanism, cert.getPublicKey(), message.getBytes("UTF8"), session);
        System.err.println("    demoRSAEncryptMessage: " + new String(base64Bytes));

        // RSA私钥解密：长度通常限定（1024密钥为128字节；2048密钥为256字节）
        byte[] decryptText = EncryptUtil.decrypt(mechanism, priKey, base64Bytes, session);
        System.err.println("    demoRSAEncryptMessage: " + message.equals(new String(decryptText, "UTF8")));
    }
}

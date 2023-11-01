package com.jkf.channel.gateway.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("All")
public class RSAUtil {

    private static final String KEY_GATEWAY_SIGNATURE = "sign";
    /**
     * 数字签名，密钥算法
     */
    private static final String RSA_KEY_ALGORITHM = "RSA";
    /**
     * 数字签名签名/验证算法
     */
    private static final String SIGNATURE_ALGORITHM = "SHA1WithRSA";


    private static final String SIGNATURE_ALGORITHM2 = "SHA256withRSA";
     /**
     * RSA密钥长度，RSA算法的默认密钥长度是1024密钥长度必须是64的倍数，在512到65536位之间
     */
    private static final int KEY_SIZE = 2048;
    /**
     * 字符集编码
     */
    private static final String CHARSET = "UTF-8";

    public static Map<String, String> createKeys() {
        // 为RSA算法创建一个KeyPairGenerator对象
        KeyPairGenerator kpg;
        try {
            kpg = KeyPairGenerator.getInstance(RSA_KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("No such algorithm-->[" + RSA_KEY_ALGORITHM + "]");
        }
        // 初始化KeyPairGenerator对象,密钥长度
        kpg.initialize(KEY_SIZE);
        // 生成密匙对
        KeyPair keyPair = kpg.generateKeyPair();
        // 得到公钥
        Key publicKey = keyPair.getPublic();
        String publicKeyStr = Base64.encodeBase64URLSafeString(publicKey.getEncoded());
        // 得到私钥
        Key privateKey = keyPair.getPrivate();
        String privateKeyStr = Base64.encodeBase64URLSafeString(privateKey.getEncoded());
        Map<String, String> keyPairMap = new HashMap<>(2);
        keyPairMap.put("publicKey", publicKeyStr);
        keyPairMap.put("privateKey", privateKeyStr);
        return keyPairMap;
    }

    /**
     * 得到公钥
     * @param publicKey 密钥字符串（经过base64编码）
     * @throws Exception e
     */
    private static RSAPublicKey getPublicKey(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // 通过X509编码的Key指令获得公钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
        return (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
    }

    /**
     * 得到私钥
     * @param privateKey 密钥字符串（经过base64编码）
     * @throws Exception e
     */
    private static RSAPrivateKey getPrivateKey(String privateKey)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        // 通过PKCS#8编码的Key指令获得私钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
        return (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
    }


    /**
     * 公钥加密
     * @param data 待加密数据
     * @param publicKeys 公钥String
     * @return 加密后的数据
     * @throws Exception e
     */
    public static String publicEncrypt(String data, String publicKeys) throws Exception {
        RSAPublicKey publicKey = getPublicKey(publicKeys);
        // 默认RSA/None/PKCS1Padding填充方式,每次加密生成密文不一致
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        // 指定"RSA/None/NoPadding", "BC"填充方式,每次加密生成密文一致
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return Base64.encodeBase64String(rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE,data.getBytes(CHARSET),
                publicKey.getModulus().bitLength()));
    }

    /**
     * 私钥解密
     * @param data 待解密数据
     * @param privateKeys 私钥String
     * @return 解密后的数据
     */

    public static String privateDecrypt(String data, String privateKeys) throws Exception {
        RSAPrivateKey privateKey = getPrivateKey(privateKeys);
        Cipher cipher = Cipher.getInstance(RSA_KEY_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.decodeBase64(data),
                privateKey.getModulus().bitLength()), CHARSET);
    }

    /**
     * 私钥加密
     * @param data 待加密数据
     * @param privateKeys 私钥String
     * @return String 加密后的数据
     * @throws Exception e
     */
    public static String privateEncrypt(String data, String privateKeys) throws Exception {
        RSAPrivateKey privateKey = getPrivateKey(privateKeys);
        Cipher cipher = Cipher.getInstance(RSA_KEY_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return Base64.encodeBase64URLSafeString(rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, data.getBytes(CHARSET),
                privateKey.getModulus().bitLength()));
    }

    /**
     * 公钥解密
     * @param data 待解密数据
     * @param publicKeys 公钥String
     * @return 解密后的数据
     * @throws Exception e
     */
    public static String publicDecrypt(String data, String publicKeys) throws Exception {
        RSAPublicKey publicKey = getPublicKey(publicKeys);
        Cipher cipher = Cipher.getInstance(RSA_KEY_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return new String(rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.decodeBase64(data),
                publicKey.getModulus().bitLength()), CHARSET);
    }

    /**
     * 私钥RSA签名
     * @param data 待签名数据
     * @param privateKeys 私钥String
     * @return 签名
     * @throws Exception e
     */
    public static String sign(String data, String privateKeys) throws Exception {
        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeys));
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        // 生成私钥
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 实例化Signature
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        // 初始化Signature
        signature.initSign(privateKey);
        // 更新
        signature.update(data.getBytes());
        // 验证
        return Base64.encodeBase64String(signature.sign());
    }

    public static String sign(Object o, String privateKeys) throws Exception {
        Map<String, Object> parMap = JSON.parseObject(JSON.toJSONString(o), new TypeReference<Map<String, Object>>(){});
        String data = preDealSignStr(parMap);
        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeys));
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        // 生成私钥
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 实例化Signature
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        // 初始化Signature
        signature.initSign(privateKey);
        // 更新
        signature.update(data.getBytes());
        // 验证
        return Base64.encodeBase64String(signature.sign());
    }
    /**
     * 公钥RSA校验数字签名
     *
     * @param data 待校验数据
     * @param sign 数字签名
     * @param publicKeys 公钥
     * @return boolean 校验成功返回true，失败返回false
     * @throws Exception e
     */
    public static boolean verify(String data, String sign, String publicKeys) throws Exception {
        // 实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        // 初始化公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeys));
        // 产生公钥
        PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
        // 实例化Signature
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        // 初始化Signature
        signature.initVerify(publicKey);
        // 更新
        signature.update(data.getBytes());
        // 验证
        return signature.verify(Base64.decodeBase64(sign));
    }
    public static boolean verify(Object o, String publicKeys) throws Exception {
        Map<String, Object> parMap = JSON.parseObject(JSON.toJSONString(o), new TypeReference<Map<String, Object>>(){});
        String data = preDealSignStr(parMap);
        String sign = parMap.get(KEY_GATEWAY_SIGNATURE).toString();
        // 实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        // 初始化公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeys));
        // 产生公钥
        PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
        // 实例化Signature
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        // 初始化Signature
        signature.initVerify(publicKey);
        // 更新
        signature.update(data.getBytes());
        // 验证
        return signature.verify(Base64.decodeBase64(sign));
    }


    private static byte[] rsaSplitCodec(Cipher cipher, int operationMode, byte[] dataArray, int keySize) {
        int maxBlock = 0;
        if (operationMode == Cipher.DECRYPT_MODE) {
            maxBlock = keySize / 8;
        } else {
            maxBlock = keySize / 8 - 11;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] buff;
        int i = 0;
        try {
            while (dataArray.length > offSet) {

                if (dataArray.length - offSet > maxBlock) {
                    buff = cipher.doFinal(dataArray, offSet, maxBlock);
                } else {
                    buff = cipher.doFinal(dataArray, offSet, dataArray.length - offSet);
                }
                out.write(buff, 0, buff.length);
                i++;
                offSet = i * maxBlock;
            }
            return out.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("加解密阀值为[" + maxBlock + "]的数据时发生异常", e);
        }finally {
            try {
                if (out != null){
                    out.close();
                }
            } catch (IOException e) {}
        }
    }

    public static String preDealSignStr(Map<String, Object> paramMap) {
        // 1. 剔除paramMap中，不参与签名的字段，签名字段
        Map<String, Object> tmpMap = new HashMap<>(paramMap);
        // 2.剔除Constants.KEY_GATEWAY_SIGNATURE字段内容
        tmpMap.remove(KEY_GATEWAY_SIGNATURE);
        // 3 签名参数按文档规则拼装
        return createLinkString(tmpMap);
    }
    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    private static String createLinkString(Map<String, Object> params) {
        StringBuffer prestr = new StringBuffer();
        params.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .filter(k->k.getValue()!=null)
                .forEachOrdered(k->prestr.append(k.getKey()).append("=").append(k.getValue()).append("&"));
        prestr.deleteCharAt(prestr.length() -1);
        return prestr.toString();
    }
    public static void main(String[] args) throws Exception {
        Map<String, String> keys = createKeys();
        System.out.println("privateKey======>"+ keys.get("privateKey"));
        System.out.println("publicKey======>"+ keys.get("publicKey"));

    }


}

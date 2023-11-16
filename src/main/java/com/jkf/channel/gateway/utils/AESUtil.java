package com.jkf.channel.gateway.utils;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * app和服务端对称性加密
 * @auther: wangzw
 * @date: 2018/6/11 08:39
 * @description: aes加解密工具
 */
public class AESUtil {

    private static final String CODEING="utf-8";
    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    public static  final String key = "723ec0a9c317d85324f6be2e8ec61b7f";
    /**
     * 功能描述: aes加密
     * @auther: wangzw
     * @date: 2018/6/11 8:29
     */
    public static String encrypt(String data, String key) {
        try {
            key = key.substring(0, 16);
            byte[] raw = key.getBytes(CODEING);
            SecretKeySpec secretKeySpec = new SecretKeySpec(raw, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encrypted = cipher.doFinal(data.getBytes("utf-8"));
            return  ByteUtil.parseByte2HexStr(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 功能描述: aes解密
     * @auther: wangzw
     * @date: 2018/6/11 8:36
     */
    public static String decrypt(String data, String key) {
        try {
            key = key.substring(0, 16);
            byte[] raw = key.getBytes(CODEING);
            SecretKeySpec secretKeySpec = new SecretKeySpec(raw, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] encrypted1 = ByteUtil.parseHexStr2Byte(data);
            byte[] original = cipher.doFinal(encrypted1);
            return new String(original, CODEING);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args){
        String data="111";
        String key="F242FEBEE296D159B5D2EA708CE31E10";
        System.out.println("加密后的结果:"+encrypt( data,  key));
        String data1="AB2005950B269668065DE459DD07A420";
        System.out.println("解密后的结果:" + decrypt(data1,key));
        /* System.out.println("解密后的结果:"+decrypt(encrypt( data,  key),key));*/
       /*try {
           System.out.println("解密后的结果:" + decrypt(data,encrypt(key,key)));
       }catch (Exception e){
           e.printStackTrace();
       }*/
    }
}

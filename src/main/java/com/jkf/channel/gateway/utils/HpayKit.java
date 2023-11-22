
package com.jkf.channel.gateway.utils;

import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
* Hpay工具类
*
* @date 2021/6/8 16:50
*/
@SuppressWarnings("all")
@Slf4j
public class HpayKit {

	public static byte[] AES_KEY = "123456725012345678927w46".getBytes();


    public static String aesEncode(String key, String value){
        if (StringUtils.isNotEmpty(key)){
            return SecureUtil.aes(key.getBytes()).encryptHex(value);
        }else {
            return aesEncode(value);
        }
    }

    public static String aesDecode(String key, String value){
        if (StringUtils.isNotEmpty(key)){
            return SecureUtil.aes(key.getBytes()).decryptStr(value);
        }else {
            return aesDecode(value);
        }
    }


    /** 加密 **/
    public static String aesEncode(String str){
        return SecureUtil.aes(HpayKit.AES_KEY).encryptHex(str);
    }

    public static String aesDecode(String str){
        return SecureUtil.aes(HpayKit.AES_KEY).decryptStr(str);
    }



    private static String encodingCharset = "UTF-8";

    /**
     * <p><b>Description: </b>计算签名摘要
     * <p>2018年9月30日 上午11:32:46
     * @param map 参数Map
     * @param key 商户秘钥
     * @return
     */
    public static String getSign(Map<String, Object> map, String key){
        ArrayList<String> list = new ArrayList<String>();
        for(Map.Entry<String, Object> entry:map.entrySet()){
            if(null != entry.getValue() && !"".equals(entry.getValue())){
                String value=""+entry.getValue();
                if(entry.getValue() instanceof JSONArray){
                    JSONArray jsonArray=(JSONArray)entry.getValue();
                    JSONArray jsonArray1=new JSONArray();
                    for (Object o : jsonArray) {
                        if(o instanceof JSONObject){
                            JSONObject obj=(JSONObject)o;
                            List<String> jsonList=new ArrayList<>(obj.size());
                            jsonList.addAll(obj.keySet());
                            String[] arrayToSort1 = jsonList.toArray(new String[jsonList.size()]);
                            Arrays.sort(arrayToSort1, String.CASE_INSENSITIVE_ORDER);
                            JSONObject listJson=new JSONObject(new LinkedHashMap<>());
                            for (int i = 0; i < arrayToSort1.length; i++) {
                                if(null!=obj.get(arrayToSort1[i])&&!"".equals(obj.get(arrayToSort1[i]))){
                                    listJson.put(arrayToSort1[i],obj.get(arrayToSort1[i]));
                                }
                            }
                            jsonArray1.add(listJson);
                        }
                    }
                    if(jsonArray1.size()>0){
                        value=jsonArray1.toString();
                    }
                }
                list.add(entry.getKey() + "=" + value + "&");
            }
        }
        int size = list.size();
        String[] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + key;
        log.info("signStr:{}", result);
        result = md5(result, encodingCharset).toUpperCase();
        log.info("sign:{}", result);
        return result;
    }

    /**
	 * <p>
	 * <b>Description: </b>计算签名摘要
	 * <p>
	 * 2018年9月30日 上午11:32:46
	 *
	 * @param map
	 *            参数Map
	 * @param key
	 *            商户秘钥
	 * @return
	 * @throws Exception
	 */
	/*public static String genEncrypt(JSONObject map, String key) throws Exception {
        String encryptStr="";
        try {
            encryptStr = Base64.getEncoder().encodeToString(RsaHelper2.encryptByPublicKey(map.toString().getBytes(RsaHelper2.CHARSET),key));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("map{},key{}加密失败{}",map.toJSONString(),key,e.getMessage());
			throw new Exception("加密失败");
        }
        return encryptStr;
    }*/

    /**
     * <p><b>Description: </b>计算签名摘要
     * <p>2018年9月30日 上午11:32:46
     * @param map 参数Map
     * @param key 商户秘钥  直接拼接key
     * @return
     */
    public static String getMd5Sign(Map<String, Object> map, String key){
        ArrayList<String> list = new ArrayList<String>();
        for(Map.Entry<String, Object> entry:map.entrySet()){
            if(null != entry.getValue() && !"".equals(entry.getValue())){
                String value=""+entry.getValue();
                if(entry.getValue() instanceof JSONArray){
                    JSONArray jsonArray=(JSONArray)entry.getValue();
                    JSONArray jsonArray1=new JSONArray();
                    for (Object o : jsonArray) {
                        if(o instanceof JSONObject){
                            JSONObject obj=(JSONObject)o;
                            List<String> jsonList=new ArrayList<>(obj.size());
                            jsonList.addAll(obj.keySet());
                            String[] arrayToSort1 = jsonList.toArray(new String[jsonList.size()]);
                            Arrays.sort(arrayToSort1, String.CASE_INSENSITIVE_ORDER);
                            JSONObject listJson=new JSONObject(new LinkedHashMap<>());
                            for (int i = 0; i < arrayToSort1.length; i++) {
                                if(null!=obj.get(arrayToSort1[i])&&!"".equals(obj.get(arrayToSort1[i]))){
                                    listJson.put(arrayToSort1[i],obj.get(arrayToSort1[i]));
                                }
                            }
                            jsonArray1.add(listJson);
                        }
                    }
                    if(jsonArray1.size()>0){
                        value=jsonArray1.toString();
                    }
                }
                list.add(entry.getKey() + "=" + value + "&");
            }
        }
        int size = list.size();
        String[] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result +=  key;
        log.info("signStr:{}", result);
        result = md5(result, encodingCharset).toUpperCase();
        log.info("sign:{}", result);
        return result;
    }

    /**
	 * 请求串解密
	 *
	 * @param key
	 *            为商户的secret秘钥，key长度为16位，取secret前16为作加解密KEY
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public static String decryptParam(String key, String param) throws Exception {
        try {
            param = HpayKit.aesDecode(key,param);
            param = new String(Base64.getDecoder().decode(param));
        }catch (Exception e){
            e.printStackTrace();
            log.error("解密失败！{}-{}",param,key);
			throw new Exception("解密失败！{}-{}");
        }
        return param;
    }

    /**
     * <p><b>Description: </b>计算签名摘要
     * <p>2018年9月30日 上午11:32:46
     * @param map 参数Map
     * @param key 商户秘钥
     * @return 验签是否成功
     */
    public static boolean getSign(Map<String, Object> map, String key, String sign){
        ArrayList<String> list =genList(map);
        int size = list.size();
        String[] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + key;
        String signStr=result;
        result = md5(result, encodingCharset).toUpperCase();
        if(!sign.equalsIgnoreCase(result)){
            log.info("signStr:{}", signStr);
            log.info("sign:{}", result);
            return false;
        }

        return true;
    }
    /**
     * 验证签名
     *
     * @param map
     *            注意去除sign key
     * @param publicKey
     *            火眼提供的公钥
     * @param sign
     *            签名值
     * @return
     */
    /*public static boolean checkSignRsa(Map<String, Object> map, String publicKey, String sign) {
        ArrayList<String> list =genList(map);
        int size = list.size();
        String[] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result = result.substring(0, result.length() - 1);
        boolean t = false;
        try {
            t = RsaHelper2.verify(result.getBytes(), publicKey, sign);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("signStr:{}", result);
        }
        if(!t){
            log.info("signStr:{}", result);
            log.info("sign:{}", result);
        }
        return t;
    }*/
    /**
     * <p>
     * <b>Description: </b>计算签名摘要
     * <p>
     * 2018年9月30日 上午11:32:46
     *
     * @param map
     *            参数Map
     * @param key
     *            商户秘钥
     * @return
     * @throws Exception
     * @throws UnsupportedEncodingException
     */
   /* public static String genRsaSignStr(Map<String, Object> map, String key)
            throws UnsupportedEncodingException, Exception {
        List<String> list = genList(map);
        int size = list.size();
        String[] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result = result.substring(0, result.length() - 1);
        log.info("signStr:{}", result);
        result = RsaHelper2.sign(result.getBytes("UTF-8"), key);
        log.info("sign:{}", result);
        return result;
    }*/

    private static ArrayList<String> genList(Map<String, Object> map){
        ArrayList<String> list = new ArrayList<String>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (null != entry.getValue() && !"".equals(entry.getValue())) {
                String value = "" + entry.getValue();
                if (entry.getValue() instanceof JSONArray) {
                    JSONArray jsonArray = (JSONArray) entry.getValue();
                    JSONArray jsonArray1 = new JSONArray();
                    for (Object o : jsonArray) {
                        if (o instanceof JSONObject) {
                            JSONObject obj = (JSONObject) o;
                            List<String> jsonList = new ArrayList<>(obj.size());
                            jsonList.addAll(obj.keySet());
                            String[] arrayToSort1 = jsonList.toArray(new String[jsonList.size()]);
                            Arrays.sort(arrayToSort1, String.CASE_INSENSITIVE_ORDER);
                            JSONObject listJson = new JSONObject(new LinkedHashMap<>());
                            for (int i = 0; i < arrayToSort1.length; i++) {
                                if (null != obj.get(arrayToSort1[i]) && !"".equals(obj.get(arrayToSort1[i]))) {
                                    listJson.put(arrayToSort1[i], obj.get(arrayToSort1[i]));
                                }
                            }
                            jsonArray1.add(listJson);
                        }
                    }
                    if (jsonArray1.size() > 0) {
                        value = jsonArray1.toString();
                    }
                }
                list.add(entry.getKey() + "=" + value + "&");
            }
        }
        return list;
    }



    /**
     * <p><b>Description: </b>MD5
     * <p>2018年9月30日 上午11:33:19
     * @param value
     * @param charset
     * @return
     */
    public static String md5(String value, String charset) {
        MessageDigest md = null;
        try {
            byte[] data = value.getBytes(charset);
            md = MessageDigest.getInstance("MD5");
            byte[] digestData = md.digest(data);
            return toHex(digestData);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String toHex(byte input[]) {
        if (input == null) {
            return null;
        }
        StringBuffer output = new StringBuffer(input.length * 2);
        for (int i = 0; i < input.length; i++) {
            int current = input[i] & 0xff;
            if (current < 16) {
                output.append("0");
            }
            output.append(Integer.toString(current, 16));
        }

        return output.toString();
    }

    /** map 转换为  url参数 **/
    public static String genUrlParams(Map<String, Object> paraMap) {
        if(paraMap == null || paraMap.isEmpty()) {
            return "";
        }
        StringBuffer urlParam = new StringBuffer();
        Set<String> keySet = paraMap.keySet();
        int i = 0;
        for(String key:keySet) {
            urlParam.append(key).append("=").append( paraMap.get(key) == null ? "" : paraMap.get(key) );
            if(++i == keySet.size()) {
                break;
            }
            urlParam.append("&");
        }
        return urlParam.toString();
    }


}

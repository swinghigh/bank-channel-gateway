package com.jkf.channel.gateway.utils;

import cfca.sadk.algorithm.common.Mechanism;
import cfca.sadk.algorithm.common.PKIException;
import cfca.sadk.lib.crypto.JCrypto;
import cfca.sadk.lib.crypto.Session;
import cfca.sadk.util.CertUtil;
import cfca.sadk.util.KeyUtil;
import cfca.sadk.util.Signature;
import cfca.sadk.x509.certificate.X509Cert;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.apache.commons.lang.StringUtils;

import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/12/4 9:27
 */
public class GuoMISignUtils {
    private static final String SING_PROPERTY = "signature";
    /**
     * 按字母顺序以 &a=b 格式拼接参数
     *
     * @param requestBody 请求参数 json 字符串
     * @return
     */
    public static String getSignStr(String requestBody){
        JSONObject jsonObject = JSONUtil.parseObj(requestBody);
        ArrayList<String> keys = new ArrayList<>(jsonObject.keySet());
        keys.sort(Comparator.naturalOrder());
        StringBuilder paramBuilder = new StringBuilder(requestBody.length() + keys.size());
        for (int i = 0; i < keys.size(); i++) {
            // 排除签名字段
            if (SING_PROPERTY.equals(keys.get(i))) {
                continue;
            }
            if (i == 0) {
                paramBuilder.append(keys.get(i))
                        .append("=")
                        .append(StringUtils.isEmpty(jsonObject.getStr(keys.get(i))) ? StrUtil.EMPTY : jsonObject.getStr(keys.get(i)));
            } else {
                paramBuilder.append("&")
                        .append(keys.get(i))
                        .append("=")
                        .append(StringUtils.isEmpty(jsonObject.getStr(keys.get(i))) ? StrUtil.EMPTY : jsonObject.getStr(keys.get(i)));
            }
        }
        return paramBuilder.toString();
    }

    /**
     * cfca 签名
     *
     * @param plainData 待签名参数串
     * @return
     */
    private static String cfcaSign(String plainData,String merSm2KeyText,String sm2Pass) throws PKIException {


        // 步骤1 加密库初始化
        String deviceName = JCrypto.JSOFT_LIB;
        JCrypto.getInstance().initialize(deviceName, null);
        Session session = JCrypto.getInstance().openSession(deviceName);

        // 步骤2 构建证书对象
        X509Cert signCert = CertUtil.getCertFromSM2(merSm2KeyText.getBytes());

        // 步骤3 获得私钥对象
        PrivateKey privateKey = KeyUtil.getPrivateKeyFromSM2(merSm2KeyText.getBytes(), sm2Pass);

        // 步骤4 P7消息签名
        Signature signKit = new Signature();

        byte[] sourceData = plainData.getBytes(StandardCharsets.UTF_8);
        String signAlg = Mechanism.SM3_SM2;
        byte[] signedData = signKit.p7SignMessageDetach(signAlg, sourceData, privateKey, signCert, session);
        return new String(signedData);
    }

    /**
     * 生成请求签名
     * @param data
     * @param merSm2KeyText sm2私钥
     * @param sm2Pass sm2密码
     * @return
     */
    public static String getSignature(Map<String,String> data,String merSm2KeyText,String sm2Pass) throws PKIException{
       String  plainData=getSignStr(JSONUtil.toJsonStr(data));
       return cfcaSign( plainData, merSm2KeyText, sm2Pass);
    }

    /**
     * 验证签名
     * @param responseData
     * @return
     * @throws PKIException
     */
    public static boolean validateSign(String responseData) throws PKIException{
        //  拼接响应参数字符串
        String plainData = getSignStr(responseData);
        //  获取签名字段
        JSONObject bussRespDataObj = JSONUtil.parseObj(responseData);
        String respSignature = bussRespDataObj.getStr(SING_PROPERTY);
        return  cfcaVerify( plainData, respSignature);
    }

    /**
     * cfca 验签
     *
     * @param plainData 参与签名参数串
     * @param signature 签名值
     * @return
     */
    private static boolean cfcaVerify(String plainData, String signature) throws PKIException {
        // 步骤1 加密库初始化
        String deviceName = JCrypto.JSOFT_LIB;
        JCrypto.getInstance().initialize(deviceName, null);
        Session session = JCrypto.getInstance().openSession(deviceName);
        byte[] base64P7SignedData = signature.getBytes(StandardCharsets.UTF_8);
        // 步骤2 P7消息签名
        Signature signKit = new Signature();
        // 步骤3 验签
        boolean result = signKit.p7VerifyMessageDetach(plainData.getBytes(StandardCharsets.UTF_8), base64P7SignedData, session);
        return result;
    }
}

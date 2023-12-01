package com.jkf.channel.gateway.utils.xinwang;

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
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 新网签名工具类
 */
@Slf4j
public class XinWangSignUtil {

    public static final String SIGN_PROPERTY = "signature";

    /**
     * 按字母顺序以 &a=b 格式拼接参数
     *
     * @param oriRequestBody 请求参数 json 字符串
     * @return
     */
    public static String buildParamStr(JSONObject oriRequestBody) {
        cn.hutool.json.JSONObject jsonObject = JSONUtil.parseObj(oriRequestBody);
        ArrayList<String> keys = new ArrayList<>(jsonObject.keySet());
        keys.sort(Comparator.naturalOrder());
        StringBuilder paramBuilder = new StringBuilder();
        for (int i = 0; i < keys.size(); i++) {
            // 排除签名字段
            if (SIGN_PROPERTY.equals(keys.get(i))) {
                continue;
            }
            if (i == 0) {
                paramBuilder.append(keys.get(i))
                        .append("=")
                        .append(StrUtil.isEmpty(jsonObject.getStr(keys.get(i))) ? StrUtil.EMPTY : jsonObject.getStr(keys.get(i)));
            } else {
                paramBuilder.append("&")
                        .append(keys.get(i))
                        .append("=")
                        .append(StrUtil.isEmpty(jsonObject.getStr(keys.get(i))) ? StrUtil.EMPTY : jsonObject.getStr(keys.get(i)));
            }
        }
        return paramBuilder.toString();
    }


    /**
     * cfca 验签
     *
     * @param plainData 参与签名参数串
     * @param signature 签名值
     * @return
     */
    public static boolean cfcaVerify(String plainData, String signature) throws PKIException {

        // 步骤1 加密库初始化
        String deviceName = JCrypto.JSOFT_LIB;
        JCrypto.getInstance().initialize(deviceName, null);
        Session session = JCrypto.getInstance().openSession(deviceName);

        byte[] base64P7SignedData = signature.getBytes(StandardCharsets.UTF_8);

        // 步骤2 P7消息签名
        Signature signKit = new Signature();
        // 步骤3 验签
        boolean result = signKit.p7VerifyMessageDetach(plainData.getBytes(StandardCharsets.UTF_8), base64P7SignedData, session);
        log.info("SM2 P7DetachVerify: {}", result);
        return result;
    }

    /**
     * cfca 签名
     *
     * @param plainData 待签名参数串
     * @param merSm2KeyText sm2证书文本
     * @param sm2Pass sm2密钥密码
     *
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

}

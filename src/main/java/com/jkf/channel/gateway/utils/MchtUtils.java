package com.jkf.channel.gateway.utils;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.entity.MchInfo;
import org.apache.commons.lang.StringUtils;

/**
 * @author xiangyu
 * @date 2023/11/20 16:17
 */
public class MchtUtils {

    public static MchInfo build(JSONObject jsonObject){
        MchInfo mchInfo=new MchInfo();
        mchInfo.setOutMchNo(jsonObject.getString("outMchtNo"));
        mchInfo.setOrgId(jsonObject.getLong("orgId"));
        mchInfo.setAgentId(jsonObject.getLong("agentId"));
        if(!StringUtils.isEmpty(jsonObject.getString("userId"))){
            mchInfo.setUserAdminId(jsonObject.getLong("userId"));
        }
        mchInfo.setMchName(jsonObject.getString("mchName"));
        mchInfo.setMchShortName(jsonObject.getString("mchShortName"));
        mchInfo.setMchType(jsonObject.getString("mchtType"));
        mchInfo.setRegisterAddress(jsonObject.getString("address"));
        mchInfo.setBusinessAddress(jsonObject.getString("address"));
        mchInfo.setBusinessAddressName(jsonObject.getString("addressName"));
        mchInfo.setBusinessProviceCode(jsonObject.getString("proviceCode"));
        mchInfo.setBusinessCityCode(jsonObject.getString("cityCode"));
        mchInfo.setBusinessCountyCode(jsonObject.getString("countryCode"));
        mchInfo.setBusinessLicense(jsonObject.getString("businessLicense"));
        mchInfo.setBusinessAmt(jsonObject.getString("businessAmt"));
        mchInfo.setBusinessExpireStart(jsonObject.getString("businessExpireStart"));
        mchInfo.setBusinessExpireEnd(jsonObject.getString("businessExpireEnd"));
        mchInfo.setEnterpriseScale(jsonObject.getString("enterpriseScale"));
        mchInfo.setEnterpriseCategory(jsonObject.getString("enterpriseCategory"));


        mchInfo.setLegalName(jsonObject.getString("contactName"));
        mchInfo.setLegalCertType(jsonObject.getString("contactCertType"));
        mchInfo.setLegalCertNo(AESUtil.encrypt(jsonObject.getString("contactCertNo"),AESUtil.key));
        mchInfo.setLegalExpireStart(jsonObject.getString("contactExpireStart"));
        mchInfo.setLegalExpireEnd(jsonObject.getString("contactExpireEnd"));
        mchInfo.setLegalPhone(AESUtil.encrypt(jsonObject.getString("legalPhone"),AESUtil.key));

        mchInfo.setContactName(jsonObject.getString("contactName"));
        mchInfo.setContactCertType(jsonObject.getString("contactCertType"));
        mchInfo.setContactCertNo(AESUtil.encrypt(jsonObject.getString("contactCertNo"),AESUtil.key));
        mchInfo.setContactExpireStart(jsonObject.getString("contactExpireStart"));
        mchInfo.setContactExpireEnd(jsonObject.getString("contactExpireEnd"));
        mchInfo.setContactPhone(AESUtil.encrypt(jsonObject.getString("contactPhone"),AESUtil.key));
        mchInfo.setContactEmail(jsonObject.getString("contactEmail"));
        mchInfo.setSettleCycle(jsonObject.getString("settleCycle"));

        return mchInfo;
    }
    public static MchInfo buildEdit(JSONObject jsonObject) {
        MchInfo mchInfo = new MchInfo();
        if (!StringUtils.isEmpty(jsonObject.getString("mchName"))){
            mchInfo.setMchName(jsonObject.getString("mchName"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("mchShortName"))) {
            mchInfo.setMchShortName(jsonObject.getString("mchShortName"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("mchtType"))) {
            mchInfo.setMchType(jsonObject.getString("mchtType"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("address"))) {
            mchInfo.setRegisterAddress(jsonObject.getString("address"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("address"))) {
            mchInfo.setBusinessAddress(jsonObject.getString("address"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("addressName"))) {
            mchInfo.setBusinessAddressName(jsonObject.getString("addressName"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("proviceCode"))) {
            mchInfo.setBusinessProviceCode(jsonObject.getString("proviceCode"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("cityCode"))) {
            mchInfo.setBusinessCityCode(jsonObject.getString("cityCode"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("countryCode"))) {
            mchInfo.setBusinessCountyCode(jsonObject.getString("countryCode"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("businessLicense"))) {
            mchInfo.setBusinessLicense(jsonObject.getString("businessLicense"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("businessAmt"))) {
            mchInfo.setBusinessAmt(jsonObject.getString("businessAmt"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("businessExpireStart"))) {
            mchInfo.setBusinessExpireStart(jsonObject.getString("businessExpireStart"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("businessExpireEnd"))) {
            mchInfo.setBusinessExpireEnd(jsonObject.getString("businessExpireEnd"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("enterpriseScale"))) {
            mchInfo.setEnterpriseScale(jsonObject.getString("enterpriseScale"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("enterpriseCategory"))) {
            mchInfo.setEnterpriseCategory(jsonObject.getString("enterpriseCategory"));
        }

        if (!StringUtils.isEmpty(jsonObject.getString("contactName"))) {
            mchInfo.setLegalName(jsonObject.getString("contactName"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("contactCertType"))) {
            mchInfo.setLegalCertType(jsonObject.getString("contactCertType"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("contactCertNo"))) {
            mchInfo.setLegalCertNo(AESUtil.encrypt(jsonObject.getString("contactCertNo"), AESUtil.key));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("contactExpireStart"))) {
            mchInfo.setLegalExpireStart(jsonObject.getString("contactExpireStart"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("contactExpireEnd"))) {
            mchInfo.setLegalExpireEnd(jsonObject.getString("contactExpireEnd"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("legalPhone"))) {
            mchInfo.setLegalPhone(AESUtil.encrypt(jsonObject.getString("legalPhone"), AESUtil.key));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("contactName"))) {
            mchInfo.setContactName(jsonObject.getString("contactName"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("contactCertType"))) {
            mchInfo.setContactCertType(jsonObject.getString("contactCertType"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("contactCertNo"))) {
            mchInfo.setContactCertNo(AESUtil.encrypt(jsonObject.getString("contactCertNo"), AESUtil.key));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("contactExpireStart"))) {
            mchInfo.setContactExpireStart(jsonObject.getString("contactExpireStart"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("contactExpireEnd"))) {
            mchInfo.setContactExpireEnd(jsonObject.getString("contactExpireEnd"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("contactPhone"))) {
            mchInfo.setContactPhone(AESUtil.encrypt(jsonObject.getString("contactPhone"), AESUtil.key));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("contactEmail"))) {
            mchInfo.setContactEmail(jsonObject.getString("contactEmail"));
        }
        if (!StringUtils.isEmpty(jsonObject.getString("settleCycle"))) {
            mchInfo.setSettleCycle(jsonObject.getString("settleCycle"));
        }
        return mchInfo;
    }
}

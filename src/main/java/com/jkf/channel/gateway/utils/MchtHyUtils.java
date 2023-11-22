package com.jkf.channel.gateway.utils;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.entity.ChannelMchtHy;

/**
 * @author xiangyu
 * @date 2023/11/21 10:32
 */
public class MchtHyUtils {
    /**
     * 构建分期的数据
     * @param fqParam
     * @return
     */
    public static ChannelMchtHy buildMchtHy(JSONObject fqParam){
        ChannelMchtHy channelMchtHy=new ChannelMchtHy();
        channelMchtHy.setChannelMchtName(fqParam.getString("mchName"));
        channelMchtHy.setShortName(fqParam.getString("mchShortName"));
        channelMchtHy.setCategoryType(fqParam.getString("categoryType"));
        channelMchtHy.setCorEmail(fqParam.getString("corEmail"));
        channelMchtHy.setCorTel(fqParam.getString("corTel"));
        channelMchtHy.setScale(fqParam.getString("scale"));
        channelMchtHy.setUserType(fqParam.getString("userType"));
        channelMchtHy.setBusinessLicenseNo(fqParam.getString("businessLicenseNo"));
        channelMchtHy.setBusinessLicenseExpireStart(fqParam.getString("businessLicenseIssDate"));
        channelMchtHy.setBusinessLicenseExpireEnd(fqParam.getString("businessLicenseExpiryDate"));
        channelMchtHy.setContactName(fqParam.getString("contactName"));
        channelMchtHy.setContactTel(fqParam.getString("contactTel"));
        channelMchtHy.setIdNotType(fqParam.getString("idNoType"));
        channelMchtHy.setIdNo(fqParam.getString("idNo"));
        channelMchtHy.setProvince(fqParam.getString("province"));
        channelMchtHy.setCity(fqParam.getString("city"));
        channelMchtHy.setDistrict(fqParam.getString("district"));
        channelMchtHy.setAddress(fqParam.getString("address"));
        channelMchtHy.setIssDate(fqParam.getString("issDate"));
        channelMchtHy.setExpiryDate(fqParam.getString("expiryDate"));
        channelMchtHy.setContactEmail(fqParam.getString("contactEmail"));
        channelMchtHy.setPeriods("3,6,12,24");
        channelMchtHy.setChannelName(fqParam.getString("channelName"));
        
        return channelMchtHy;
    }
}

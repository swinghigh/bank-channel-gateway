package com.jkf.channel.gateway.constant;

/**
 * @author xiangyu
 * @date 2023/10/30 15:53
 */
public enum ChannelCode {
    HUOYAN("hychannel","火眼"),
    XINLIAN("xlchannel","信联支付")
    ;

    private String channelCompanyCode;
    private String desc;

    ChannelCode(String channelCompanyCode, String desc) {
        this.channelCompanyCode = channelCompanyCode;
        this.desc = desc;
    }

    public String getChannelCompanyCode() {
        return channelCompanyCode;
    }

    public void setChannelCompanyCode(String channelCompanyCode) {
        this.channelCompanyCode = channelCompanyCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

package com.jkf.channel.gateway.constant;

public enum OpenMethodEnum {
    TEST("TEST","测试"),
    FILE_UPLOAD("FILE_UPLOAD","图片上传"),
    AGENT_ADD("AGENT_ADD","代理商添加"),
    AGENT_EDIT("AGENT_EDIT","代理商修改"),
    AGENT_QUERY("AGENT_QUERY","代理商查询"),
    USER_ADD("USER_ADD","用户注册"),
    USER_EDIT("USER_EDIT","用户修改"),
    USER_QUERY("USER_QUERY","用户查询"),
    FQ_MCHT_ADD("FQ_MCHT_ADD","分期商户开通"),
    FQ_MCHT_EDIT("FQ_MCHT_EDIT","分期商户修改"),
    FQ_MCHT_QUERY("FQ_MCHT_QUERY","分期商户信息查询"),
    FQ_MCHT_BIND_CARD("FQ_MCHT_BIND_CARD","分期商户绑银行卡"),
    FQ_MCHT_ADDRESS("FQ_MCHT_ADDRESS","分期商户地址添加"),
    FQ_MCHT_FACE_AUTH("FQ_MCHT_FACE_AUTH","分期商户人脸认证"),
    FQ_MCHT_FACE_AUTH_QUERY("FQ_MCHT_FACE_AUTH_QUERY","分期商户人脸认证查询"),
    ;

    private String method;
    private String desc;

    OpenMethodEnum(String method, String desc) {
        this.method = method;
        this.desc = desc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

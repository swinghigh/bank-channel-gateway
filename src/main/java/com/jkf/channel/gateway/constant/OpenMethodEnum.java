package com.jkf.channel.gateway.constant;

public enum OpenMethodEnum {
    TEST("TEST","测试"),
    FILE_UPLOAD("FILE_UPLOAD","图片上传"),
    AGENT_ADD("AGENT_ADD","代理商添加"),
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

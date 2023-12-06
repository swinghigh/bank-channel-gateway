package com.jkf.channel.gateway.service;

/**
 * @author xiangyu
 * @date 2023/12/5 20:30
 */
public interface IVirtualAccountService {
    /**
     * 创建虚拟，并返回账户编号
     * @param accountType
     * @return
     */
    public String createAccount(String accountType);
}

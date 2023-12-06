package com.jkf.channel.gateway.service;

import com.jkf.channel.gateway.entity.AgentInfo;

import java.util.List;

/**
 * @author xiangyu
 * @date 2023/12/6 19:17
 */
public interface AgentService {
    /**
     * 查询商户的所有的上级代理商(包含传入的代理商自身)
     * @param mchtAgentId
     * @return
     */
    public List<AgentInfo>  queryMchtAllUpperAgent(Long mchtAgentId);

    /**
     * 查询当前传入代理商的上级代理商,(不不含自身)
     * @param agentId
     * @return
     */
    public List<AgentInfo> queryAgentAllUpperAgent(Long agentId);
}

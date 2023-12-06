package com.jkf.channel.gateway.service.impl;

import com.jkf.channel.gateway.dao.AgentInfoMapper;
import com.jkf.channel.gateway.entity.AgentInfo;
import com.jkf.channel.gateway.service.AgentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangyu
 * @date 2023/12/6 19:21
 */
@Service
public class AgentServiceImpl implements AgentService {
    @Resource
    private AgentInfoMapper agentInfoMapper;
    @Override
    public List<AgentInfo> queryMchtAllUpperAgent(Long mchtAgentId) {
        AgentInfo agentInfo=agentInfoMapper.selectByPrimaryKey(mchtAgentId);
        List<AgentInfo> list=new ArrayList<>();
        if(agentInfo==null){
            return list;
        }
        list.add(agentInfo);
        List<AgentInfo> topAgentList=queryAgentAllUpperAgent(agentInfo.getPAgentId());
        if(topAgentList!=null&&topAgentList.size()>0){
            list.addAll(topAgentList);
        }
        return list;
    }

    @Override
    public List<AgentInfo> queryAgentAllUpperAgent(Long agentId) {
        AgentInfo agentInfo=agentInfoMapper.selectByPrimaryKey(agentId);
        if(agentInfo==null){
            return new ArrayList<>();
        }
        List<AgentInfo> list=new ArrayList<>();
        while (agentInfo!=null&&agentInfo.getPAgentId()!=null&&agentInfo.getPAgentId()!=0){
            agentInfo=agentInfoMapper.selectByPrimaryKey(agentInfo.getPAgentId());
            if(agentInfo!=null){
                list.add(agentInfo);
            }
        }
        return list;
    }
}

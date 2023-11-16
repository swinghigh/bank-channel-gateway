package com.jkf.channel.gateway.handler.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.KeyConstants;
import com.jkf.channel.gateway.constant.OpenMethodEnum;
import com.jkf.channel.gateway.dao.AgentInfoMapper;
import com.jkf.channel.gateway.dao.FileInfoMapper;
import com.jkf.channel.gateway.dao.FileInfoRelationMapper;
import com.jkf.channel.gateway.entity.*;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.handler.IOpenHandler;
import com.jkf.channel.gateway.utils.AgentUtils;
import com.jkf.channel.gateway.utils.AssertUtils;
import com.jkf.channel.gateway.utils.FileContentUtils;
import com.jkf.channel.gateway.utils.ResultUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xiangyu
 * @date 2023/11/16 14:25
 */
@Service
public class AgentEditHandler implements IOpenHandler {
    @Resource
    private AgentInfoMapper agentInfoMapper;
    @Resource
    private FileInfoRelationMapper fileInfoRelationMapper;
    @Resource
    private FileInfoMapper fileInfoMapper;
    @Override
    public String getMethod() {
        return OpenMethodEnum.AGENT_EDIT.getMethod();
    }
    public void validateImage(String agentType,Map<String, String> fileMap){
        if(fileMap==null||fileMap.size()==0){
            return;
        }
        //判断照片是否存在
        List<String> fileIds=new ArrayList<>();
        fileMap.values().stream().forEach(value -> fileIds.add(value));
        FileInfoRelationExample example=new FileInfoRelationExample();
        example.createCriteria().andFileIdIn(fileIds);
        List<FileInfoRelation> res=fileInfoRelationMapper.selectByExample(example);
        if(res==null||res.size()==0){
            throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(),"存在未传入系统的fileId");
        }
        List<String> fileIdsList=res.stream().map(e->e.getFileId()).collect(Collectors.toList());
        fileMap.values().stream().forEach(value -> {
            if(!fileIdsList.contains(value)){
                throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(),value+"系统不存在");
            }
        });
    }
    @Override
    @Transactional
    public Map<String, Object> handler(JSONObject jsonObject) {
        AssertUtils.customHasLength(jsonObject.getString("outAgentNo"), ErrorCode.PARAM_ERROR.getErrorCode(),"机构代理商编号为空");
        AssertUtils.customHasLength(jsonObject.getString("orgId"), ErrorCode.PARAM_ERROR.getErrorCode(),"所属机构为空");
        AgentInfoExample example=new AgentInfoExample();
        example.createCriteria().andOutAgentNoEqualTo(jsonObject.getString("outAgentNo")).andOrgIdEqualTo(jsonObject.getLong("orgId"));
        List<AgentInfo> agentInfos=agentInfoMapper.selectByExample(example);
        AssertUtils.collectIsEmpty(agentInfos,ErrorCode.PARAM_ERROR.getErrorCode(),"代理商不存在");
        AgentInfo agentInfo=agentInfos.get(0);
        JSONArray fileContent = jsonObject.getJSONArray("fileContent");
        Map<String, String> fileMap= FileContentUtils.convertPhotos(fileContent);
        //保存代理商信息
        AgentInfo agentInfoEdit= AgentUtils.buildAgentInfoEdit(jsonObject);
        agentInfoEdit.setId(agentInfo.getId());
        agentInfoEdit.setUpdateId(0L);
        agentInfoEdit.setUpdateTime(new Date());
        agentInfoMapper.updateByPrimaryKeySelective(agentInfoEdit);
        //插入图片关联
        if(fileMap!=null&&fileMap.size()>0){
            fileMap.keySet().stream().forEach(key -> {
                FileInfo fileInfo=new FileInfo();
                fileInfo.setNo(agentInfo.getId()+"");
                fileInfo.setNoType("4");
                fileInfo.setFileType(key);
                fileInfo.setFileId(fileMap.get(key));
                fileInfo.setUpdateTime(new Date());
                fileInfo.setUpdateId(0L);
                FileInfoExample fileExample=new FileInfoExample();
                fileExample.createCriteria().andNoTypeEqualTo("4")
                        .andNoEqualTo(agentInfo.getId()+"")
                        .andFileTypeEqualTo(key);
                fileInfoMapper.updateByExampleSelective(fileInfo,fileExample);
            });
        }
        Map<String, Object> result = ResultUtils.businessResult(ErrorCode.SUCCESS.getErrorCode(), "修改成功");
        result.put("agentId", agentInfo.getId());
        return result;
    }
}

package com.jkf.channel.gateway.handler.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.KeyConstants;
import com.jkf.channel.gateway.constant.OpenMethodEnum;
import com.jkf.channel.gateway.dao.AgentInfoMapper;
import com.jkf.channel.gateway.dao.FileInfoMapper;
import com.jkf.channel.gateway.dao.FileInfoRelationMapper;
import com.jkf.channel.gateway.entity.AgentInfo;
import com.jkf.channel.gateway.entity.AgentInfoExample;
import com.jkf.channel.gateway.entity.FileInfo;
import com.jkf.channel.gateway.entity.FileInfoRelationExample;
import com.jkf.channel.gateway.exception.BusinessException;
import com.jkf.channel.gateway.handler.IOpenHandler;
import com.jkf.channel.gateway.utils.AgentUtils;
import com.jkf.channel.gateway.utils.AssertUtils;
import com.jkf.channel.gateway.utils.FileContentUtils;
import com.jkf.channel.gateway.utils.ResultUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 代理商添加
 * @author xiangyu
 * @date 2023/11/14 15:02
 */
@Service
public class AgentHandler implements IOpenHandler {
    @Resource
    private AgentInfoMapper agentInfoMapper;
    @Resource
    private FileInfoRelationMapper fileInfoRelationMapper;
    @Resource
    private FileInfoMapper fileInfoMapper;
    @Override
    public String getMethod() {
        return OpenMethodEnum.AGENT_ADD.getMethod();
    }
    private void validate(JSONObject jsonObject){
        AssertUtils.customHasLength(jsonObject.getString("orgId"), ErrorCode.PARAM_ERROR.getErrorCode(),"所属机构为空");
        AssertUtils.customHasLength(jsonObject.getString("outAgentNo"), ErrorCode.PARAM_ERROR.getErrorCode(),"机构代理商编号为空");
        AgentInfoExample example=new AgentInfoExample();
        example.createCriteria().andOrgIdEqualTo(Long.parseLong(jsonObject.getString("orgId")))
                .andOutAgentNoEqualTo(jsonObject.getString("outAgentNo"));
        if(agentInfoMapper.countByExample(example)>0){
            throw new BusinessException(ErrorCode.HAS_EXIT.getErrorCode(),"代理商已存在");
        }
        AssertUtils.customHasLength(jsonObject.getString("proviceCode"), ErrorCode.PARAM_ERROR.getErrorCode(),"省编号为空");
        AssertUtils.customHasLength(jsonObject.getString("cityCode"), ErrorCode.PARAM_ERROR.getErrorCode(),"市编号为空");
        AssertUtils.customHasLength(jsonObject.getString("countryCode"), ErrorCode.PARAM_ERROR.getErrorCode(),"区编号为空");
        AssertUtils.customHasLength(jsonObject.getString("address"), ErrorCode.PARAM_ERROR.getErrorCode(),"地址为空");
        AssertUtils.customHasLength(jsonObject.getString("agentType"), ErrorCode.PARAM_ERROR.getErrorCode(),"代理商类型为空");
        if(!KeyConstants.AGENT_TYPE_MICRO.equals(jsonObject.getString("agentType"))){
            AssertUtils.customHasLength(jsonObject.getString("businessLicense"), ErrorCode.PARAM_ERROR.getErrorCode(),"businessLicense为空");
            AssertUtils.customHasLength(jsonObject.getString("businessAmt"), ErrorCode.PARAM_ERROR.getErrorCode(),"businessAmt为空");
            AssertUtils.customHasLength(jsonObject.getString("businessExpireStart"), ErrorCode.PARAM_ERROR.getErrorCode(),"businessExpireStart为空");
            AssertUtils.customHasLength(jsonObject.getString("businessExpireEnd"), ErrorCode.PARAM_ERROR.getErrorCode(),"businessExpireEnd为空");
            AssertUtils.customHasLength(jsonObject.getString("legalName"), ErrorCode.PARAM_ERROR.getErrorCode(),"legalName为空");
            AssertUtils.customHasLength(jsonObject.getString("legalCertType"), ErrorCode.PARAM_ERROR.getErrorCode(),"legalCertType为空");
            AssertUtils.customHasLength(jsonObject.getString("legalCertNo"), ErrorCode.PARAM_ERROR.getErrorCode(),"legalCertNo为空");
            AssertUtils.customHasLength(jsonObject.getString("legalPhone"), ErrorCode.PARAM_ERROR.getErrorCode(),"legalPhone为空");
            AssertUtils.customHasLength(jsonObject.getString("legalExpireStart"), ErrorCode.PARAM_ERROR.getErrorCode(),"legalExpireStart为空");
            AssertUtils.customHasLength(jsonObject.getString("legalExpireEnd"), ErrorCode.PARAM_ERROR.getErrorCode(),"legalExpireEnd为空");

        }else{
            jsonObject.put("legalName",jsonObject.getString("contactName"));
            jsonObject.put("legalCertType",jsonObject.getString("contactCertType"));
            jsonObject.put("legalCertNo",jsonObject.getString("contactCertNo"));
            jsonObject.put("legalPhone",jsonObject.getString("contactPhone"));
            AssertUtils.customHasLength(jsonObject.getString("legalExpireStart"), ErrorCode.PARAM_ERROR.getErrorCode(),"legalExpireStart为空");
            AssertUtils.customHasLength(jsonObject.getString("legalExpireEnd"), ErrorCode.PARAM_ERROR.getErrorCode(),"legalExpireEnd为空");
        }
        AssertUtils.customHasLength(jsonObject.getString("contactName"), ErrorCode.PARAM_ERROR.getErrorCode(),"contactName为空");
        AssertUtils.customHasLength(jsonObject.getString("contactCertType"), ErrorCode.PARAM_ERROR.getErrorCode(),"contactCertType为空");
        AssertUtils.customHasLength(jsonObject.getString("contactCertNo"), ErrorCode.PARAM_ERROR.getErrorCode(),"contactCertNo为空");
        AssertUtils.customHasLength(jsonObject.getString("contactPhone"), ErrorCode.PARAM_ERROR.getErrorCode(),"contactPhone为空");
    }
    public void validateImage(String agentType,Map<String, String> fileMap){
        if(!KeyConstants.AGENT_TYPE_MICRO.equals(agentType)){
            AssertUtils.customHasLength(fileMap.get("1"), ErrorCode.PARAM_ERROR.getErrorCode(),"营业执照照片为空");
            AssertUtils.customHasLength(fileMap.get("2"), ErrorCode.PARAM_ERROR.getErrorCode(),"法人身份证正面为空");
            AssertUtils.customHasLength(fileMap.get("3"), ErrorCode.PARAM_ERROR.getErrorCode(),"法人身份证反面为空");
        }
        AssertUtils.customHasLength(fileMap.get("4"), ErrorCode.PARAM_ERROR.getErrorCode(),"联系人身份证正面为空");
        AssertUtils.customHasLength(fileMap.get("5"), ErrorCode.PARAM_ERROR.getErrorCode(),"联系人身份证反面为空");
        //判断照片是否存在
        List<String> fileIds=new ArrayList<>();
        fileMap.values().stream().forEach(value -> fileIds.add(value));
        FileInfoRelationExample example=new FileInfoRelationExample();
        example.createCriteria().andFileIdIn(fileIds);
        int size=fileInfoRelationMapper.countByExample(example);
        if(size!=fileIds.size()){
            throw new BusinessException(ErrorCode.PARAM_ERROR.getErrorCode(),"存在未传入系统的fileId");
        }
    }

    @Override
    @Transactional
    public Map<String, Object> handler(JSONObject jsonObject) {
        validate(jsonObject);
        if(!StringUtils.isEmpty(jsonObject.getString("pAgentId"))){
            AgentInfo agentInfo=agentInfoMapper.selectByPrimaryKey(Long.parseLong(jsonObject.getString("pAgentId")));
            AssertUtils.customNotNull(agentInfo,ErrorCode.PARAM_ERROR.getErrorCode(),"上级代理商不存在");
        }
        JSONArray fileContent = jsonObject.getJSONArray("fileContent");
        Map<String, String> fileMap=FileContentUtils.convertPhotos(fileContent);
        validateImage(jsonObject.getString("agentType"),fileMap);
        //保存代理商信息
        AgentInfo agentInfo=AgentUtils.buildAgentInfo(jsonObject);
        agentInfo.setCreateTime(new Date());
        agentInfo.setCreateId(0L);
        agentInfo.setStatus("0");
        agentInfo.setAgentNature("2");
        agentInfo.setAgentLevel("0");
        agentInfoMapper.insertSelective(agentInfo);
        agentInfo.setAgentNo("A"+(100000+agentInfo.getId()));
        agentInfoMapper.updateByPrimaryKey(agentInfo);
        //插入图片关联
        if(fileMap!=null&&fileMap.size()>0){
            List<FileInfo> files=new ArrayList<>();
            fileMap.keySet().stream().forEach(key -> {
                FileInfo fileInfo=new FileInfo();
                fileInfo.setNo(agentInfo.getId()+"");
                fileInfo.setNoType("4");
                fileInfo.setFileType(key);
                fileInfo.setFileId(fileMap.get(key));
                fileInfo.setCreateTime(new Date());
                fileInfo.setId(0L);
                files.add(fileInfo);
            });
            fileInfoMapper.patchInsert(files);
        }
        Map<String, Object> result = ResultUtils.businessResult(ErrorCode.SUCCESS.getErrorCode(), "上传成功");
        result.put("agentId", agentInfo.getId());
        return result;
    }
}

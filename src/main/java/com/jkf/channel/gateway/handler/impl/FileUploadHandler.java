package com.jkf.channel.gateway.handler.impl;

import com.alibaba.fastjson.JSONObject;
import com.jkf.channel.gateway.constant.ErrorCode;
import com.jkf.channel.gateway.constant.OpenMethodEnum;
import com.jkf.channel.gateway.dao.FileInfoRelationMapper;
import com.jkf.channel.gateway.entity.FileInfoRelation;
import com.jkf.channel.gateway.handler.IOpenHandler;
import com.jkf.channel.gateway.utils.AssertUtils;
import com.jkf.channel.gateway.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @author xiangyu
 * @date 2023/11/9 20:13
 */
@Service
@Slf4j
public class FileUploadHandler implements IOpenHandler {
    @Resource
    private FileInfoRelationMapper fileInfoRelationMapper;
    @Autowired
    private FastDFSClientWrapper fastDFSClientWrapper;
    @Value("${file.imgUrl}")
    private String imgUrl;
    @Override
    public String getMethod() {
        return OpenMethodEnum.FILE_UPLOAD.getMethod();
    }

    /**
     * 1.图片上传到文件服务器
     * 2.将文件id和文件服务器的id的关系存入数据库中
     * @param jsonObject
     * @return
     */
    @Override
    public Map<String, Object> handler(JSONObject jsonObject) {
        String fileName=jsonObject.getString("fileName");
        String fileBase64=jsonObject.getString("fileContent");
        AssertUtils.customHasLength(fileName, ErrorCode.PARAM_ERROR.getErrorCode(),"fileName为空");
        AssertUtils.customHasLength(fileBase64, ErrorCode.PARAM_ERROR.getErrorCode(),"fileContent为空");
        //将Base64转文件
        try {
            String path = fastDFSClientWrapper.uploadFileBase64(fileBase64, fileName);
            //将文件保存到数据库中
            FileInfoRelation record = new FileInfoRelation();
            record.setFileName(fileName);
            record.setFileId(UUID.randomUUID().toString().replace("-", ""));
            record.setFileFastPath(path);
            record.setCreateTime(new Date());
            fileInfoRelationMapper.insert(record);
            Map<String, Object> result = ResultUtils.businessResult(ErrorCode.SUCCESS.getErrorCode(), "上传成功");
            result.put("fileId", record.getFileId());
            result.put("path", imgUrl+record.getFileFastPath());
            return result;
        }catch (Exception e){
            log.error("文件上传失败",e);
            return ResultUtils.defaultBusinessResult("文件上传失败");
        }
    }
}

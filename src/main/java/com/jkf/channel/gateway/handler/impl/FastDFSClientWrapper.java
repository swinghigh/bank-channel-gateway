package com.jkf.channel.gateway.handler.impl;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.jkf.channel.gateway.utils.Base64DecodeMultipartFile;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.UUID;

/**
 * @author puyiliang
 * @date 2021/4/6 16:31
 */
@Component
@SuppressWarnings("all")
public class FastDFSClientWrapper {
    @Autowired
    private FastFileStorageClient storageClient;


//    @Autowired
//    private AppConfig appConfig;   // 项目参数配置
    /**
     * 上传文件
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException e
     */
    public String uploadFileBase64(String content,String fileName) throws IOException {
       return uploadFile(Base64DecodeMultipartFile.base64Convert(content,fileName));
    }
    /**
     * 上传文件
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException e
     */
    public String uploadFile(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadFile(file.getInputStream(),file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),null);
        String path= storePath.getFullPath();
        return path;
    }
    /**
     * 上传文件
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException e
     */
    public String uploadFile(File file) throws IOException {
        try (InputStream inputStream = new FileInputStream(file)) {
            StorePath storePath = storageClient.uploadFile(inputStream, file.length(), FilenameUtils.getExtension(file.getName()), null);
            return storePath.getFullPath();
        }
    }
    /**
     * 将一段字符串生成一个文件上传
     * @param content 文件内容
     * @param fileExtension
     * @return
     */
    public String uploadFile(String content, String fileExtension) {
        byte[] buff = content.getBytes(Charset.forName("UTF-8"));
        ByteArrayInputStream stream = new ByteArrayInputStream(buff);
        StorePath storePath = storageClient.uploadFile(stream,buff.length, fileExtension,null);
        return storePath.getFullPath();
    }

    // 封装图片完整URL地址
//    private String getResAccessUrl(StorePath storePath) {
//        String fileUrl = AppConstants.HTTP_PRODOCOL + appConfig.getResHost()
//                + ":" + appConfig.getFdfsStoragePort() + "/" + storePath.getFullPath();
//        return fileUrl;
//    }

    /**
     * 删除文件
     * @param fileUrl 文件访问地址
     * @return
     */
//    public void deleteFile(String fileUrl) {
//        if (StringUtils.isEmpty(fileUrl)) {
//            return;
//        }
//        try {
//            StorePath storePath = StorePath.praseFromUrl(fileUrl);
//            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
//        } catch (FdfsUnsupportStorePathException e) {
//            logger.warn(e.getMessage());
//        }
//    }
}

package com.jkf.channel.gateway.utils;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * BASE64转 MultipartFile
 * @author Administrator
 */
public class Base64DecodeMultipartFile implements MultipartFile {
    private final byte[] imgContent;
    private final String header;
    private String fileName;

    public Base64DecodeMultipartFile(byte[] imgContent, String header) {
        this.imgContent = imgContent;
        this.header = header.split(";")[0];
    }
    public Base64DecodeMultipartFile(byte[] imgContent, String header, String fileName) {
        this.imgContent = imgContent;
        this.header = header.split(";")[0];
        this.fileName=fileName;
    }
    @Override
    public String getName() {
        if(fileName==null||"".equals(fileName)){
            return System.currentTimeMillis() + Math.random() + "." + header.split("/")[1];
        }else {
            return fileName;
        }
    }

    @Override
    public String getOriginalFilename() {
        if(fileName==null||"".equals(fileName)){
            return System.currentTimeMillis() + (int) Math.random() * 10000 + "." + header.split("/")[1];
        }else {
            return fileName;
        }
    }

    @Override
    public String getContentType() {
        return header.split(":")[1];
    }

    @Override
    public boolean isEmpty() {
        return imgContent == null || imgContent.length == 0;
    }

    @Override
    public long getSize() {
        return imgContent.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return imgContent;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(imgContent);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        new FileOutputStream(dest).write(imgContent);
    }

    /**
     * base64转multipartFile
     *
     * @param base64
     * @return
     */
    public static MultipartFile base64Convert(String base64) {
        String[] baseStr = base64.split(",");
        if(baseStr.length < 2){
            base64 = "data:image/jpeg;base64," + base64;
            baseStr = base64.split(",");
        }

       /* BASE64Decoder decoder = new BASE64Decoder();
        byte[] b = new byte[0];
        try {
            b = decoder.decodeBuffer(baseStr[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        byte[] b =  Base64.decodeBase64(baseStr[1]);
        for (int i = 0; i < b.length; ++i) {
            if (b[i] < 0) {
                b[i] += 256;
            }
        }
        return new Base64DecodeMultipartFile(b, baseStr[0]);
    }
    public static MultipartFile base64Convert(String base64, String fileName) {
        String[] baseStr = base64.split(",");
        if(baseStr.length < 2){
            base64 = "data:image/jpeg;base64," + base64;
            baseStr = base64.split(",");
        }
        byte[] b =  Base64.decodeBase64(baseStr[1]);
       /* BASE64Decoder decoder = new BASE64Decoder();
        byte[] b = new byte[0];
        try {
            b = decoder.decodeBuffer(baseStr[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        for (int i = 0; i < b.length; ++i) {
            if (b[i] < 0) {
                b[i] += 256;
            }
        }
        return new Base64DecodeMultipartFile(b, baseStr[0],fileName);
    }

    public static void main(String[] args) throws IOException {

    }

    /**
     * url转multipartFile
     *
     * @param url
     * @return
     */
    /*public static MultipartFile urlChangeMultipartFile(String url, String fileName) throws IOException {
//        InputStream inputStream = getImageStream("https://picture.yhtdpay.com:30001/group1/M00/00/35/CkgNZ2I5i4iAaVskAACtaGWmMRc023.jpg");
        InputStream inputStream = getImageStream(url);
        MultipartFile multipartFile = new MockMultipartFile(fileName,fileName, MediaType.MULTIPART_FORM_DATA_VALUE, inputStream);
        //MultipartFile file = new MockMultipartFile(ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream);
        inputStream.close();
        return multipartFile;
    }*/

    /**
     * 获取网络图片流
     *
     * @param url
     * @return
     */
    public static InputStream getImageStream(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                return inputStream;
            }
        } catch (IOException e) {
            System.out.println("获取网络图片出现异常，图片路径为：" + url);
            e.printStackTrace();
        }
        return null;
    }

    public static String getBase64FromInputStream(InputStream in) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[100];
            int rc = 0;
            while ((rc = in.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            data = swapStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new String(Base64.encodeBase64(data));
    }

}

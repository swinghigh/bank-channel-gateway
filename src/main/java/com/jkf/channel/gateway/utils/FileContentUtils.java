package com.jkf.channel.gateway.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiangyu
 * @date 2023/11/14 16:05
 */
public class FileContentUtils {

    public static Map<String, String> convertPhotos(JSONArray fileContent) {
        Map<String, String> photos = new HashMap<>();
        if (fileContent == null || fileContent.size() == 0) {
            return photos;
        }
        for (int i = 0; i < fileContent.size(); i++) {
            JSONObject jsonObject = fileContent.getJSONObject(i);
            photos.put(jsonObject.getString("type"), jsonObject.getString("fileId"));
        }
        return photos;
    }
}

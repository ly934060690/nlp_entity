package com.edu.cs.zutnlp.entity.translate.service.impl;

import com.edu.cs.zutnlp.entity.base.service.impl.GenericManagerImpl;
import com.edu.cs.zutnlp.entity.translate.dao.YoudaoDao;
import com.edu.cs.zutnlp.entity.translate.domain.Youdao;
import com.edu.cs.zutnlp.entity.translate.service.YoudaoManager;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @ClassName YoudaoManagerImpl
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/7/22 17:07
 * @Version 1.0
 */
@Component
@Transactional
public class YoudaoManagerImpl extends GenericManagerImpl<Youdao, Long> implements YoudaoManager {

    YoudaoDao youdaoDao;

    @Autowired
    public void setYoudaoDao(YoudaoDao youdaoDao) {
        this.youdaoDao = youdaoDao;
        this.dao = this.youdaoDao;
    }

    /**
     * 1. translate
     * 2. Stream to String
     *
     * @param text
     */
    @Override
    public String translate(String text) {
        final String Youdao_Url = "http://fanyi.youdao.com/openapi.do?keyfrom=sxt102400&key=1695079984&type=data&doctype=json&version=1.1&q=";
        String rawData = null;
        StringBuilder YoudaoAPIURL = new StringBuilder();
        try {
            YoudaoAPIURL.append(Youdao_Url).append(URLEncoder.encode(text, "UTF-8"));
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(YoudaoAPIURL.toString()).openConnection();
            rawData=streamToString(httpURLConnection.getInputStream());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonObject jsonObj = new JsonParser().parse(rawData).getAsJsonObject();
        if ("0".equals(jsonObj.get("errorCode").toString())) {
            String finalData = jsonObj.get("translation").getAsString();
            return finalData;
        } else {
            return "Error!";
        }
    }

    @Override
    public String streamToString(InputStream is) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringWriter writer = new StringWriter();
            char[] buffer = new char[10240];
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            reader.close();
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

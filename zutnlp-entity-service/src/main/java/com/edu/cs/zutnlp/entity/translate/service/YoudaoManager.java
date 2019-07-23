package com.edu.cs.zutnlp.entity.translate.service;

import com.edu.cs.zutnlp.entity.base.service.GenericManager;
import com.edu.cs.zutnlp.entity.translate.domain.Youdao;

import java.io.InputStream;

/**
 * @ClassName YoudaoManager
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/7/22 17:07
 * @Version 1.0
 */
public interface YoudaoManager extends GenericManager<Youdao, Long> {
    /**
     * 1. translate
     * 2. Stream to String
     */
    String translate(String text);
    String streamToString(InputStream is);
}

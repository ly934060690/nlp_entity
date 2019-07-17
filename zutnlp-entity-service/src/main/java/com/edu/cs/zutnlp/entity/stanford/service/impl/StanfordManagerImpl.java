package com.edu.cs.zutnlp.entity.stanford.service.impl;

import com.edu.cs.zutnlp.entity.base.service.impl.GenericManagerImpl;
import com.edu.cs.zutnlp.entity.stanford.dao.StanfordDao;
import com.edu.cs.zutnlp.entity.stanford.domain.Stanford;
import com.edu.cs.zutnlp.entity.stanford.service.StanfordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * @ClassName StanfordManagerImpl
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/7/17 9:22
 * @Version 1.0
 */
@Component
@Transactional
public class StanfordManagerImpl extends GenericManagerImpl<Stanford, Long> implements StanfordManager {

    StanfordDao stanfordDao;

    @Autowired
    public void setStanfordDao(StanfordDao stanfordDao) {
        this.stanfordDao = stanfordDao;
        this.dao = this.stanfordDao;
    }
}

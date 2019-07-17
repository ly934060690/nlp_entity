package com.edu.cs.zutnlp.entity.stanford.service;

import com.edu.cs.zutnlp.entity.base.service.GenericManagerTestCase;
import com.edu.cs.zutnlp.entity.stanford.domain.Stanford;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName StanfordManagerTestCase
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/7/17 10:00
 * @Version 1.0
 */
public class StanfordManagerTestCase extends GenericManagerTestCase<Long, Stanford, StanfordManager> {

    public StanfordManagerTestCase() {
        super(Stanford.class);
    }

    StanfordManager stanfordManager;

    @Autowired
    public void setStanfordManager(StanfordManager stanfordManager) {
        this.stanfordManager = stanfordManager;
        this.manager = this.stanfordManager;
    }

    @Test
    public void testFindAll() {
        List<Stanford> stanfordList = this.manager.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Stanford> stanfordList={}", stanfordList); //$NON-NLS-1$
        }
    }
}

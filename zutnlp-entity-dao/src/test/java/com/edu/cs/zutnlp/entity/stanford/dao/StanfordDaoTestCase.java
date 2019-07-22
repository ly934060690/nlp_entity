package com.edu.cs.zutnlp.entity.stanford.dao;

import com.edu.cs.zutnlp.entity.base.dao.GenericDaoTestCase;
import com.edu.cs.zutnlp.entity.stanford.domain.Stanford;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Table;
import java.util.List;

/**
 * @ClassName StanfordDaoTestCase
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/7/16 17:35
 * @Version 1.0
 */
public class StanfordDaoTestCase extends GenericDaoTestCase<Long, Stanford, StanfordDao> {

    StanfordDao stanfordDao;

    @Autowired
    public void setStanfordDao(StanfordDao stanfordDao) {
        this.stanfordDao = stanfordDao;
        this.dao = this.stanfordDao;
    }

    @Test
    public void findAll() {
        List<Stanford> stanfordList = this.dao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("findAll() - List<Stanford> stanfordList={}", stanfordList); //$NON-NLS-1$
        }
    }

}

package com.edu.cs.zutnlp.entity.translate.dao;

import com.edu.cs.zutnlp.entity.base.dao.GenericDaoTestCase;
import com.edu.cs.zutnlp.entity.translate.domain.Youdao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName YoudaoDaoTestCase
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/7/22 17:02
 * @Version 1.0
 */
public class YoudaoDaoTestCase extends GenericDaoTestCase<Long, Youdao, YoudaoDao> {

    YoudaoDao youdaoDao;

    @Autowired
    public void setYoudaoDao(YoudaoDao youdaoDao) {
        this.youdaoDao = youdaoDao;
        this.dao = this.youdaoDao;
    }

    @Test
    public void findAll() {
        List<Youdao> youdaoList = this.dao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("findAll() - List<Youdao> youdaoList={}", youdaoList); //$NON-NLS-1$
        }
    }
}

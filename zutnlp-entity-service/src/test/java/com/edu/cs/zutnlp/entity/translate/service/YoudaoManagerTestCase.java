package com.edu.cs.zutnlp.entity.translate.service;

import com.edu.cs.zutnlp.entity.base.service.GenericManagerTestCase;
import com.edu.cs.zutnlp.entity.translate.domain.Youdao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName YoudaoManagerTestCase
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/7/22 17:06
 * @Version 1.0
 */
public class YoudaoManagerTestCase extends GenericManagerTestCase<Long, Youdao, YoudaoManager> {

    public YoudaoManagerTestCase() {
        super(Youdao.class);
    }

    YoudaoManager youdaoManager;

    @Autowired
    public void setYoudaoManager(YoudaoManager youdaoManager) {
        this.youdaoManager = youdaoManager;
        this.manager = this.youdaoManager;
    }

    @Test
    public void testFindAll() {
        List<Youdao> youdaoList = this.manager.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Youdao> youdaoList={}", youdaoList); //$NON-NLS-1$
        }
    }

    @Test
    public void testTranslate() {
        String text = "我爱Ly，我爱我家宝宝，我爱我家小乖乖。我爱媳妇儿，我爱老婆！";
        String translate = this.manager.translate(text);
        if (logger.isInfoEnabled()) {
            logger.info("testTranslate() - String translate={}", translate); //$NON-NLS-1$
        }
    }
}

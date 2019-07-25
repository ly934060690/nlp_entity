package com.edu.cs.zutnlp.entity.stanford.service;

import com.edu.cs.zutnlp.entity.base.service.GenericManagerTestCase;
import com.edu.cs.zutnlp.entity.stanford.domain.Stanford;
import com.edu.cs.zutnlp.entity.translate.service.YoudaoManager;
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
    YoudaoManager youdaoManager;

    @Autowired
    public void setStanfordManager(StanfordManager stanfordManager) {
        this.stanfordManager = stanfordManager;
        this.manager = this.stanfordManager;
    }
    @Autowired
    public void setYoudaoManager(YoudaoManager youdaoManager) {
        this.youdaoManager = youdaoManager;
    }

    @Test
    public void testFindAll() {
        List<Stanford> stanfordList = this.manager.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Stanford> stanfordList={}", stanfordList); //$NON-NLS-1$
        }
    }

    @Test
    public void testGetEntity(){
//        String line= manager.getEntity("Tim Cook is the CEO of Apple, he replaced Steve Jobs, who died in 2011.");
        String text = "郑州是个好地方，汤姆和艾米在那上的大学";
        String entity = null;
        if (this.youdaoManager.isEnlish(text)) {
            entity = this.manager.getEntityEN(text);
        } else {
            entity = this.manager.getEntityCN(text);
        }
        if (logger.isInfoEnabled()) {
            logger.info("testGetEntity() - String entity={}", entity); //$NON-NLS-1$
        }
    }
    @Test
    public void testGetRelation(){
//        String Enlish = "Tim Cook is the CEO of Apple, he replaced Steve Jobs, who died in 2011.";
        String text = "郑州是个好地方，汤姆和艾米在那上的大学";
        String relation = null;
        if (this.youdaoManager.isEnlish(text)) {
            relation = this.manager.getRelationEN(text);
        } else {
            relation = this.manager.getRelationCN(text);
        }
        if (logger.isInfoEnabled()) {
            logger.info("testGetRelation() - String relation={}", relation); //$NON-NLS-1$
        }
    }
    @Test
    public void getAll(){
        String text = "Tim Cook is the CEO of Apple, he replaced Steve Jobs, who died in 2011";
        String entity = null;
        String relation = null;
        if (this.youdaoManager.isEnlish(text)) {
            entity = this.manager.getEntityEN(text);
            relation = this.manager.getRelationEN(text);
        } else {
            entity = this.manager.getEntityCN(text);
            relation = this.manager.getRelationCN(text);
        }

        System.out.println("分析的文本为：" + '\n' + text);
        System.out.println("实体为：" + '\n' + entity);
        System.out.println("实体关系为：" + '\n' + relation);

    }

}

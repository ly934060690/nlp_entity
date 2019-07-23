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
    public void getEntityTest(){
        String line="郑州是个好地方，汤姆和艾米在那上的大学";
        line = this.youdaoManager.translate(line);
//        String line= manager.getEntity("Tim Cook is the CEO of Apple, he replaced Steve Jobs, who died in 2011.");
        String entity= manager.getEntity(line);
        System.out.println(line + '\n' + entity);
        String[] arr = entity.split("\\s+|\n");
//        entity = this.youdaoManager.translate(entity);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr = " + this.youdaoManager.translate(arr[i]));
        }

    }
    @Test
    public void getRelationTest(){
       String relation= manager.getRelation("Tim Cook is the CEO of Apple, he replaced Steve Jobs, who died in 2011.");
        //  String relation= manager.getRelation("小明住在中原工学院" );
        System.out.println(relation);
    }
    @Test
    public void getall(){
        String text="Tim Cook is the CEO of Apple, he replaced Steve Jobs, who died in 2011";
        String str=this.manager.getRelation(text);
        String str2=this.manager.getEntity(text);
        System.out.println("分析的文本为："+'\n'+text);
        System.out.println("实体为："+'\n'+str2);
        System.out.println("实体关系为："+'\n'+str);

    }
}

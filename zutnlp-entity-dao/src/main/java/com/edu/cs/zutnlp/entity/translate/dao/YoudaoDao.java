package com.edu.cs.zutnlp.entity.translate.dao;

import com.edu.cs.zutnlp.entity.base.dao.GenericDao;
import com.edu.cs.zutnlp.entity.translate.domain.Youdao;
import org.springframework.stereotype.Repository;

/**
 * @ClassName YoudaoDao
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/7/22 16:41
 * @Version 1.0
 */
@Repository("youdaoDao")
public interface YoudaoDao extends GenericDao<Youdao, Long> {
}

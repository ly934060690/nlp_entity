package com.edu.cs.zutnlp.entity.stanford.dao;

import com.edu.cs.zutnlp.entity.base.dao.GenericDao;
import com.edu.cs.zutnlp.entity.stanford.domain.Stanford;
import org.springframework.stereotype.Repository;

@Repository("sanfordDao")
public interface StanfordDao extends GenericDao<Stanford, Long> {
}

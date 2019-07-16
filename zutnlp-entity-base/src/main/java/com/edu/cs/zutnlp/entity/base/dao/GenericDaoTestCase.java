package com.edu.cs.zutnlp.entity.base.dao;

import com.edu.cs.zutnlp.entity.base.BaseAbstractTestCase;
import com.edu.cs.zutnlp.entity.base.domain.BaseEntity;

import org.junit.Before;
import org.springframework.test.context.ContextConfiguration;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author liuxiaoming
 *
 * @param <PK>
 * @param <T>
 * @param <D>
 */
@ContextConfiguration(locations = { "classpath:/applicationContext-resources.xml",
		"classpath:/applicationContext-dao.xml" })
public class GenericDaoTestCase<PK extends Serializable, T extends BaseEntity, D extends GenericDao<T, PK>>
		extends BaseAbstractTestCase {

	protected D dao;

	protected T entity;

	protected PK id;

	protected List<T> list;

	@Before
	public void setUp() throws Exception {

	}
}

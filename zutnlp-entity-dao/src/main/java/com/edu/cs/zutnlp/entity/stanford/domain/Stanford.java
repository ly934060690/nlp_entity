package com.edu.cs.zutnlp.entity.stanford.domain;

import com.edu.cs.zutnlp.entity.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @ClassName Stanford
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/7/16 16:42
 * @Version 1.0
 */
@Entity
@Table(name = "T_STANFORD")
public class Stanford extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 8813967170357455974L;

    @Column(name = "TEXT")
    String text;
    @Column(name = "ENTITY")
    String entity;
    @Column(name = "RELATION")
    String relation;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}

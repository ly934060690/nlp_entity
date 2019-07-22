package com.edu.cs.zutnlp.entity.translate.domain;

import com.edu.cs.zutnlp.entity.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @ClassName Youdao
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/7/22 16:41
 * @Version 1.0
 */
@Entity
@Table(name = "T_YOUDAO")
public class Youdao extends BaseEntity {

    @Column(name = "TEXT")
    String text;
    @Column(name = "TRANSLATE")
    String translate;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }
}

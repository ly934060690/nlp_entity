package com.edu.cs.zutnlp.entity.stanford.service;

import com.edu.cs.zutnlp.entity.base.service.GenericManager;
import com.edu.cs.zutnlp.entity.stanford.domain.Stanford;
import edu.stanford.nlp.pipeline.Annotation;

public interface StanfordManager extends GenericManager<Stanford, Long> {
    /**
     * 1. Entity
     * 2. EntityRalation
     */

    /**
     * getEntity
     * 1. Enlish
     * 2. Chinese
     * @param text
     * @return
     */
    String getEntityEN(String text);
    String getEntityCN(String text);

    /**
     * getEntityRelation
     * 1. Enlish
     * 2. Chinese
     * @param text
     * @return
     */
    String getRelationEN(String text);
    String getRelationCN(String text);

    /**
     * getAnnotation
     * @param text
     * @return
     */
    Annotation getAnnotation(String text);
}

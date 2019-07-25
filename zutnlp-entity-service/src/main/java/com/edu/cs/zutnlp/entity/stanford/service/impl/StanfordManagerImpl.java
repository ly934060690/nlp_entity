package com.edu.cs.zutnlp.entity.stanford.service.impl;

import com.edu.cs.zutnlp.entity.base.service.impl.GenericManagerImpl;
import com.edu.cs.zutnlp.entity.stanford.dao.StanfordDao;
import com.edu.cs.zutnlp.entity.stanford.domain.Stanford;
import com.edu.cs.zutnlp.entity.stanford.service.StanfordManager;
import com.edu.cs.zutnlp.entity.translate.service.YoudaoManager;
import edu.stanford.nlp.ie.util.RelationTriple;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.naturalli.NaturalLogicAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreEntityMention;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Properties;

/**
 * @ClassName StanfordManagerImpl
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/7/17 9:22
 * @Version 1.0
 */
@Component
@Transactional
public class StanfordManagerImpl extends GenericManagerImpl<Stanford, Long> implements StanfordManager {

    StanfordDao stanfordDao;

    @Autowired
    public void setStanfordDao(StanfordDao stanfordDao) {
        this.stanfordDao = stanfordDao;
        this.dao = this.stanfordDao;
    }

    YoudaoManager youdaoManager;

    @Autowired
    public void setYoudaoManager(YoudaoManager youdaoManager) {
        this.youdaoManager = youdaoManager;
    }
    /**
     * 1. Entity
     * 2. EntityRalation
     *
     * @param text
     */

    /**
     * getEntity
     * 1. Enlish
     * 2. Chinese
     * @param text
     * @return
     */
    @Override
    public String getEntityEN(String text) {
        // set up pipeline properties
        String result = "";
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        CoreDocument doc = new CoreDocument(text);
        pipeline.annotate(doc);
        for (CoreEntityMention em : doc.entityMentions()) {
            result += em.text() + "\t" + em.entityType() + "\n";
        }
        return result;
    }

    @Override
    public String getEntityCN(String text) {
        // set up pipeline properties
        String result = "";
        StanfordCoreNLP pipeline = new StanfordCoreNLP("StanfordCoreNLP-chinese.properties");
        CoreDocument doc = new CoreDocument(text);
        pipeline.annotate(doc);
        for (CoreEntityMention em : doc.entityMentions()) {
            result += em.text() + "\t" + em.entityType()+"\n";
        }
        return result;
    }

    /**
     * getEntityRelation
     * 1. Enlish
     * 2. Chinese
     *
     * @param text
     * @return
     */
    @Override
    public String getRelationEN(String text) {
        Annotation document = this.getAnnotation(text);
        String result = "";
        for (CoreMap sentence : document.get(CoreAnnotations.SentencesAnnotation.class)) {
            Collection<RelationTriple> triples=sentence.get(NaturalLogicAnnotations.RelationTriplesAnnotation.class);
            for (RelationTriple triple : triples) {
                result += triple.subjectLemmaGloss() + "\t" + triple.relationGloss() + "\t" + triple.objectLemmaGloss() + "\n";
            }
        }
        return result;
    }

    @Override
    public String getRelationCN(String text) {
        String translateText = this.youdaoManager.translate(text);
        Annotation document = this.getAnnotation(translateText);
        String result = "";
        for (CoreMap sentence : document.get(CoreAnnotations.SentencesAnnotation.class)) {
            Collection<RelationTriple> triples=sentence.get(NaturalLogicAnnotations.RelationTriplesAnnotation.class);
            for (RelationTriple triple : triples) {
                result += this.youdaoManager.translate(triple.subjectLemmaGloss()) + "\t"
                        + this.youdaoManager.translate(triple.relationGloss()) + "\t"
                        +  this.youdaoManager.translate(triple.objectLemmaGloss()) + "\n";
            }
        }
        return result;
    }

    /**
     * getAnnotation
     *
     * @param text
     * @return
     */
    @Override
    public Annotation getAnnotation(String text) {
        Properties properties = new Properties();
        properties.setProperty("annotators","tokenize,ssplit,pos,lemma,ner,depparse,natlog,openie,parse,dcoref,relation,entitymentions");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(properties);
//        StanfordCoreNLP pipeline = new StanfordCoreNLP("StanfordCoreNLP-chinese.properties");
        Annotation document = new Annotation(text);
        pipeline.annotate(document);
        return document;
    }

}

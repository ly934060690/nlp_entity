package com.edu.cs.zutnlp.entity.stanford.service.impl;

import com.edu.cs.zutnlp.entity.base.service.impl.GenericManagerImpl;
import com.edu.cs.zutnlp.entity.stanford.dao.StanfordDao;
import com.edu.cs.zutnlp.entity.stanford.domain.Stanford;
import com.edu.cs.zutnlp.entity.stanford.service.StanfordManager;
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

    @Override
    public String getEntity( String pra) {
        // set up pipeline properties
        String resultGet="";
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner");

        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        CoreDocument doc = new CoreDocument(pra);

        pipeline.annotate(doc);

        for (CoreEntityMention em : doc.entityMentions()) {
            resultGet= resultGet+em.text() + "\t" + em.entityType()+"\n";

        }
     //   System.out.println(resultGet);

        //  String tokensAndNERTags = doc.tokens().stream().map(token -> "(" + token.word() + "," + token.ner() + ")").collect(
        //   Collectors.joining(" "));
        //return tokensAndNERTags;
        return resultGet;
    }

    @Override

    public String getRelation(String text){
        //  String props="StanfordCoreNLP-chinese.properties";
       // System.out.println("&&&&&&&&&"+text+"&&&&&&&&&&&");
        Properties properties=new Properties();
        properties.setProperty("annotators","tokenize,ssplit,pos,lemma,ner,depparse,natlog,openie,parse,dcoref,relation,entitymentions");
        //tokenize,ssplit,pos,lemma,ner,depparse,natlog,openie,parse,dcoref,
        String result="";
        StanfordCoreNLP pipeline = new StanfordCoreNLP(properties);
        Annotation document = new Annotation(text);
        //   StanfordCoreNLP pipeline = new StanfordCoreNLP("StanfordCoreNLP-chinese.properties");
        pipeline.annotate(document);
        for (CoreMap sentence :document.get(CoreAnnotations.SentencesAnnotation.class)) {
            Collection<RelationTriple> triples=sentence.get(NaturalLogicAnnotations.RelationTriplesAnnotation.class);
            for (RelationTriple triple : triples) {
                result = result +
                        triple.subjectLemmaGloss() + "\t" +
                        triple.relationGloss() + "\t" +
                        triple.objectLemmaGloss() + "\n";
            }
        }
        return result;
    }
}

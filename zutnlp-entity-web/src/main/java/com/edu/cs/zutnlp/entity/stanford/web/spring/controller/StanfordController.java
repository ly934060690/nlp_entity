package com.edu.cs.zutnlp.entity.stanford.web.spring.controller;

import com.edu.cs.zutnlp.entity.base.web.spring.controller.GenericController;
import com.edu.cs.zutnlp.entity.stanford.domain.Stanford;
import com.edu.cs.zutnlp.entity.stanford.service.StanfordManager;
import com.edu.cs.zutnlp.entity.translate.service.YoudaoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @ClassName StanfordController
 * @Description TODO
 * @Author 研哥哥
 * @Date 2019/7/17 10:54
 * @Version 1.0
 */
@Controller
@RequestMapping("/stanford")
public class StanfordController extends GenericController<Stanford, Long, StanfordManager> {

    private Stanford stanford=new Stanford();

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

    @RequestMapping(method = RequestMethod.GET, value = "/main")
    public String index() {
        String result = "index";
        return result;
    }

    @ResponseBody
    @GetMapping(value = "ly", produces = "application/json;charset=utf-8")
    public String ly() {
        return "Hello, Ly";
    }

    @ResponseBody
    @GetMapping(value = "getentity/{text}",produces = "application/json;charset=utf-8")
    public String getEntity(@PathVariable("text") String text) {
        String entity = null;
        if (this.youdaoManager.isEnlish(text)) {
            entity = this.manager.getEntityEN(text);
        } else {
            entity = this.manager.getEntityCN(text);
        }
        return entity;
    }
    @ResponseBody
    @GetMapping(value = "getrelation/{text}",produces = "application/json;charset=utf-8")
    public String getRelationWeb(@PathVariable("text") String text){
        String relation = null;
        if (this.youdaoManager.isEnlish(text)) {
            relation = this.manager.getRelationEN(text);
        } else {
            relation = this.manager.getRelationCN(text);
        }
        return relation;
    }


    @ResponseBody
    @PostMapping(value = "request", produces = "application/json;charset=utf-8")
    public String getText(@RequestBody Map<String, Object> map) {
        String text = (String) map.get("text");
        String entity = null;
        String relation = null;
        if (this.youdaoManager.isEnlish(text)) {
            entity = this.manager.getEntityEN(text);
            relation = this.manager.getRelationEN(text);
        } else {
            entity = this.manager.getEntityCN(text);
            relation = this.manager.getRelationCN(text);
        }
        stanford.setText(text);
        stanford.setEntity(entity);
        stanford.setRelation(relation);
        this.manager.save(stanford);
        System.out.print("text : " + text + "\n=============================================================OK!\n");
        return text;
    }

    @ResponseBody
    @GetMapping(value = "response", produces = "application/json;charset=utf-8")
    public Stanford response(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return stanford;
    }

}

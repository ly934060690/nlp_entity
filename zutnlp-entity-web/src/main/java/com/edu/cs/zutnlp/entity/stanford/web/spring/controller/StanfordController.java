package com.edu.cs.zutnlp.entity.stanford.web.spring.controller;

import com.edu.cs.zutnlp.entity.base.web.spring.controller.GenericController;
import com.edu.cs.zutnlp.entity.stanford.domain.Stanford;
import com.edu.cs.zutnlp.entity.stanford.service.StanfordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    StanfordManager stanfordManager;

    @Autowired
    public void setStanfordManager(StanfordManager stanfordManager) {
        this.stanfordManager = stanfordManager;
        this.manager = this.stanfordManager;
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

}

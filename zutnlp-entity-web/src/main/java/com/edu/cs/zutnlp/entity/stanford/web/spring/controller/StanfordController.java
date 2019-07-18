package com.edu.cs.zutnlp.entity.stanford.web.spring.controller;

import com.edu.cs.zutnlp.entity.base.web.spring.controller.GenericController;
import com.edu.cs.zutnlp.entity.stanford.domain.Stanford;
import com.edu.cs.zutnlp.entity.stanford.service.StanfordManager;
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

    @ResponseBody
    @RequestMapping(value="request" , produces = "application/json;charset=utf-8")
    public String getMessage(@RequestBody Map<String, Object> map){
        String text = (String)map.get("text");
        System.out.println("text");
        return "text";
    }

    @ResponseBody
    @RequestMapping(value = "response", produces = "application/json;charset=utf-8")
    public Stanford response(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Stanford stanford = new Stanford();
        stanford.setText("hello!");
        return stanford;
    }
}

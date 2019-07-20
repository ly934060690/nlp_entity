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
    private Stanford stanford=new Stanford();
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

//    @ResponseBody
//    @RequestMapping(value = "response", produces = "application/json;charset=utf-8")
//    public Stanford response(HttpServletResponse response) {
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        Stanford stanford = new Stanford();
//        stanford.setText("hello!");
//        return stanford;
//    }

    @ResponseBody
    @GetMapping(value = "text/{text}",produces = "application/json;charset=utf-8")
    public String getRelationWeb(@PathVariable("text") String text){

        String str=this.manager.getRelation(text)+"/n"+this.manager.getEntity(text);
        return str;
    }

    @ResponseBody
    @PostMapping(value = "request", produces = "application/json;charset=utf-8")
    public String getText(@RequestBody Map<String, Object> map) {
        String text = (String) map.get("text");
        String  result = this.manager.getRelation(text);
        String resultEntity=this.manager.getEntity(text);
        stanford.setText(text);
        stanford.setRelation(result);
        stanford.setEntity(resultEntity);
        this.manager.save(stanford);
        System.out.print("text : ");
        System.out.println(text);
        return text;
    }

    @ResponseBody
    @GetMapping(value = "response", produces = "application/json;charset=utf-8")
    public Stanford response(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return stanford;
    }




}

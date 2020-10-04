package com.yhp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Administrator
 * springmvc
 * 面向对象面向君  不负代码不负卿
 */
@Controller
public class MyController2 {
    @RequestMapping(value = "/test")
    public String test1(@RequestParam(name = "username") String name, @RequestParam(name = "age",defaultValue = "18") int age, Date birthday,
                        HttpSession session, ModelMap map){
        System.out.println("test1被执行");
        System.out.println("username="+name+",age="+age+",birthday="+birthday);
        session.setAttribute("usession",name);
        map.addAttribute("sessionmap",age);
        //System.out.println(5/0);
        return "success";//return  结果页面的名称 =>  /success.jsp
    }
}

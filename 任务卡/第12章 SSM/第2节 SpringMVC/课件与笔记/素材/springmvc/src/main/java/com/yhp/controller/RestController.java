package com.yhp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Administrator
 * springmvc
 * 面向对象面向君  不负代码不负卿
 */
@Controller
public class RestController {
    @RequestMapping(value = "/testrest/{myname}/{uage}",method = RequestMethod.GET)
    public String get(@PathVariable("myname") String name,@PathVariable("uage") int age){
        System.out.println("get请求"+"name="+name+",age="+age);
        return "getsuccess";
    }
    @RequestMapping(value = "/testrest/{myname}/{uage}",method = RequestMethod.POST)
    public String post(@PathVariable("myname") String name,@PathVariable("uage") int age){
        System.out.println("post"+"name="+name+",age="+age);
        return "postsuccess";
    }
    @RequestMapping(value = "/testrest/{myname}/{uage}",method = RequestMethod.PUT)
    public String put(@PathVariable("myname") String name,@PathVariable("uage") int age){
        System.out.println("put请求"+"name="+name+",age="+age);
        return "putsuccess";
    }
    @RequestMapping(value = "/testrest/{myname}/{uage}",method = RequestMethod.DELETE)
    public String del(@PathVariable("myname") String name,@PathVariable("uage") int age){
        System.out.println("del请求"+"name="+name+",age="+age);
        return "delsuccess";
    }
}

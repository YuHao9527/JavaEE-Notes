package com.yhp.controller;

import com.yhp.bean.Users;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Administrator
 * springmvc
 * 面向对象面向君  不负代码不负卿
 */
@Controller
@SessionAttributes("sessionmap")
public class MyController {
   /* @RequestMapping( method = RequestMethod.POST,value = "/test")
    public String test1(){
        System.out.println("test1被执行");
        return "success";//return  结果页面的名称 =>  /success.jsp
    }*/
 /*  @RequestMapping(value = "/test")
   public String test1(HttpServletRequest request){
       System.out.println("test1被执行");
       String username = request.getParameter("username");
       String age = request.getParameter("age");
       return "success";//return  结果页面的名称 =>  /success.jsp
   }*/

   @RequestMapping("/out")  //基于HttpSession清除数据
   public String out(HttpSession session){
      session.invalidate();
      return "redirect:/loginout.jsp";//注意:重定向时会忽略视图解析器的配置
   }




   /* @RequestMapping("/out2")  //基于SessionAttributes注解数据
    public String out2(SessionStatus status){
        status.setComplete();
        return "loginout";
    }*/
    //弹窗方式响应结果
    @RequestMapping("/out2")  //基于SessionAttributes注解数据
    public void out2(SessionStatus status, HttpServletResponse response){
        status.setComplete();
        //响应流
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.print("<script>alert('退出成功');location.href='loginout.jsp'</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 /*  @RequestMapping(value = "/test")
   public String test1(Users users){
       System.out.println("test1被执行：users");
       System.out.println("username="+users.getUsername()+",age="+users.getAge());
       return "success";//return  结果页面的名称 =>  /success.jsp
   }*/


 /*@RequestMapping("/test2")
    public String test2(@DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday, HttpServletRequest request, ModelMap map, Model model) {
     System.out.println("test2==>date:"+birthday);
     request.setAttribute("birth",birthday);//request存值转发时显示，重定向时丢失
     map.addAttribute("modelmapkey",birthday);
     model.addAttribute("modelkey",birthday);
     return  "success";
    }*/

    @RequestMapping("/test2")
    public ModelAndView test2(@DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday,String uname,
                              @CookieValue("JSESSIONID") String sessionid,
                              @RequestHeader("Accept-Language")String language) {
        System.out.println("test2==>date:"+birthday);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("mvkey",birthday);
        modelAndView.addObject("uname",uname);
        System.out.println("uname="+uname+",cookie="+sessionid+",language="+language);
        return  modelAndView;
    }

}

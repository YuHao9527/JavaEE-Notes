package com.yhp.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Administrator
 * springmvc
 * 面向对象面向君  不负代码不负卿
 */
@ControllerAdvice
public class ExceptionController {
    //全局处理异常
   /* @ExceptionHandler(Exception.class)
    public String error(){
        System.out.println("error----》");
        return "error";
    }*/
}

package com.xzk.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * Administrator
 * mybatis
 * 面向对象面向君  不负代码不负卿
 */
//多方
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    //@Value
public class Student implements Serializable {

    private int studentId; //属性名=列名
    private String studentNo;
    private String stuName;
    //private int stuAge;
    private int age;
    private Grade grade;

}

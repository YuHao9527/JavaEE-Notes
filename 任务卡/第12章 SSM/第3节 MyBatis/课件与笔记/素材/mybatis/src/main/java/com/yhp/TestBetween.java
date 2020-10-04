package com.yhp;

import com.yhp.bean.Student;
import com.yhp.dao.StudentDao2;
import com.yhp.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.*;

/**
 * Administrator
 * mybatis
 * 面向对象面向君  不负代码不负卿
 */
public class TestBetween {
    public static void main(String[] args) {
        SqlSession session = SqlSessionUtil.getSession();
        StudentDao2 studentDao2 = session.getMapper(StudentDao2.class);
        Map map=new HashMap();
        map.put("begin",1);
        map.put("end",5);
        List<Student> students = studentDao2.findf(map);

        for (Student student : students) {
            System.out.println(student);
        }
        SqlSessionUtil.closeSession();
    }
}

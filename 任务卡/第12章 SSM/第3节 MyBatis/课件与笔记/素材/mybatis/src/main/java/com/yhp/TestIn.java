package com.yhp;

import com.yhp.bean.Student;
import com.yhp.dao.StudentDao2;
import com.yhp.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Administrator
 * mybatis
 * 面向对象面向君  不负代码不负卿
 */
public class TestIn {
    public static void main(String[] args) {
        SqlSession session = SqlSessionUtil.getSession();
        StudentDao2 studentDao2 = session.getMapper(StudentDao2.class);
       /* List list=new ArrayList();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        List<Student> students = studentDao2.finda(list);*/
      /* int[] ids=new int[]{1,3,5,7};
        List<Student> students = studentDao2.findb(ids);*/
        Map map=new HashMap();
        List list=new ArrayList();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        map.put("ids",list);
        List<Student> students = studentDao2.findc(map);
        for (Student student : students) {
            System.out.println(student);
        }
        SqlSessionUtil.closeSession();
    }
}

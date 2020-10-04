package com.yhp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yhp.bean.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Administrator
 * mybatis
 * 面向对象面向君  不负代码不负卿
 */
public class Test1_2 {
    public static void main(String[] args) {
        try {
            //1.加载配置文件
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            //2.得到sqlSessionFactoryBuilder
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = builder.build(reader,"a2");
            //3.得到SqlSession
            SqlSession session = build.openSession();
            //4.操作sql
            //4.1 指定分页的参数
            PageHelper.startPage(5,3);
            //4.2 调取dao层方法
            List<Student> list = session.selectList("com.yhp.dao.StudentDao.getall");//方法参数是被调取的sql的完整路径=namespace+id
            //4.3 创建分页工具类对象
            PageInfo<Student> info = new PageInfo<Student>(list);
            //5.从分页数据中获得数据
            for (Student student : info.getList()) {
                System.out.println(student);
            }
            System.out.println("当前页条数："+info.getSize());
            System.out.println("总条数:"+info.getTotal());
            System.out.println("总页数:"+info.getPages());
            System.out.println("上一页:"+info.getPrePage()); //如果没有上一页，则返回0
            System.out.println("下一页:"+info.getNextPage());
            System.out.println("当前页:"+info.getPageNum());
            System.out.println("显示条数:"+info.getPageSize());
            //6.关闭资源
            session.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.yhp.dao.impl;

import com.yhp.bean.Books;
import com.yhp.dao.BooksDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Administrator
 * ssm
 * 面向对象面向君  不负代码不负卿
 */
@Repository
public class BookDaoImpl  implements BooksDao {


    @Resource  //该对象来源于配置文件
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public List<Books> getall() {
        return sqlSessionTemplate.selectList("com.yhp.dao.BooksDao.getall");//namespace+id
    }
}

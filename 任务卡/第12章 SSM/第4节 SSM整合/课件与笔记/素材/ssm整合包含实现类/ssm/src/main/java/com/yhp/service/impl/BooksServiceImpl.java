package com.yhp.service.impl;

import com.yhp.bean.Books;
import com.yhp.dao.BooksDao;
import com.yhp.service.BooksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Administrator
 * ssm
 * 面向对象面向君  不负代码不负卿
 */
@Service
public class BooksServiceImpl implements BooksService {

    @Resource
    private BooksDao dao;

    @Override
    public List<Books> getall() {
        return dao.getall();
    }
}

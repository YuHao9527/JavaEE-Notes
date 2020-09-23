package com.xzk.service.impl;

import com.xzk.bean.Users;
import com.xzk.dao.UsersDao;
import com.xzk.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Administrator
 * springDemo1
 * 面向对象面向君  不负代码不负卿
 */
@Service("uservice")
public class UsersServiceImpl implements UsersService {
        //DI-依赖注入
 //   @Autowired// 默认使用byType
  //  @Qualifier("udao2")
    @Resource(name = "udao")
    private UsersDao usersDao;

    public int insertUsers1(Users users) {
        System.out.println("usersServiceImpl");
        usersDao.insertUsers1(users);
        return 0;
    }
}

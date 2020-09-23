package com.xzk.service.impl;

import com.xzk.bean.Users;
import com.xzk.dao.UsersDao;
import com.xzk.dao.impl.UsersDaoImpl;
import com.xzk.dao.impl.UsersDaoImpl2;
import com.xzk.service.UsersService;

/**
 * Administrator
 * springDemo1
 * 面向对象面向君  不负代码不负卿
 */
public class UsersServiceImpl implements UsersService {

    private UsersDao usersDao;

    public void setUsersDao(UsersDao usersDao) {
        //当容器给属性赋值时，默认调取set方法
        System.out.println("setUsersDao");
        this.usersDao = usersDao;
    }

    public UsersServiceImpl() {
    }

    public UsersServiceImpl(UsersDao usersDao) {
        System.out.println("UsersServiceImpl(UsersDao usersDao)");
        this.usersDao = usersDao;
    }

    public int insertUsers1(Users users) {
        System.out.println("usersServiceImpl");
        usersDao.insertUsers1(users);
        return 0;
    }
}

package com.xzk.dao.impl;

import com.xzk.bean.Users;
import com.xzk.dao.UsersDao;
import org.springframework.stereotype.Repository;

/**
 * Administrator
 * springDemo1
 * 面向对象面向君  不负代码不负卿
 */
@Repository("udao")
public class UsersDaoImpl implements UsersDao {
    public int insertUsers1(Users users) {
        System.out.println("usersDaoImpl");
        return 0;
    }
}

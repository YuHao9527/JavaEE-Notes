package xzk.dao.impl;

import org.springframework.stereotype.Repository;
import xzk.dao.UsersDao;

/**
 * Administrator
 * springaop2
 * 面向对象面向君  不负代码不负卿
 */
@Repository("udao")
public class UsersDaoImpl implements UsersDao {
    public void test1() {
        System.out.println("usersDao--TEST1");
    }
}

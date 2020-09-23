package xzk.service.impl;

import org.springframework.stereotype.Service;
import xzk.dao.UsersDao;
import xzk.service.UsersService;

import javax.annotation.Resource;

/**
 * Administrator
 * springaop2
 * 面向对象面向君  不负代码不负卿
 */
@Service("uservice")
public class UsersServiceImpl implements UsersService {

    @Resource(name="udao")
    private UsersDao usersDao;

    public void test2() {
        System.out.println("userservice-test2");
    }

    public void test1() {
        System.out.println("usersService---TEST1");
        //System.out.println(9/0);
        usersDao.test1();
    }
}

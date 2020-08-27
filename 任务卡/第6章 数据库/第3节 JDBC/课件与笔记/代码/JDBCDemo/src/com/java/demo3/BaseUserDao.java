package com.java.demo3;

import java.util.List;

public interface BaseUserDao {
    /**
     *  用于向数据库xzk_user表格中插入一行数据
     * @param username  是要插入的账号
     * @param password  是要插入的密码
     * @return  结果, 增加成功返回true
     */
    boolean insert(String username,String password);

    /**
     *  用于从数据库xzk_user表格中查询一行数据
     * @param username  是要查询的条件1:账号
     * @param password  是要查询的条件2:密码
     * @return  结果, 查询成功返回true
     */
    boolean findByPassword(String username,String password);

    /**
     *  用于从数据库xzk_user表格中查询一行数据
     * @param username  是要查询的条件1:账号
     * @param password  是要查询的条件2:密码
     * @return  结果, 查询成功返回true
     */
    boolean findByPassword2(String username,String password);

    /**
     * 查询所有用户信息
     * @return 用户列表
     */
    List<User> findAll();
}

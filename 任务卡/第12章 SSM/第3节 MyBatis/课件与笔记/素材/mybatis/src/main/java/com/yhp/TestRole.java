package com.yhp;

import com.yhp.bean.Menu;
import com.yhp.bean.Role;
import com.yhp.bean.Student;
import com.yhp.dao.GradeDao;
import com.yhp.dao.RoleDao;
import com.yhp.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Administrator
 * mybatis
 * 面向对象面向君  不负代码不负卿
 */
public class TestRole {
    public static void main(String[] args) {
        SqlSession session = SqlSessionUtil.getSession();
        RoleDao mapper = session.getMapper(RoleDao.class);
      /*  Role role = mapper.findByRoleId(1);
        System.out.println(role);
        List<Menu> menuList = role.getMenuList();
        for (Menu menu : menuList) {
            System.out.println(menu);
        }*/
        Menu menu = mapper.findByMenuId(28);
        System.out.println(menu);
        List<Role> roleList = menu.getRoleList();
        for (Role role : roleList) {
            System.out.println(role);
        }
        SqlSessionUtil.closeSession();
    }
}

package test;

import bean.Husband;
import bean.Menu;
import bean.Role;
import bean.Wife;
import dao.impl.RoleDaoImpl;
import dao.impl.WifeDaoImpl;

import java.util.List;

public class Demo4 {
    public static void main(String[] args) {
        RoleDaoImpl roleDao = new RoleDaoImpl();
        /*Menu menu = roleDao.findByMenuId(2);
        System.out.println(menu.getMenuName());
        List<Role> roleList = menu.getRoleList();
        for (Role role : roleList) {
            System.out.println(role.getRoleName());
        }*/
        Role role = roleDao.findByRoleId(2);
        System.out.println(role.getRoleName());
        List<Menu> menuList = role.getMenuList();
        for (Menu menu : menuList) {
            System.out.println(menu.getMenuName());
        }

    }
}

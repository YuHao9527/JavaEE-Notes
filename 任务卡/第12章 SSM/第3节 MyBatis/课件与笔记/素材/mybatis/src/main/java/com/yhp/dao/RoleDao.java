package com.yhp.dao;

import com.yhp.bean.Menu;
import com.yhp.bean.Role;

/**
 * Administrator
 * mybatis
 * 面向对象面向君  不负代码不负卿
 */
public interface RoleDao {
    //1.查询某个角色以及对应的菜单
    public Role findByRoleId(int roleid);
    //2.查询某个菜单以及对应的角色
    public Menu findByMenuId(int menuid);
}

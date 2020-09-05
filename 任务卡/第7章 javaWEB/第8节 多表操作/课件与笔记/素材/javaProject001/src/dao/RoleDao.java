package dao;

import bean.Menu;
import bean.Role;

public interface RoleDao {
    //查询某个菜单信息（包含角色）
    public Menu findByMenuId(int mid);
    //查询某个角色信息(要求包含菜单)
    public Role findByRoleId(int roleid);
}

package dao.impl;

import bean.Menu;
import bean.Role;
import dao.RoleDao;
import util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoleDaoImpl extends DruidUtil implements RoleDao {
    @Override
    public Menu findByMenuId(int mid) {
        Menu menu = new Menu();
        ArrayList<Role> roles = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select * from menu m ,role r, middle where m.menuid=middle.mid and r.roleid=middle.rid and m.menuid=?");
            preparedStatement.setInt(1,mid);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                //1.先各自存数据
                menu.setMenuName(resultSet.getString("menuname"));
                Role role = new Role();
                role.setRoleName(resultSet.getString("rolename"));
                //2.建立二者关系
                roles.add(role);
            }
            menu.setRoleList(roles);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(connection,preparedStatement,resultSet);
        }
        return menu;
    }

    @Override
    public Role findByRoleId(int roleid) {

        Role role = new Role();
        ArrayList<Menu> menuArrayList = new ArrayList<Menu>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("select * from menu m ,role r, middle where m.menuid=middle.mid and r.roleid=middle.rid and r.roleid=?");
            preparedStatement.setInt(1,roleid);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                //1.先各自存数据
                Menu menu = new Menu();
                menu.setMenuName(resultSet.getString("menuname"));
                role.setRoleName(resultSet.getString("rolename"));
                //2.建立二者关系
                menuArrayList.add(menu);
            }
            role.setMenuList(menuArrayList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(connection,preparedStatement,resultSet);
        }
        return role;
    }
}

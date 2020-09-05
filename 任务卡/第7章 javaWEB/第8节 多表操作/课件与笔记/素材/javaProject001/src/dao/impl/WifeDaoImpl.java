package dao.impl;

import bean.Husband;
import bean.Wife;
import dao.WifeDao;
import util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WifeDaoImpl extends DruidUtil implements WifeDao {
    @Override
    public Wife findByWifeId(int wid) {
        Wife wife = new Wife();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

            connection = getConnection();
            preparedStatement = connection.prepareStatement("select * from wife w,husband h where w.wifeid=h.wid and w.wifeid=?");
            preparedStatement.setInt(1,wid);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                //1.存各自的信息
                wife.setWifeName(resultSet.getString("wifename"));
                Husband husband = new Husband();
                husband.setHusName(resultSet.getString("husname"));
                //2.建立两者关系（将丈夫封装到妻子的对象中）
                wife.setHusband(husband);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(connection,preparedStatement,resultSet);
        }
        return wife;
    }

    @Override
    public Husband findByHid(int hid) {
        Husband husband = new Husband();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

            connection = getConnection();
            preparedStatement = connection.prepareStatement("select * from wife w,husband h where w.wifeid=h.wid and h.husid=?");
            preparedStatement.setInt(1,hid);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                //1.存各自的信息
                Wife wife = new Wife();
                wife.setWifeName(resultSet.getString("wifename"));

                husband.setHusName(resultSet.getString("husname"));
                //2.建立两者关系（将妻子封装到丈夫的对象中）
               husband.setWife(wife);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(connection,preparedStatement,resultSet);
        }
        return husband;
    }
}

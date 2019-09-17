package com.xiaodeng.my_MyBatis_v1;

import com.xiaodeng.pojo.Test;

import java.sql.*;

import static java.sql.Types.INTEGER;

/**
 * @author dengfuhai
 * @description
 * @date 2019/9/16 0016
 */
public class FHSimpleExecutor implements FHExecutor{

    @Override
    public <T> T query(String statement, String parameter) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Test test=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gp?useUnicode=true&amp;characterEncoding=UTF8", "root", "599571116");
            preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setInt(1, Integer.parseInt(parameter));

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                test=new Test();
                test.setId(rs.getInt(1));
                test.setNums(rs.getInt(2));
                test.setName(rs.getString(3));

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return (T)test;
    }
}

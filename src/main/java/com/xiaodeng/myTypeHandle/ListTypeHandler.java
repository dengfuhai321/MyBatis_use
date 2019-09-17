package com.xiaodeng.myTypeHandle;

import com.sun.deploy.util.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

import static java.sql.JDBCType.*;

/**
 * @author dengfuhai
 * @description
 * @date 2019/9/14 0014
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes({List.class})
public class ListTypeHandler implements TypeHandler<List<String>> {

    @Override
    //这是往数据库中写之前的准备
    public void setParameter(PreparedStatement preparedStatement, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
        //把list<String>中的字符串以，号分割形成字符串。
        String hobbys = StringUtils.join(parameter, ",");//拼接字符串
        try {
            preparedStatement.setString(i, hobbys);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<String> getResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        String hobbys = callableStatement.getString(columnIndex);
        return Arrays.asList(hobbys.split(","));//将数组转化成list

    }

    @Override
    public List<String> getResult(ResultSet rs, String columnName) throws SQLException {
        return Arrays.asList(rs.getString(columnName).split(","));
    }

    @Override
    public List<String> getResult(ResultSet rs, int columnIndex) throws SQLException {
        return Arrays.asList(rs.getString(columnIndex).split(","));
    }


}

package com.xiaodeng.myTypeHandle;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.util.Date;

/**
 * @author dengfuhai
 * @description
 * @date 2019/9/14 0014
 */
public class DateToTime extends BaseTypeHandler<Date> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setTime(i, new Time(parameter.getTime()));
    }

    @Override
    public Date getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        java.sql.Time sqlTime = rs.getTime(columnName);
        if (sqlTime != null) {
            return new Date(sqlTime.getTime());
        }
        return null;
    }

    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        java.sql.Time sqlTime = rs.getTime(columnIndex);
        if (sqlTime != null) {
            return new Date(sqlTime.getTime());
        }
        return null;
    }

    @Override
    public Date getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        java.sql.Time sqlTime = cs.getTime(columnIndex);
        if (sqlTime != null) {
            return new Date(sqlTime.getTime());
        }
        return null;
    }
}

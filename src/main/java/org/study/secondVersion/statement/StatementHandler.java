package org.study.secondVersion.statement;

import org.study.secondVersion.config.MapperRegister;
import org.study.secondVersion.resultset.ResultSetHandler;

import java.sql.*;

/**
 * @author jim
 * @create 2018-01-31 16:45
 **/
public class StatementHandler<T>  {
    private final ResultSetHandler resultSetHandler;

    public StatementHandler() {
        this.resultSetHandler = new ResultSetHandler();
    }

    public <T> T handler(MapperRegister.MapperData data, Object param) {
        //1、获取连接
        //JDBC
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(String.format(data.getSql(), Long.parseLong(String.valueOf(param))));
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //2、映射封装
        return resultSetHandler.handler(pstmt,data.getClazz());
    }
    public Connection getConnection() throws SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://47.52.240.168:3306/mybatis_test?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "jim";
        String password = "Jim$$123!";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

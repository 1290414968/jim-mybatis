package org.study.newlife.v2.statement;
import org.study.newlife.v2.config.MapperRegistry;
import org.study.newlife.v2.resultset.ResultSetHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Auther: jim
 * @Date: 2018/8/5 17:59
 * @Description:
 */
public class StatementHandler {
    private final ResultSetHandler resultSetHandler;
    public StatementHandler() {
        this.resultSetHandler = new ResultSetHandler();
    }
    public Object handler(MapperRegistry.MapperData data, String param){
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
        try {
            return resultSetHandler.handler(pstmt.getResultSet(),data.getClazz());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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

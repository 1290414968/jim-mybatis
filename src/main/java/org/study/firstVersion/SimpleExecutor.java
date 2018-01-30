package org.study.firstVersion;

import org.study.beans.User;

import java.sql.*;


/**
 * @author jim
 * @create 2018-01-30 18:53
 **/
public class SimpleExecutor implements  Executor {

    public <E> E query(String statement, Object parameter) {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement pstmt;
            pstmt = conn.prepareStatement(String.format(statement,Long.parseLong(String.valueOf(parameter))));
            ResultSet rs = pstmt.executeQuery();
            User user = new User();
            while (rs.next()) {
                user.setId(rs.getLong(1));
                user.setName(rs.getString(2));
                user.setType(rs.getString(3));
            }
            return (E)user;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(conn!=null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

package com.Project.MAWMConfigMover.DBUtil;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
    private static Connection connection = null;
    public static Connection getConnection() throws SQLException {

        if (connection != null) {
            return connection;
        }else {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/mawmclients";
            String user = "root";
            String pwd = "root";

            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url,user,pwd);
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}

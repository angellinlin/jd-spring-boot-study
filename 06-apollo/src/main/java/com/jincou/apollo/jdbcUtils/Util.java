package com.jincou.apollo.jdbcUtils;

/**
 * @author zhouguilong6
 * @date 2025/1/3 16:34
 */
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Util {

    public static Connection getConn() {
        Connection conn = null;
        try {
            // 1.读取配置
            Properties properties = new Properties();
            try {
                InputStream in = Util.class.getClassLoader().getResourceAsStream("application.properties");
                properties.load(in);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("未找到配置文件");
            }

            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            // 2，加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 3.连接数据库
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动类找不到");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }

        return conn;
    }

    public static void close(Connection conn, Statement stm, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stm != null) {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


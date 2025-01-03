package com.jincou.apollo.juejin.jdbcUtils;

/**
 * @author zhouguilong6
 * @date 2025/1/3 17:03
 */
import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PoolUtil {

    public static Connection getPoolConn() {
        Connection conn = null;
        // 读取配置
        try {
            Properties properties = new Properties();
            try {
                InputStream in = PoolUtil.class.getClassLoader().getResourceAsStream("application.properties");
                properties.load(in);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("未找到连接池的配置文件");
            }
            // 创建连接池源
            DruidDataSource dataSource = new DruidDataSource();
            // 设置数据库连接信息
            dataSource.setUrl(properties.getProperty("url"));
            dataSource.setUsername(properties.getProperty("username"));
            dataSource.setPassword(properties.getProperty("password"));
            // 设置连接池信息
            dataSource.setInitialSize((int)Integer.parseInt((String)properties.get("initialSize")));
            dataSource.setMaxActive((int)Integer.parseInt((String)properties.get("maxActive")));
            dataSource.setMinIdle((int)Integer.parseInt((String)properties.get("minIdle")));

            conn =  dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
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


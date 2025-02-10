package com.jincou.apollo.juejin.juejin9;

/**
 * @author zhouguilong6
 * @date 2025/2/8 13:38
 */

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC - 普通插入（循环遍历一条一条插入）
 * @author 单程车票
 */
public class JDBCDemo {
    public static void main(String[] args) {
        String url="jdbc:mysql://11.183.30.49:3306/ledger_fufu?zeroDateTimeBehavior=convertToNull&characterEncoding=utf8&useUnicode=true&autoReconnect=true&failOverReadOnly=false&connectTimeout=2000&socketTimeout=30000&serverTimezone=Asia/Shanghai&allowMultiQueries=true";
        String user="ledger_fufu_push";
        String password="c7Gy9>9EI";
        String driver = "com.mysql.cj.jdbc.Driver";
        // sql语句
        String sql = "INSERT INTO fee(`owner`,`fee1`,`fee2`,`fee3`,`fee4`,`fee5`) VALUES (?,?,?,?,?,?);";
        Connection conn = null;
        PreparedStatement ps = null;
        // 开始时间
        long start = System.currentTimeMillis();
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            ps = conn.prepareStatement(sql);
            // 循环遍历插入数据
            for (int i = 1; i <= 100000; i++) {
                ps.setString(1, "o"+i);
                ps.setBigDecimal(2, new BigDecimal("11111.111"));
                ps.setBigDecimal(3, new BigDecimal("11111.111"));
                ps.setBigDecimal(4, new BigDecimal("11111.111"));
                ps.setBigDecimal(5, new BigDecimal("11111.111"));
                ps.setBigDecimal(6, new BigDecimal("11111.111"));
                ps.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 结束时间
        long end = System.currentTimeMillis();
        System.out.println("十万条数据插入时间（普通插入方式）：" + (end - start) + " ms");
    }
}
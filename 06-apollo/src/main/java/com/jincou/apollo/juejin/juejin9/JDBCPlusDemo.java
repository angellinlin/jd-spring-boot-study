package com.jincou.apollo.juejin.juejin9;

/**
 * @author zhouguilong6
 * @date 2025/2/8 13:52
 */

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC - 批处理插入
 * @author 单程车票
 */
public class JDBCPlusDemo {
    public static void main(String[] args) {
        // url 设置允许重写批量提交 rewriteBatchedStatements=true
        String url="jdbc:mysql://11.183.30.49:3306/ledger_fufu?rewriteBatchedStatements=true&zeroDateTimeBehavior=convertToNull&characterEncoding=utf8&useUnicode=true&autoReconnect=true&failOverReadOnly=false&connectTimeout=2000&socketTimeout=30000&serverTimezone=Asia/Shanghai&allowMultiQueries=true";
        String user="ledger_fufu_push";
        String password="c7Gy9>9EI";
        String driver = "com.mysql.cj.jdbc.Driver";
        // sql语句（注意url设置为rewriteBatchedStatements=true时，不允许sql语句带有;号，否则会抛出BatchUpdateException异常）
        String sql = "INSERT INTO fee(`owner`,`fee1`,`fee2`,`fee3`,`fee4`,`fee5`) VALUES (?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        // 开始时间
        long start = System.currentTimeMillis();
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            ps = conn.prepareStatement(sql);
            // 关闭自动提交
            conn.setAutoCommit(false);
            for (int i = 1; i <= 100000; i++) {
                ps.setString(1, "o"+i);
                ps.setBigDecimal(2, new BigDecimal("11111.111"));
                ps.setBigDecimal(3, new BigDecimal("11111.111"));
                ps.setBigDecimal(4, new BigDecimal("11111.111"));
                ps.setBigDecimal(5, new BigDecimal("11111.111"));
                ps.setBigDecimal(6, new BigDecimal("11111.111"));
                // 加入批处理（将当前sql加入缓存）
                ps.addBatch();
                // 以 1000 条数据作为分片
                if (i % 1000 == 0) {
                    // 执行缓存中的sql语句
                    ps.executeBatch();
                    // 清空缓存
                    ps.clearBatch();
                }
            }
            ps.executeBatch();
            ps.clearBatch();
            // 事务提交（实际开发中需要判断有插入失败的需要在 finally 中做好事务回滚操作）
            conn.commit();
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
        System.out.println("十万条数据插入时间（批处理插入）：" + (end - start) + " ms");
    }
}
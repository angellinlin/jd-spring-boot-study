package com.jincou.apollo.juejin;

/**
 * @author zhouguilong6
 * @date 2025/1/3 17:04
 */
import com.jincou.apollo.juejin.jdbcUtils.PoolUtil;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class TestPool {

    @Test
    public void test() {
        System.out.println("Preparing test>>>");
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            conn = PoolUtil.getPoolConn();
            // create sql
            String sql = " select id, pin, loan_no, event_category, product_type, complaint_type, complaint_source,\n" +
                    "  created_user, org_id, org_name, event_id, event_status, id_no, phone_num, curr_operator,\n" +
                    "  complaint_info, created_time, modified_time\n" +
                    "  from inv_cus_event_info where id = 10101 \n";
            preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                System.out.printf("id: %d, name: %s, age: %d%n", id, name, age);
            }

        } catch (SQLException e) {
            System.out.println("数据库操作有问题");
            e.printStackTrace();
        } finally {
            PoolUtil.close(conn, preparedStatement, rs);
        }
    }
}

package com.jincou.apollo.juejin;

/**
 * @author zhouguilong6
 * @date 2025/1/3 17:04
 */
import com.jincou.apollo.juejin.jdbcUtils.PoolUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
                    "  from inv_cus_event_info \n";

            String sql2 = "update inv_cus_event_info set pin = \"345463\" where id = 10101";
            preparedStatement = conn.prepareStatement(sql);
            if(StringUtils.isNotEmpty(sql) && !sql.contains("update")){
                rs = preparedStatement.executeQuery();
                handleQueryResultSet(rs);
            }else{
                int i = preparedStatement.executeUpdate(sql2);
            }
        } catch (SQLException e) {
            System.out.println("数据库操作有问题");
            e.printStackTrace();
        } finally {
            PoolUtil.close(conn, preparedStatement, rs);
        }
    }

    private static void handleQueryResultSet(ResultSet rs) throws SQLException {
        // 结果集合元数据
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        List<HashMap<String,String>> list = new ArrayList<>();
        while (rs.next()) {
            int length = resultSetMetaData.getColumnCount();
            HashMap<String, String> map = new HashMap<>();
            for (int i = 0; i < length; i++) {
                String columnName = resultSetMetaData.getColumnName(i+1);
                Object object = rs.getObject(i+1);
                map.put(columnName,object+"");
            }
            list.add(map);
            System.out.println(list);
        }
    }
}

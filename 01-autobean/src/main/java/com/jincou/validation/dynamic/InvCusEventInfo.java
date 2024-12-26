package com.jincou.validation.dynamic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvCusEventInfo {
    private Long id;

    private String pin;

    private String loanNo;

    private String eventCategory;

    private String productType;

    private String complaintType;

    private String complaintSource;

    private String createdUser;

    private String orgId;

    private String orgName;

    private String eventId;

    private String eventStatus;

    private String idNo;

    private String phoneNum;

    private String currOperator;

    private String complaintInfo;

    private Date createdTime;

    private Date modifiedTime;

    private String attachment;

    public enum Column {
        id("id", "id", "BIGINT", false),
        pin("pin", "pin", "VARCHAR", false),
        loanNo("loan_no", "loanNo", "VARCHAR", false),
        eventCategory("event_category", "eventCategory", "VARCHAR", false),
        productType("product_type", "productType", "VARCHAR", false),
        complaintType("complaint_type", "complaintType", "VARCHAR", false),
        complaintSource("complaint_source", "complaintSource", "VARCHAR", false),
        createdUser("created_user", "createdUser", "VARCHAR", false),
        orgId("org_id", "orgId", "VARCHAR", false),
        orgName("org_name", "orgName", "VARCHAR", false),
        eventId("event_id", "eventId", "VARCHAR", false),
        eventStatus("event_status", "eventStatus", "VARCHAR", false),
        idNo("id_no", "idNo", "VARCHAR", false),
        phoneNum("phone_num", "phoneNum", "VARCHAR", false),
        currOperator("curr_operator", "currOperator", "VARCHAR", false),
        complaintInfo("complaint_info", "complaintInfo", "VARCHAR", false),
        createdTime("created_time", "createdTime", "TIMESTAMP", false),
        modifiedTime("modified_time", "modifiedTime", "TIMESTAMP", false),
        attachment("attachment", "attachment", "LONGVARCHAR", false);

        private static final String BEGINNING_DELIMITER = "\"";

        private static final String ENDING_DELIMITER = "\"";

        private final String column;

        private final boolean isColumnNameDelimited;

        private final String javaProperty;

        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        public static Column[] all() {
            return Column.values();
        }

        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}
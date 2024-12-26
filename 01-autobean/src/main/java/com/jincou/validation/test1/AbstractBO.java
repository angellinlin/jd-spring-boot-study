package com.jincou.validation.test1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 因为要统一处理这些数据，因此将其抽象起来。
 *
 * 后续的逻辑会根据dataType来进行分别处理。
 *
 * @author dongjian1
 * */
public abstract class AbstractBO {

    private DataTypeEnum dataType;

    public DataTypeEnum getDataType() {
        return dataType;
    }

    public void setDataType(DataTypeEnum dataType) {
        this.dataType = dataType;
    }

    public enum DataTypeEnum {
        /**
         * 基本信息
         * */
        BASIC,
        /**
         * 合同签署信息
         * */
        CONTRACT,
        /**
         * 借据确认信息
         * */
        LOAN,
        /**
         * 放款处理结果
         * */
        ISSUE,
        /**
         * 还款处理结果
         * */
        REPAYMENT,
        /**
         * 催收记录
         * */
        URGE,
        /**
         * 户籍信息
         * */
        HOME,
        /**
         * 交易流水
         * */
        TRADE,
        /**
         * 催收记录
         * */
        TRANSFER,
        /**
         * 清单单元
         * */
        ITEM,
        /**
         * 文件生成详情
         */
        DETAIL,
        ;
    }

    public enum BusinessTypeEnum {
        // 贷款
        Loan("贷款"),
        // 还款
        Repayment("还款");

        private String desc;

        BusinessTypeEnum(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }

    }

    /**
     * 出资比例
     * */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class InvestmentRatio {
        private String investorId;
        private String investorName;
        private BigDecimal ratio;
    }
}

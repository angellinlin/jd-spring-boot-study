package com.jincou.apollo.juejin.juejin9;

/**
 * @author zhouguilong6
 * @date 2025/2/8 14:03
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Fee 实体类
 * @author 单程车票
 */
@TableName("fee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fee {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String owner;
    private BigDecimal fee1;
    private BigDecimal fee2;
    private BigDecimal fee3;
    private BigDecimal fee4;
    private BigDecimal fee5;

}

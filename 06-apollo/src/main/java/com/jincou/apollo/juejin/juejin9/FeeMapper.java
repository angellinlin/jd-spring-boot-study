package com.jincou.apollo.juejin.juejin9;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
 * Fee Mapper接口
 * @author 单程车票
 */
@Mapper
public interface FeeMapper extends BaseMapper<Fee> {

    /**
     * 单条数据插入
     * @param fee 实体类
     * @return 插入结果
     */
    int insertByOne(Fee fee);

    /**
     * foreach动态拼接sql插入
     * @param feeList 实体类集合
     * @return 插入结果
     */
    int insertByForeach(List<Fee> feeList);
}
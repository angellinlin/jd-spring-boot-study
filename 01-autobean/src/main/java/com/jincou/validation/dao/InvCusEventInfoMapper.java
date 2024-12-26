package com.jincou.validation.dao;

import com.jincou.validation.dynamic.InvCusEventInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author zhouguilong6
 */
@Mapper
public interface InvCusEventInfoMapper {
    /**
     * 根据主键查询客户事件信息。
     * @param id 客户事件的唯一标识符。
     * @return 对应主键的客户事件信息对象。
     */
    InvCusEventInfo selectByPrimaryKey(Long id);
}
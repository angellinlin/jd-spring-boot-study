package com.jincou.validation.dao;

import com.jincou.validation.dynamic.DataSource;
import com.jincou.validation.dynamic.DataSourceNames;
import com.jincou.validation.dynamic.InvCusEventInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.naming.Name;

/**
 * @author zhouguilong6
 */


public interface Jt2TaskMapper {
    /**
     * 根据主键查询客户事件信息。
     * @param id 客户事件的唯一标识符。
     * @return 对应主键的客户事件信息对象。
     */


    String selectByPrimaryKey1(Long id);
}
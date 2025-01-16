package com.jincou.third.dao;


import com.jincou.third.entity.CrlDebtDtArchiveInfoDO;
import com.jincou.third.entity.CrlDebtDtArchiveInfoDOExample;
import org.apache.ibatis.annotations.Flush;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface CrlDebtDtArchiveInfoDOMapper {
    long countByExample(CrlDebtDtArchiveInfoDOExample example);

    int insert(CrlDebtDtArchiveInfoDO row);

    int insertSelective(CrlDebtDtArchiveInfoDO row);

    List<CrlDebtDtArchiveInfoDO> selectByExampleWithRowbounds(CrlDebtDtArchiveInfoDOExample example, RowBounds rowBounds);

    CrlDebtDtArchiveInfoDO selectOneByExample(CrlDebtDtArchiveInfoDOExample example);

    List<CrlDebtDtArchiveInfoDO> selectByExample(CrlDebtDtArchiveInfoDOExample example);
    CrlDebtDtArchiveInfoDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") CrlDebtDtArchiveInfoDO row, @Param("example") CrlDebtDtArchiveInfoDOExample example);

    int updateByExample(@Param("row") CrlDebtDtArchiveInfoDO row, @Param("example") CrlDebtDtArchiveInfoDOExample example);

    int updateByPrimaryKeySelective(CrlDebtDtArchiveInfoDO row);

    int updateByPrimaryKey(CrlDebtDtArchiveInfoDO row);
}
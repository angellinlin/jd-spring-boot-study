package com.jincou.third.service;

import com.jdd.fintech.morse.base.entity.split.bt.archives.CrlDebtbtArchiveInfo;
import com.jincou.third.dao.CrlDebtbtArchiveInfoMapper;

import com.jincou.third.entity.CrlDebtDtArchiveInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhouguilong6
 * @date 2024/12/26 13:22
 */
@Service
public class MorseServiceImpl {
    @Autowired
    private CrlDebtbtArchiveInfoMapper crlDebtbtArchiveInfoMapper;

    @Transactional
    public List<CrlDebtDtArchiveInfoDO> selectByBusiNoAndCustmerCode(String id) {
        return crlDebtbtArchiveInfoMapper.selectByBusiNoAndCustmerCode("xiamen_trust");
    }

    @Transactional
    public int insertSelective(CrlDebtbtArchiveInfo crlDebtbtArchiveInfo) {
        return crlDebtbtArchiveInfoMapper.insertSelective(crlDebtbtArchiveInfo);
    }
}

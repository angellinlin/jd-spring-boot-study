package com.jincou.third.controller;

import com.jdd.fintech.morse.base.entity.split.bt.archives.CrlDebtbtArchiveInfo;
import com.jincou.third.entity.CrlDebtDtArchiveInfoDO;
import com.jincou.third.service.MorseServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhouguilong6
 * @date 2024/12/26 11:41
 */
@RestController
public class TestMorseController {

    @Resource
    private MorseServiceImpl cusComplaintService;
    @PostMapping(path = "/selectByBusiNoAndCustmerCode")
    public  List<CrlDebtDtArchiveInfoDO> selectByBusiNoAndCustmerCode(@RequestParam String id) {
        return cusComplaintService.selectByBusiNoAndCustmerCode(id);
    }


    @PostMapping(path = "/insertSelective")
    public int insertSelective(@RequestBody CrlDebtbtArchiveInfo crlDebtbtArchiveInfo) {
        return cusComplaintService.insertSelective(crlDebtbtArchiveInfo);
    }
}

package com.jincou.validation.controller;

import com.jincou.validation.dynamic.CusComplaintServiceImpl;
import com.jincou.validation.dynamic.InvCusEventInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhouguilong6
 * @date 2024/12/26 11:41
 */
@RestController
public class TestController {

    @Resource
    private CusComplaintServiceImpl cusComplaintService;
    // 先查询事件表
    @GetMapping(path = "/third-bean1")
    public InvCusEventInfo show() {
        return cusComplaintService.selectByPrimaryKey(10102L);
    }

    @GetMapping(path = "/third-bean2")
    public String show1() {
        return cusComplaintService.selectByPrimaryKey1(5L);
    }


}

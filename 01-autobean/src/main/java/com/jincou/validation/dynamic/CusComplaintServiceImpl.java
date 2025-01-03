package com.jincou.validation.dynamic;

import com.jincou.validation.dao.InvCusEventInfoMapper;
import com.jincou.validation.dao.Jt2TaskMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhouguilong6
 * @date 2024/12/26 13:22
 */
@Service
public class CusComplaintServiceImpl {
    @Resource
    private InvCusEventInfoMapper invCusEventInfoMapper;

    @Resource
    private Jt2TaskMapper jt2TaskMapper;
    // 先查询事件表
    public InvCusEventInfo selectByPrimaryKey(Long id) {
        return invCusEventInfoMapper.selectByPrimaryKey(id);
    }


    @DataSource(DataSourceNames.SECOND)
    public String selectByPrimaryKey1(Long id) {
        return jt2TaskMapper.selectByPrimaryKey1(id);
    }
}

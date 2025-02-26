package com.jincou.validation.dynamic;

import com.jincou.validation.dao.InvCusEventInfoMapper;
import com.jincou.validation.dao.Jt2TaskMapper;
import com.jincou.validation.entity.TaskBean;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

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
    @Transactional(transactionManager = "transactionManager1",propagation= Propagation.REQUIRES_NEW)
    @DataSource(DataSourceNames.FIRST)
    public InvCusEventInfo selectByPrimaryKey(Long id) {
        InvCusEventInfo invCusEventInfo = InvCusEventInfo.builder().complaintInfo("ggg").pin("iii").eventCategory("ggg").productType("ggg").complaintType("ggh").complaintSource("ggg").createdUser("eee").orgId("gghh").orgName("ghh").eventId("grr").complaintInfo("gg").createdTime(new Date())
                .modifiedTime(new Date()).complaintSource("ggh").attachment("gg").build();
       invCusEventInfoMapper.insertSelective(invCusEventInfo);
       int i = 1/0;
       return invCusEventInfoMapper.selectByPrimaryKey(id);
    }

    @DataSource(DataSourceNames.SECOND)
    public String selectByPrimaryKey1(Long id) {
        TaskBean taskBean = TaskBean.builder().taskId("gg").createTime(new Date()).yn(1).rev(2).taskName("ggg").subject("gg").instId("gg").status("g").build();
        jt2TaskMapper.insertSelective(taskBean);
        return jt2TaskMapper.selectByPrimaryKey1(id);
    }
}

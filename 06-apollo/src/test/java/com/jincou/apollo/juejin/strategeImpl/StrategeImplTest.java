package com.jincou.apollo.juejin.strategeImpl;

import com.jincou.apollo.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhouguilong6
 * @date 2024/12/30 14:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class StrategeImplTest {

    @Autowired
    private ISmsService service;
    @Test
    public void testSend() {
        service.send("心中无女人，编码自然神", ESmsSendStatus.SENDING.getType());
    }

}

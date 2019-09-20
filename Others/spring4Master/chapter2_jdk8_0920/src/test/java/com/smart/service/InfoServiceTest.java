package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.parsers.FactoryConfigurationError;
import java.rmi.ServerError;

@ContextConfiguration("classpath*:/smart-context.xml")
@Rollback(value = true)  // 改成回滚
@Transactional(transactionManager = "transactionManager")
public class InfoServiceTest extends AbstractTransactionalTestNGSpringContextTests {
    private InfoService infoService;

    @Autowired
    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }

    @Test
    public void testGetInfo(){
        Assert.assertTrue("spring!".equals(infoService.getInfo().getInfo()));
    }
}

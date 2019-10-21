package com.zrx.OtherTest;

import com.zrx.factory.AccountServiceProxyFactory;
import com.zrx.service.IAccountService;
import com.zrx.service.impl.AccountServiceWaitForSpring;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;

/**
 * 事务控制
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
@Commit()
public class TransferTest {
//    @Autowired
//    private AccountServiceProxyFactory accountServiceProxyFactory;

    @Autowired
    @Qualifier("accountServiceWaitFor")
    private IAccountService accountServiceWaitFor;
//    private IAccountService accountService;


    @Autowired
    @Qualifier("accountServiceWaitForSpring")
    private IAccountService accountServiceWaitForSpring;

    @Test
    public void twice()throws Exception{
        final File file = new File("1.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file,true);
        fileWriter.write(new Date() +"1\r\n");
        fileWriter.close();
    }

    @Test
    public void TestTransfer(){
        System.out.println("accountServiceWaitFor = " + accountServiceWaitFor);
        accountServiceWaitFor.transfer("aaa","bbb",-111F);
        System.out.println(accountServiceWaitFor.findAll());
    }

    @Test
    public void transferTest(){
        accountServiceWaitForSpring.transfer("aaa","bbb",111F);
        System.out.println(accountServiceWaitForSpring.findAll());
    }

    @Test
    public void test(){
//        final IAccountService accountServiceWaitFor = accountServiceProxyFactory.getAccountServiceWaitFor();
//
//        System.out.println("accountServiceWaitFor = " + accountServiceWaitFor);
    }
}

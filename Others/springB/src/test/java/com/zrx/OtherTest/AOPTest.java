package com.zrx.OtherTest;

import com.zrx.service.IARuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.management.counter.perf.PerfInstrumentation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class AOPTest {
    @Autowired
    private IARuService aRuService;

    @Test
    public void test(){
        System.out.println("aRuService = " + aRuService);

        aRuService.methodNeedEnhance();
        System.out.println("-----------------");
        aRuService.methodNotNeedEnhance();
        System.out.println("-----------------");
        aRuService.methodNeedAroundEnhance();
    }
}

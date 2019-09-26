package com.smart;

import com.smart.AOP.PreGreetingAspect;
import com.smart.AOP.Waiter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.activation.MailcapCommandMap;

@RunWith(SpringJUnit4ClassRunner.class) // //使用junit4进行测试
@ContextConfiguration(locations = "classpath:smart-context.xml")
public class AOPSpringTest {
    @Autowired
    private Waiter naiveWaiter;

    @Autowired
    private ProxyFactory waiterProxyFactory;

    @Autowired
    private ProxyFactory waiterProxyFactory2;

    @Autowired
    private BeforeAdvice greetingBeforeAdvice;

    @Autowired
    private AspectJProxyFactory aspectJProxyFactory;
    @Autowired
    private PreGreetingAspect preGreetingAspect;

    @Test
    public void greetTest(){
        String client = "maio";
        naiveWaiter.greetTo(client);
        naiveWaiter.serveTo(client);

        waiterProxyFactory.addAdvice(greetingBeforeAdvice);
//        waiterProxyFactory.setTarget();
//        waiterProxyFactory.setInterfaces();

        Waiter proxy = (Waiter)waiterProxyFactory.getProxy();
        proxy.greetTo(client);
        proxy.serveTo(client);
    }

    @Test
    public void greetTest2(){
        String client = "maio";
        naiveWaiter.greetTo(client);
        naiveWaiter.serveTo(client);

        waiterProxyFactory2.setInterfaces(naiveWaiter.getClass().getInterfaces());

        waiterProxyFactory.setTarget(naiveWaiter);

        waiterProxyFactory.addAdvice(greetingBeforeAdvice);

        Waiter proxy = (Waiter)waiterProxyFactory.getProxy();
        proxy.greetTo(client);
        proxy.serveTo(client);

    }

    @Test
    public void greetAspectTest(){
        aspectJProxyFactory.setTarget(naiveWaiter);
        aspectJProxyFactory.addAspect(preGreetingAspect);
        final Waiter proxy = (Waiter)aspectJProxyFactory.getProxy();
        proxy.greetTo("miaomiao");
    }

    @org.junit.Before
    public void before(){ System.out.println("----------------"); }
    @org.junit.After
    public void after(){ System.out.println("----------------"); }
}

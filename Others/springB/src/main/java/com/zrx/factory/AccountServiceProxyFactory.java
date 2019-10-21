package com.zrx.factory;

import com.zrx.service.IAccountService;
import com.zrx.utils.TransactionManager;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class AccountServiceProxyFactory {
    private IAccountService accountServiceWaitFor;
    private TransactionManager transactionManager;

    @Autowired
    @Qualifier("accountServiceWaitFor")
    public void setAccountServiceWaitFor(IAccountService accountServiceWaitFor) {
        this.accountServiceWaitFor = accountServiceWaitFor;
    }

    @Autowired
    public void setTransactionManager(TransactionManager transactionManager){
        this.transactionManager = transactionManager;
    }

    public IAccountService getAccountServiceWaitFor() {
        System.out.println("accountServiceWaitFor = " + accountServiceWaitFor);
        System.out.println("transactionManager = " + transactionManager);

        return (IAccountService) Proxy.newProxyInstance(accountServiceWaitFor.getClass().getClassLoader(),
                accountServiceWaitFor.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("proxy!!!");
                        try {
                            transactionManager.beginTransacion();
                            final Object invoke = method.invoke(accountServiceWaitFor, args);
                            transactionManager.commit();
                            return invoke;
                        }catch (Exception e){
                            transactionManager.rollback();
                            throw new RuntimeException(e);
                        }finally {
                            transactionManager.close();
                        }
                    }
                });
    }

}

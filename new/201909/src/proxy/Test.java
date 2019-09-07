package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        //创建真实对象
        final SaleComputer lenove = new Lenove();
        lenove.show();
        final String sale = lenove.sale(100);
        System.out.println(sale);
        System.out.println("lenove = " + lenove);

        System.out.println("-------------");

        //增加
        //动态代理
        SaleComputer proxy_lenove = (SaleComputer)Proxy.newProxyInstance(lenove.getClass().getClassLoader(),
                lenove.getClass().getInterfaces()
                , new InvocationHandler() {
            //代理逻辑
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("sale")){
                    System.out.println("proxy sale");
                    System.out.println(args[0]);
                    return null;
                }else {
                    return method.invoke(lenove,args);
                }
            }
        });

        proxy_lenove.sale(100);
        proxy_lenove.show();
    }
}

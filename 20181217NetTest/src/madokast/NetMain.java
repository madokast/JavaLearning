package madokast;

import java.net.InetAddress;

public class NetMain
{
    public static void main(String[] args) throws Exception{
        InetAddress ip = InetAddress.getByName("www.baidu.com");
        System.out.println("is it reachable? "+ip.isReachable(2000));
        //is it reachable? true

        System.out.println(ip.getAddress());
        //[B@13fee20c

        System.out.println(ip.getCanonicalHostName());
        //119.75.217.26

        System.out.println(ip.getHostAddress());
        //119.75.217.26

        System.out.println(ip.getHostName());
        //www.baidu.com


    }
}

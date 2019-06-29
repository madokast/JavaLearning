package web;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 395 视频
 * 软件结构
 * 1. C/S 结构
 *      客户端-服务器
 *      QQ 迅雷
 * 2. B/S 结构
 *      浏览器-服务器
 *      浏览器： 谷歌 IE 火狐
 *
 * 396 网络通信协议 - 共同遵守的规则 - 用于多台计算机连接
 *      TCP/IP 协议 - 四层模式
 *      UDP 协议
 * 397 网络通信协议分类 - java.net 包提供了 UDP 和 TCP 的网络协议支持
 *      UDP 发送时不用确认对方是否存在，消耗资源小；一般用于音频 视频的传输；不保证数据的完整；QQ聊天也是UDP
 *      TCP 三次握手
 * 398 网络编程三要素
 *      协议
 *      IP 地址 - 指定计算机
 *      端口号 -
 * 399  端口号
 * 400/401 TCP 通信程序
 *      客户端 java.net.Socket
 *      服务器 java.net.ServerSocket
 *      Socket类 实现客户端套接字 （套接字：两台设备之间的通讯的端点）
 *      构造方法：(host,port)
 *    通信步骤：
 *      服务器段先启动，但不会主动请求连接客户端
 *      客户端先请求链接
 *      建立逻辑连接 - 链接中通过 IO 字节流对象 进行通讯
 *    accept方法 获得 Socket
 *
 * 402 终于写代码了
 */
public class Test {
    //此类实现客户端套接字（也可以就叫“套接字”）。
    // 套接字是两台机器间通信的端点。
    //套接字的实际工作由 SocketImpl 类的实例执行。
    // 应用程序通过更改创建套接字实现的套接字工厂可以配置它自身，以创建适合本地防火墙的套接字。
    //Socket(InetAddress address, int port)
    //Socket(String host, int port)
    Socket socket = new Socket();//import java.net.Socket;
    public void test() throws Exception{
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        socket.close();
    }
}

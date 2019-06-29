package web;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器
 */

public class TCPServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器启动成功");
        Socket socket = serverSocket.accept();
        System.out.println("服务器建立好了连接");

        InputStream inputStream = socket.getInputStream();
        int len = 1024;
        byte[] bytes = new byte[len];
        len = inputStream.read(bytes);
        System.out.println("服务器收到: "+new String(bytes,0,len));

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("收到，谢谢".getBytes());
        System.out.println("服务器发信");

        socket.close();
        System.out.println("服务器关闭当前链接");
        serverSocket.close();
        System.out.println("服务器关闭");
    }
}

package web;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception{
        //java.net.ConnectException: Connection refused: connect
        Socket socket = new Socket("127.0.0.1",8888);
        System.out.println("客户端建立好了链接");

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好，服务器".getBytes());
        System.out.println("客户端发信");

        InputStream inputStream = socket.getInputStream();
        System.out.println("客户端收到: "+new String(inputStream.readAllBytes()));



        socket.close();
        System.out.println("客户端关闭");
    }
}

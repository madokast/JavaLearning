package web.fileUpload;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.Socket;
import java.util.Date;

public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1",8888);
        System.out.println("客户端建立了和服务器的连接");

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(new Date().toString().getBytes());
        File file = new File("./text.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fileInputStream.read(bytes))!=-1){
            System.out.println("客户端开始发送文件");
            System.out.println("客户端发送 len = " + len);
            outputStream.write(bytes,0,len);
        }
        outputStream.flush();
        System.out.println("客户端发送文件完毕");
        outputStream.write("EOF".getBytes());
        outputStream.flush();
        fileInputStream.close();

        InputStream inputStream = socket.getInputStream();
        len = inputStream.read(bytes);
        System.out.println("客户端收到信息："+new String(bytes,0,len));

        socket.close();
        System.out.println("客户端关闭");

    }
}

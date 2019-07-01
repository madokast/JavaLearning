package web.fileSend;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8000);
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            FileInputStream fileInputStream = new FileInputStream("./text.txt");

            System.out.println("client ready");
            int len;
            byte[] data = new byte[1024];
            while((len=fileInputStream.read(data))!=-1){
                System.out.println("client send "+len);
                outputStream.write(data,0, len);
            }
            System.out.println("client len = " + len);
            outputStream.flush();
            System.out.println("client send finished");
            socket.shutdownOutput();

            len =  inputStream.read(data);
            System.out.println("客户端收到："+new String(data, 0, len));

            socket.close();
            System.out.println("Client closed");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Client all close");
    }
}

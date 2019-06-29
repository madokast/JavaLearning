package web.fileUpload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器开机");
        Socket socket = serverSocket.accept();
        System.out.println("服务器收到了连接请求，建立了连接");

        InputStream inputStream = socket.getInputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        File file = new File("./getFile.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        while((len=inputStream.read(bytes))!=-1){
            System.out.println("服务器准备接收文件");
            System.out.println("服务器收到 len = " + len);
            if(new String(bytes,0,len).equals("EOF")){
                System.out.println("服务器文件接受完成");
                break;
            }

            fileOutputStream.write(bytes,0,len);
        }
//        System.out.println("服务器文件接受完成");
        fileOutputStream.flush();
        fileOutputStream.close();

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我收到文件了".getBytes());

        socket.close();
        serverSocket.close();
    }
}

package web.fileSend;

import javax.swing.plaf.basic.BasicBorders;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Server {
    public static void main(String[] args) {
//        v0();
        v1();
    }

    public static void v1(){
        try{
            ServerSocket serverSocket = new ServerSocket(8000);
            final Set<Socket> set = new HashSet<>();
            while(true){
                Socket accept = serverSocket.accept();
                set.add(accept);
                System.out.println("server 收到一个请求");
                new Thread(()->{
                    Socket socket = set.iterator().next();
                    set.remove(socket);
                    try {
                        InputStream inputStream = socket.getInputStream();
                        OutputStream outputStream = socket.getOutputStream();
                        FileOutputStream fileOutputStream = new FileOutputStream("./"+getNewName()+".txt");
                        int len;
                        byte[] data = new byte[1024];
                        while((len=inputStream.read(data))!=-1){
                            System.out.println("server get "+len);
                            fileOutputStream.write(data,0,len);
                        }
                        fileOutputStream.flush();
                        System.out.println("server：文件接受完成");
                        fileOutputStream.close();
                        outputStream.write("文件接受完成".getBytes());
                        socket.close();
                    }catch (Exception e){}
                }).start();
                /**
                 * "D:\Program Files\jdk-12.0.1\bin\java.exe" "-javaagent:D:\Program Files\JetBrains\IntelliJ IDEA 2019.1.3\lib\idea_rt.jar=57433:D:\Program Files\JetBrains\IntelliJ IDEA 2019.1.3\bin" -Dfile.encoding=UTF-8 -classpath D:\Documents\GitHub\JavaLearning\new\out\production\201907 web.fileSend.Server
                 * server 收到一个请求
                 * server get 1024
                 * server get 846
                 * server：文件接受完成
                 * server 收到一个请求
                 * server get 1024
                 * server get 846
                 * server：文件接受完成
                 * server 收到一个请求
                 * server get 1024
                 * server get 846
                 * server：文件接受完成
                 */
            }
        }catch (Exception e){}
    }

    public static String getNewName(){
        return "file"+"_"+System.currentTimeMillis()+"_"+new Random().nextInt(100);
    }

    public static void v0(){
        try (ServerSocket serverSocket = new ServerSocket(8000);
             FileOutputStream fileOutputStream = new FileOutputStream("./getText")
        ) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            System.out.println("server ready");
            int len;
            byte[] data = new byte[1024];
            while((len=inputStream.read(data))!=-1){
                System.out.println("server get "+len);
                fileOutputStream.write(data,0,len);
            }
            System.out.println("Server len = " + len);
            fileOutputStream.flush();
            System.out.println("server get finished");

            outputStream.write("服务器成功收到文件".getBytes());

            socket.close();

            System.out.println("server closed");

        }catch (IOException e){}

        System.out.println("Server all close");
    }
}

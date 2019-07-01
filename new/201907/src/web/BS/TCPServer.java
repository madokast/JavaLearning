package web.BS;

import javax.sql.rowset.spi.SyncResolver;
import javax.xml.crypto.Data;
import java.io.*;
import java.lang.reflect.AccessibleObject;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * 409
 * BS 版本的 TCO 服务器
 * 这也太强了吧！！
 *  //  D:\Documents\GitHub\htmlAndCSS\WebProgramDesign\htmlBase.html
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建服务器
        ServerSocket serverSocket = new ServerSocket(8000);
        final Set<Socket> set = new HashSet<>();

        while(true){
            Socket accept = serverSocket.accept();
            synchronized (set){
                set.add(accept);
            }
            new Thread(()->{
                Socket socket;
                InputStream inputStream;
                OutputStream outputStream;
                BufferedReader bufferedReader;
                try{
                    synchronized (set){
                        socket = set.iterator().next();
                        set.remove(socket);
                    }

                    System.out.println("收到一个请求");
                    inputStream = socket.getInputStream();
                    outputStream = socket.getOutputStream();
                    bufferedReader = new BufferedReader(
                            new InputStreamReader(inputStream)
                    );//java 恶不恶心？
                    String s = bufferedReader.readLine();
                    System.out.println("s = " + s);
                    String urls = s.split(" ")[1];
                    System.out.println("urls = " + urls);
                    String file = URLDecoder.decode(urls, "UTF-8");
                    System.out.println("file = " + file);


                    System.out.println("响应");

                    try{
                        FileInputStream fileInputStream = new FileInputStream(new File("D:\\Documents\\GitHub\\htmlAndCSS",file));
                        outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                        outputStream.write("Content-Type:text/html\r\n".getBytes());
                        outputStream.write("\r\n".getBytes());
                        int len;
                        byte[] bytes = new byte[1024];
                        while((len=fileInputStream.read(bytes))!=-1){
                            outputStream.write(bytes,0,len);
                        }
                    }catch (Exception e){
                        outputStream.write("HTTP/1.1 404 NO-FOUND\r\n".getBytes());
                        outputStream.write("\r\n".getBytes());
                        System.out.println("没找到文件");
                    }finally {
                        outputStream.flush();
                        socket.shutdownOutput();
                        socket.close();
                    }
                }catch (Exception e){e.printStackTrace();
                }
                finally { }



            }).start();
        }
//        serverSocket.close();
    }
}

//GET /123/abc?name=zrx HTTP/1.1
//Host: 127.0.0.1:8000
//Connection: keep-alive
//Upgrade-Insecure-Requests: 1
//User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.90 Safari/537.36
//Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3
//Accept-Encoding: gzip, deflate, br
//Accept-Language: zh-CN,zh;q=0.9,en;q=0.8

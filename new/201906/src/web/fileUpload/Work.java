package web.fileUpload;

public class Work {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                Server.main(null);
            }catch (Exception e){e.printStackTrace();}
        }).start();

        try {
            Thread.currentThread().sleep(100);
        }catch (Exception e){;}

        new Thread(()->{
            try {
                Client.main(null);
            }catch (Exception e){e.printStackTrace();}
        }).start();
    }
}

//"D:\Program Files\jdk-12.0.1\bin\java.exe" "-javaagent:D:\Program Files\JetBrains\IntelliJ IDEA 2019.1.3\lib\idea_rt.jar=52309:D:\Program Files\JetBrains\IntelliJ IDEA 2019.1.3\bin" -Dfile.encoding=UTF-8 -classpath D:\Documents\GitHub\JavaLearning\new\out\production\201906 web.fileUpload.Work
//服务器开机
//客户端建立了和服务器的连接
//服务器收到了连接请求，建立了连接
//服务器准备接收文件
//客户端开始发送文件
//服务器收到 len = 28
//客户端发送 len = 1024
//服务器准备接收文件
//服务器收到 len = 1024
//客户端开始发送文件
//客户端发送 len = 1024
//服务器准备接收文件
//服务器收到 len = 1024
//客户端开始发送文件
//客户端发送 len = 1024
//服务器准备接收文件
//服务器收到 len = 1024
//客户端开始发送文件
//客户端发送 len = 1024
//服务器准备接收文件
//服务器收到 len = 1024
//客户端开始发送文件
//客户端发送 len = 1024
//服务器准备接收文件
//服务器收到 len = 1024
//客户端开始发送文件
//客户端发送 len = 889
//服务器准备接收文件
//服务器收到 len = 889
//客户端发送文件完毕
//服务器准备接收文件
//服务器收到 len = 3
//服务器文件接受完成
//客户端收到信息：我收到文件了
//客户端关闭
//
//Process finished with exit code 0
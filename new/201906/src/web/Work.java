package web;

public class Work {
    public static void main(String[] args) throws Exception{
        new Thread(()->{try {
            TCPServer.main(null);
        }catch (Exception e){e.printStackTrace();}
        }).start();

        System.out.println("服务器开机");

        try {
            Thread.sleep(10);
        }catch (Exception e){;}

        new Thread(()->{try {
            TCPClient.main(null);
        }catch (Exception e){e.printStackTrace();}
        }).start();

        System.out.println("客户端开机");
    }
}

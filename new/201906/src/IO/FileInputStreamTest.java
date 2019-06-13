package IO;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

public class FileInputStreamTest {
    static File file = new File("./a.txt");
    static FileOutputStream fileOutputStream;
    static FileInputStream fileInputStream;
    private static final int EOF = -1;

    public static void main(String[] args) {
        prepare();
        write();
//        read();
        read1();
        close();
        file.delete();
    }

    private static void read1() {
        try{
            fileInputStream.mark(100);

            int t;
            while((t=fileInputStream.read())!=EOF){
//                System.out.print(t+" ");
                System.out.print((char)t);
            }

            fileInputStream.reset();

            while((t=fileInputStream.read())!=EOF){
//                System.out.print(t+" ");
                System.out.print((char)t);
            }
        }catch (Exception e){e.printStackTrace();}
    }
    //first line
    //2019-06-13T02:05:18.106Z

    private static void close() {
        try {
            fileInputStream.close();
            fileOutputStream.close();
        }catch (Exception e){e.printStackTrace();}
    }

    private static void read() {
        try{
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            System.out.println("bytes.length = " + bytes.length);
            System.out.println("new String(bytes) = " + new String(bytes));
        }catch (Exception e){e.printStackTrace();}
    }

    private static void write() {
        try{
            fileOutputStream.write("first line\n".getBytes());
            fileOutputStream.write((new Date().toInstant()+"\n").getBytes());
        }catch (Exception e){e.printStackTrace();}
    }

    public static void prepare(){
        try{
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file,true);
            fileInputStream = new FileInputStream(file);
        }catch (Exception e){System.exit(-1);}

    }
}

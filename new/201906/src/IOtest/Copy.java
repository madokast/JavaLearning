package IOtest;

import java.io.*;

/**
 * 测试文件复制速度
 */
public class Copy{
    static File file = new File("D:\\Desktop\\测试\\711.flv");
    static File file2 = new File("D:\\Desktop\\测试\\711copy.flv");
    static FileInputStream in ;
    static FileOutputStream out ;

    public static void main(String[] args) throws  Exception{
//        noBuffer();
        myBuffer();
        buffered();
        //69.879
        //0.088  0.096  0.107
        //0.021  0.047  0.031
        bufferedNObuffer();
        //0.218 0.144
        buffered8192();
        //0.022
    }

    private static void buffered8192()throws Exception {
        file2.delete();
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file2));

        long s = System.currentTimeMillis();
        int length = 8192;
        byte[] bytes = new byte[length];
        while((length=in.read(bytes))!=-1){
            out.write(bytes,0,length);
        }
        in.close();
        out.close();

        System.out.println((System.currentTimeMillis() - s)/1000.0);
    }

    private static void bufferedNObuffer() throws  Exception {
        file2.delete();
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file2));

        long s = System.currentTimeMillis();
        int t;
        while((t=in.read())!=-1){
            out.write(t);
        }
        in.close();
        out.close();

        System.out.println((System.currentTimeMillis() - s)/1000.0);
    }

    private static void buffered() throws  Exception{
        file2.delete();
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file2));

        long s = System.currentTimeMillis();
        int length = 1024;
        byte[] bytes = new byte[length];
        while((length=in.read(bytes))!=-1){
            out.write(bytes,0,length);
        }
        in.close();
        out.close();

        System.out.println((System.currentTimeMillis() - s)/1000.0);
    }

    private static void myBuffer() throws Exception{
        file2.delete();
        in = new FileInputStream(file);
        out = new FileOutputStream(file2);

        long s = System.currentTimeMillis();
        int length = 1024;
        byte[] bytes = new byte[length];
        while((length=in.read(bytes))!=-1){
            out.write(bytes,0,length);
        }
        in.close();
        out.close();

        System.out.println((System.currentTimeMillis() - s)/1000.0);
        //70秒
    }

    private static void noBuffer() throws  Exception{

        file2.delete();
        in = new FileInputStream(file);
        out = new FileOutputStream(file2);

        long s = System.currentTimeMillis();
        int t=0;
        while((t=in.read())!=-1){
            out.write(t);
        }
        in.close();
        out.close();

        System.out.println((System.currentTimeMillis() - s)/1000.0);
        //70秒
    }
}

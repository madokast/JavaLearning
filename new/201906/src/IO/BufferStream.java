package IO;

import java.io.*;

/**
 * 缓冲流
 */
public class BufferStream {
    /**
     * write
     * flush
     * close
     */
    OutputStream outputStream;

    FileOutputStreamTest fileOutputStreamTest;

    /**
     * java.lang.Object
     *   继承者 java.io.OutputStream
     *       继承者 java.io.FilterOutputStream
     *           继承者 java.io.BufferedOutputStream
     *
     * BufferedOutputStream
     * public BufferedOutputStream(OutputStream out,
     *                             int size)
     * 创建一个新的缓冲输出流，以将具有指定缓冲区大小的数据写入指定的底层输出流。
     * 参数：
     * out - 底层输出流。
     * size - 缓冲区的大小。
     */
    BufferedOutputStream bufferedOutputStream;

    /**
     * 此类是过滤输出流的所有类的超类。
     * 这些流位于已存在的输出流（基础 输出流）之上，
     * 它们将已存在的输出流作为其基本数据接收器，
     * 但可能直接传输数据或提供一些额外的功能。
     *
     * FilterOutputStream 类本身只是简单地重写那些将所有请求传递给所包含输出流的 OutputStream 的所有方法。
     * FilterOutputStream 的子类可进一步地重写这些方法中的一些方法，并且还可以提供一些额外的方法和字段。
     *
     * FilterOutputStream(OutputStream out)
     *           创建一个构建在指定基础输出流之上的输出流过滤器。
     *
     * 方法不变
     */
    FilterOutputStream filterOutputStream;

    public static void main(String[] args) {
        File file = new File("./a.txt");
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            bufferedOutputStream.write("abcdefg".getBytes());
            bufferedOutputStream.flush();
            bufferedOutputStream.close();

            System.out.println(new String(bufferedInputStream.readAllBytes()));
            bufferedInputStream.close();

            Reader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            System.out.println(bufferedReader.readLine());
            bufferedReader.close();
        }catch (Exception e){e.printStackTrace();}
    }
}

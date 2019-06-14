package IO;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ReaderTest {
    static File file = new File("./a.txt");

    // * Abstract class for reading character streams.  The only methods that a
    // * subclass must implement are read(char[], int, int) and close().  Most
    // * subclasses, however, will override some of the methods defined here in order
    // * to provide higher efficiency, additional functionality, or both.
    //用于读取字符流的抽象类。
    // 子类必须实现的方法只有 read(char[], int, int) 和 close()。
    // 但是，多数子类将重写此处定义的一些方法，以提供更高的效率和/或其他功能。
    //abstract  void
    //close()关闭该流并释放与之关联的所有资源。
    // void
    //mark(int readAheadLimit)标记流中的当前位置。
    // boolean
    //markSupported()判断此流是否支持 mark() 操作。
    // int
    //read()读取单个字符。
    // int
    //read(char[] cbuf)将字符读入数组。
    //abstract  int
    //read(char[] cbuf, int off, int len)将字符读入数组的某一部分。
    // int
    //read(CharBuffer target)试图将字符读入指定的字符缓冲区。
    // boolean
    //ready()判断是否准备读取此流。
    // void
    //reset()重置该流。
    // long
    //skip(long n)跳过字符。
//    Reader reader;

    //用来读取字符文件的便捷类。
    // 此类的构造方法假定默认字符编码和默认字节缓冲区大小都是适当的。
    // 要自己指定这些值，可以先在 FileInputStream 上构造一个 InputStreamReader。
    //FileReader 用于读取字符流。要读取原始字节流，请考虑使用 FileInputStream。

    //FileReader(File file)在给定从中读取数据的 File 的情况下创建一个新 FileReader。
    //FileReader(FileDescriptor fd)在给定从中读取数据的 FileDescriptor 的情况下创建一个新 FileReader。
    //FileReader(String fileName)在给定从中读取数据的文件名的情况下创建一个新 FileReader。

    //方法摘要
    //
    //从类 java.io.InputStreamReader 继承的方法
    //close, getEncoding, read, read, ready
    //
    //从类 java.io.Reader 继承的方法
    //mark, markSupported, read, read, reset, skip
    //
    //从类 java.lang.Object 继承的方法
    //clone, equals, finalize, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait

//    FileReader fileReader;


    //InputStreamReader 是字节流通向字符流的桥梁：
    // 它使用指定的 charset 读取字节并将其解码为字符。
    // 它使用的字符集可以由名称指定或显式给定，或者可以接受平台默认的字符集。
    //每次调用 InputStreamReader 中的一个 read() 方法都会导致从底层输入流读取一个或多个字节。
    // 要启用从字节到字符的有效转换，可以提前从底层流读取更多的字节，使其超过满足当前读取操作所需的字节。
    //为了达到最高效率，可要考虑在 BufferedReader 内包装 InputStreamReader。例如：
    // BufferedReader in
    //   = new BufferedReader(new InputStreamReader(System.in));

    //InputStreamReader(InputStream in)创建一个使用默认字符集的 InputStreamReader。
    //InputStreamReader(InputStream in, Charset cs)创建使用给定字符集的 InputStreamReader。
    //InputStreamReader(InputStream in, CharsetDecoder dec)创建使用给定字符集解码器的 InputStreamReader。
    //InputStreamReader(InputStream in, String charsetName)创建使用指定字符集的 InputStreamReader。

    // void
    //close()关闭该流并释放与之关联的所有资源。
    // String
    //getEncoding()返回此流使用的字符编码的名称。
    // int
    //read()读取单个字符。
    // int
    //read(char[] cbuf, int offset, int length)将字符读入数组中的某一部分。
    // boolean
    //ready()判断此流是否已经准备好用于读取。
//    InputStreamReader inputStreamReader;

//    static File file;
    static FileOutputStream fileOutputStream;
    static FileInputStream fileInputStream;
    static InputStreamReader inputStreamReader;
    static FileReader fileReader;

    public static void main(String[] args) {
//        prepare();
        fileReaderTest();
//        fileReaderTest2();
    }

    private static void fileReaderTest2() {
        try {
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream);
//            System.out.println("inputStreamReader.getEncoding() = " + inputStreamReader.getEncoding());
//            int ch = 0;
//            while((ch=inputStreamReader.read())!=-1){
//                System.out.print((char) ch);
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileReaderTest() {
        try {
            fileReader = new FileReader(file);
            final int buffer = 100;
            int length = 0;
            char[] chars = new char[buffer];
            while((length = fileReader.read(chars))!=-1){
                new String(chars).chars().limit(length).mapToObj(c->(char)c).forEach(System.out::print);
//                Arrays.stream(chars).limit(length).forEach(System.out::print);

            }
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void prepare(){
        try{
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file,true);
            fileInputStream = new FileInputStream(file);
        }catch (Exception e){System.exit(-1);}

    }
}

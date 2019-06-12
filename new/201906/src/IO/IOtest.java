package IO;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class IOtest {
    // * This abstract class is the superclass of all classes representing
    // * an output stream of bytes. An output stream accepts output bytes
    // * and sends them to some sink.
    static OutputStream outputStream;

    // * A file output stream is an output stream for writing data to a
    // * <code>File</code> or to a <code>FileDescriptor</code>. Whether or not
    // * a file is available or may be created depends upon the underlying
    // * platform.  Some platforms, in particular, allow a file to be opened
    // * for writing by only one {@code FileOutputStream} (or other
    // * file-writing object) at a time.  In such situations the constructors in
    // * this class will fail if the file involved is already open.
    //文件输出流是用于将数据写入 File 或 FileDescriptor 的输出流。
    // 文件是否可用或能否可以被创建取决于基础平台。
    // 特别是某些平台一次只允许一个 FileOutputStream（或其他文件写入对象）打开文件进行写入。
    // 在这种情况下，如果所涉及的文件已经打开，则此类中的构造方法将失败。
    //FileOutputStream 用于写入诸如图像数据之类的原始字节的流。
    // 要写入字符流，请考虑使用 FileWriter。
    static FileOutputStream fileOutputStream;


    public static void main(String[] args) {
        outputStreamTrst();
        fileOutputStreamTest();


    }

    private static void fileOutputStreamTest() {
        /**
         * 构造方法摘要
         * FileOutputStream(File file)
         *           创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
         * FileOutputStream(File file, boolean append)
         *           创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
         * FileOutputStream(FileDescriptor fdObj)
         *           创建一个向指定文件描述符处写入数据的输出文件流，该文件描述符表示一个到文件系统中的某个实际文件的现有连接。
         * FileOutputStream(String name)
         *           创建一个向具有指定名称的文件中写入数据的输出文件流。
         * FileOutputStream(String name, boolean append)
         *           创建一个向具有指定 name 的文件中写入数据的输出文件流。
         */

        /**
         * 方法摘要
         *  void
         * close()
         *           关闭此文件输出流并释放与此流有关的所有系统资源。
         * protected  void
         * finalize()
         *           清理到文件的连接，并确保在不再引用此文件输出流时调用此流的 close 方法。
         *  FileChannel
         * getChannel()
         *           返回与此文件输出流有关的唯一 FileChannel 对象。
         *  FileDescriptor
         * getFD()
         *           返回与此流有关的文件描述符。
         *  void
         * write(byte[] b)
         *           将 b.length 个字节从指定 byte 数组写入此文件输出流中。
         *  void
         * write(byte[] b, int off, int len)
         *           将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。
         *  void
         * write(int b)
         *           将指定字节写入此文件输出流。
         */

    }

    private static void outputStreamTrst() {
        /**
         * void
         * close()
         *           关闭此输出流并释放与此流有关的所有系统资源。
         *  void
         * flush()
         *           刷新此输出流并强制写出所有缓冲的输出字节。
         *  void
         * write(byte[] b)
         *           将 b.length 个字节从指定的 byte 数组写入此输出流。
         *  void
         * write(byte[] b, int off, int len)
         *           将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。
         * abstract  void
         * write(int b)
         *           将指定的字节写入此输出流。
         */
    }
}

package IO;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.io.*;

/**
 *  print 就是打印流的方法
 *  System.out 就是一个打印流
 *
 *  特点：
 *      永远不会抛出IO一场
 *      特有方法 print println
 *      字节
 *
 *      PrintWriter -- 这才是字符打印流
 *
 *      继承关系 FilterOutputStream
 *
 *  PrintStream 为其他输出流添加了功能，
 *  使它们能够方便地打印各种数据值表示形式。
 *  它还提供其他两项功能。
 *  与其他输出流不同，PrintStream 永远不会抛出 IOException；而是，
 *  异常情况仅设置可通过 checkError 方法测试的内部标志。
 *  另外，为了自动刷新，可以创建一个 PrintStream；
 *  这意味着可在写入 byte 数组之后自动调用 flush 方法，
 *  可调用其中一个 println 方法，或写入一个换行符或字节 ('\n')。
 *
 * PrintStream 打印的所有字符都使用平台的默认字符编码转换为字节。
 * 在需要写入字符而不是写入字节的情况下，应该使用 PrintWriter 类。
 */
public class 打印流 {
    PrintStream printStream = System.out;

    public static void main(String[] args) throws FileNotFoundException {
//        test();
//        test2();
    }

    public static void test()throws FileNotFoundException{
        PrintStream printStream = new PrintStream(
                new FileOutputStream(new File("./text.txt"),true)
        );
        printStream.println(12);
        printStream.println("asd");
        printStream.println(new Person("ac",12));
        printStream.close();
    }

    public static void test2()throws FileNotFoundException{
        PrintStream printStream = new PrintStream(
                new FileOutputStream(new File("./text.txt"),true)
        );

        System.setOut(printStream);
        System.setErr(printStream);
        System.out.println("hahahaha");
    }
}

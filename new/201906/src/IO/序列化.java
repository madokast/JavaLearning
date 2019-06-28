package IO;

import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * 什么是序列化？
 * 把对象以流的方式保存到文件中 持久化？也叫做 写对象 对象的序列化
 * 需要使用字节流 ObjectOutputStream 中的 writeObject
 *
 * 反序列化
 * 使用 ObjectInputStream 对象的反序列化流
 * 使用 readObject 方法
 */

public class 序列化 {
    /**
     * ObjectOutputStream 将 Java 对象的基本数据类型和图形写入 OutputStream。
     * 可以使用 ObjectInputStream 读取（重构）对象。
     * 通过在流中使用文件可以实现对象的持久存储。
     * 如果流是网络套接字流，则可以在另一台主机上或另一个进程中重构对象。
     *
     * 只能将支持 java.io.Serializable 接口的对象写入流中。
     * 每个 serializable 对象的类都被编码，
     * 编码内容包括类名和类签名、对象的字段值和数组值，
     * 以及从初始对象中引用的其他所有对象的闭包。
     *
     * writeObject 方法用于将对象写入流中。
     * 所有对象（包括 String 和数组）都可以通过 writeObject 写入。
     * 可将多个对象或基元写入流中。
     * 必须使用与写入对象时相同的类型和顺序从相应 ObjectInputstream 中读回对象。
     *
     * 还可以使用 DataOutput 中的适当方法将基本数据类型写入流中。
     * 还可以使用 writeUTF 方法写入字符串。
     *
     * 对象的默认序列化机制写入的内容是：
     * 对象的类，类签名，以及非瞬态和非静态字段的值。
     * 其他对象的引用（瞬态和静态字段除外）也会导致写入那些对象。
     * 可使用引用共享机制对单个对象的多个引用进行编码，
     * 这样即可将对象的图形恢复为最初写入它们时的形状。
     */
    ObjectOutputStream objectOutputStream;

    /**
     * 此抽象类是表示输出字节流的所有类的超类。
     * 输出流接受输出字节并将这些字节发送到某个接收器。
     *
     * 需要定义 OutputStream 子类的应用程序必须始终提供至少一种可写入一个输出字节的方法。
     *
     * 子类
     * ByteArrayOutputStream,
     * FileOutputStream,
     * FilterOutputStream,
     * ObjectOutputStream,
     * OutputStream,
     * PipedOutputStream
     */
    ObjectOutput objectOutput;
    public static void main(String[] args) {
    }
}

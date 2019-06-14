package IO;

import java.io.*;
import java.util.Date;

public class WriterTest {
    static File file = new File("./a.txt");


    // * Abstract class for writing to character streams.  The only methods that a
    // * subclass must implement are write(char[], int, int), flush(), and close().
    // * Most subclasses, however, will override some of the methods defined here in
    // * order to provide higher efficiency, additional functionality, or both.

    //public abstract class Writer implements Appendable, Closeable, Flushable
//    static Writer writer;


//    static FileWriter fileWriter;//public class FileWriter extends OutputStreamWriter {


    //An OutputStreamWriter is a bridge from character streams to byte streams
//    static OutputStreamWriter outputStreamWriter;


    public static void main(String[] args) {

        try (FileWriter fileWriter = new FileWriter(file,true)){
            fileWriter.write("123");
//            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package IO;

import java.io.*;

public class OutputStreamWriteTest {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(new File("./text.txt"),true),"GBK");
        outputStreamWriter.write("你好");
        outputStreamWriter.flush();
        outputStreamWriter.close();


    }
}

package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
    public static void main(String[] args) throws Exception{
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File("./text.txt")), "UTF-8");
        int c;
        while ((c=inputStreamReader.read())!=-1){
            System.out.print((char)c);
        }
        inputStreamReader.close();

        System.out.println();

        inputStreamReader = new InputStreamReader(new FileInputStream(new File("./text.txt")), "GBK");
        while ((c=inputStreamReader.read())!=-1){
            System.out.print((char)c);
        }
        inputStreamReader.close();

        //你好你好���
        //浣犲ソ浣犲ソ你好
    }
}

package fileTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * File file and dir
 */
public class FileTest {
    public static void main(String[] args) {
//        test();
//        cons();
//        path();

//        allfile(new File("../"));

//        text2();
//        test3();
    }

    private static void test3() {
        File file = new File("a.txt");
        try {
            file.createNewFile();
        }catch (Exception e){e.printStackTrace();}
    }

    private static void text2() {
        Arrays.stream(File.listRoots()).forEach(System.out::println);// /

        Stream.generate(Math::random).limit(10).map(a->a+10).forEach(System.out::println);
        //10.39123368741896
        //10.537956422404491
        //10.871312668723169
        //10.756959169762757
        //10.288745362498089
        //10.423764090036315
        //10.48298354896855
        //10.709146875082192
        //10.377469665030226
        //10.044237774372426
    }

    private static void allfile(File file) {
        if(!file.exists()){
            System.out.println("no exist!");
            return;
        }

        Set<File> files = new HashSet<>();
        files.add(file);
        while(files.size()!=0){
            File tFile = files.iterator().next();
            files.remove(tFile);
            for (File listFile : tFile.listFiles()) {
                if(listFile.isFile())
                    try{System.out.println(listFile.getCanonicalFile()+" size:"+listFile.length());}catch (Exception e){e.printStackTrace();}
                if(listFile.isDirectory())
                    files.add(listFile);
            }
        }
    }

    private static void path() {
        File file = new File("./201906");
        System.out.println("file.exists() = " + file.exists());//file.exists() = true
        System.out.println("file.length() = " + file.length());//file.length() = 4096

        System.out.println("------------------");
        //./201906/201906.iml
        //./201906/src/fileTest/FileTest.java
    }

    private static void cons() {
        File file = new File("/data");
        System.out.println("file.getAbsoluteFile() = " + file.getAbsoluteFile());

        File file2 = new File("./data");
        System.out.println("file2.getAbsoluteFile() = " + file2.getAbsoluteFile());

        File file1 = new File("/home/madokast","../");
        System.out.println("file1.getAbsoluteFile() = " + file1.getAbsoluteFile());
        //file1.getAbsoluteFile() = /home/madokast/..

        File file3 = new File(file,"src/1.txt");
        System.out.println(file3.getAbsoluteFile());///data/src/1.txt
    }

    private static void test() {
        File file = new File(".");
        System.out.println(file.getAbsolutePath());
        ///home/madokast/Documents/JavaLearning/new/.

        //Linux
        System.out.println(File.pathSeparator);// 冒号:
        System.out.println(File.separator);// /

        //win File.pathSeparator == ; 分号
        //win File.separator == \ 反斜杠

        System.out.println("new File(\".\").getAbsolutePath() = " + new File(".").getAbsolutePath());
        System.out.println("new File(\".\").getAbsoluteFile() = " + new File(".").getAbsoluteFile());
        //new File(".").getAbsolutePath() = /home/madokast/Documents/JavaLearning/new/.
        //new File(".").getAbsoluteFile() = /home/madokast/Documents/JavaLearning/new/.
    }
}

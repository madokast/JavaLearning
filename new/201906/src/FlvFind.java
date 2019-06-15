import com.sun.source.tree.CompilationUnitTree;

import java.io.File;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

public class FlvFind {
    public static void main(String[] args)  {
        final File file = new File("D:\\Downloads\\uwpBILIBILI\\51633524");
        final Stack<File> stack = new Stack<>();
        stack.push(file);
        while (stack.size() != 0) {
            File t = stack.pop();
            File[] files = t.listFiles();
            Arrays.stream(files).forEach(f -> {
                if (f.isDirectory()) {
                    stack.push(f);
                } else {
                    if (f.toString().endsWith("flv")) {
                        try{
                            String s = f.getCanonicalPath();
                            String[] ss = s.split("_");
                            String number = ss[1];
                            switch (number.length()){
                                case 1:
                                    number = "00"+number;
                                    break;
                                case 2:
                                    number = "0"+ number;
                                    break;
                            }
                            String filename = number+".flv";

                            File newFile = new File("D:\\Downloads\\uwpBILIBILI\\51633524"+"\\"+filename);
                            System.out.println(newFile.getCanonicalPath());
                            f.renameTo(newFile);

//                            f.renameTo());
                        }catch (Exception e){e.printStackTrace();}
                    }
                }
            });
        }
    }
}

package trans;

import java.io.*;

public class ReadTransSigma {
    public static int lineNumber = 0;
    public static final int OFFSET = 0;

    public static void main(String[] args) {
        ReadFileByLine("D:\\app\\transport\\SIGMA.DAT");
    }

    public static void lineProcess(String line){
        //System.out.println("length:"+line.length()+"==="+line);

        lineNumber++;
        String st;
        switch (lineNumber%15+OFFSET){
            case 4://打印
                System.out.print(line.trim()/*去两端空白字符*/.split(" ")[0]+"  ");break;
            case 5: case 6:
            case 7: case 8:
                System.out.print(subProcess(line)+"  ");break;
            case 9:
                System.out.println();break;
        }

    }

    public static String subProcess(String st){
        st = st.trim();
        if(st.length()<6){
            System.out.println("处理结束？");
            throw new StringIndexOutOfBoundsException();
        }

        st = st.substring(5,st.length());
        return  st.trim().split(" ")[0];
    }

    public static void ReadFileByLine(String filename) {
        File file = new File(filename);
        InputStream is = null;
        Reader reader = null;
        BufferedReader bufferedReader = null;
        try {
            is = new FileInputStream(file);
            reader = new InputStreamReader(is);
            bufferedReader = new BufferedReader(reader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                lineProcess(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != bufferedReader)
                    bufferedReader.close();
                if (null != reader)
                    reader.close();
                if (null != is)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

//length:0===
//length:19===    11.186 m     B1
//length:21===     0.000  20.985 mm
//length:32===     0.000   7.480 MR     -0.986
//length:39===     0.000  20.919 mm      0.000  0.000
//length:46===     0.000   7.492 MR      0.000  0.000 -0.986
//length:53===     0.000   4.328 CM      0.002  0.006  0.000  0.000
//length:60===     0.000  20.000 %      -0.001 -0.006  0.000  0.000 -1.000
//length:19===      *TRANSFORM 1*
//length:62===     5.59887   1.00107   0.00000   0.00000   0.00000  -0.00150
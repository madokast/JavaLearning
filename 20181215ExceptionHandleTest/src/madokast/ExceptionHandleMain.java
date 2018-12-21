package madokast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionHandleMain {
    public static void test1()
    {
        Scanner sc = new Scanner(System.in);
        String input = null;
        String[] parseInput = null;
        int[] num = new int[2];
        while(sc.hasNext())
        {
            try {

                input = sc.nextLine();

                if(input.equals("exit"))
                {
                    break;
                }

                parseInput = input.split(",");
                num[0]=Integer.parseInt(parseInput[0]);
                num[1]=Integer.parseInt(parseInput[1]);
                System.out.println(parseInput[0]+"/"+parseInput[1]+" = "+num[0]/num[1]);
            }
            catch (IndexOutOfBoundsException|NumberFormatException|ArithmeticException alle)
            {
                System.out.println("JAVA7 catch more than one exception");
                //alle = new ArithmeticException();
                System.out.println(alle.getClass());

                alle.printStackTrace();
                //java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
                //	at madokast.ExceptionHandleMain.main(ExceptionHandleMain.java:24)

                //java.lang.NumberFormatException: For input string: "c"
                //	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
                //	at java.base/java.lang.Integer.parseInt(Integer.java:652)
                //	at java.base/java.lang.Integer.parseInt(Integer.java:770)
                //	at madokast.ExceptionHandleMain.main(ExceptionHandleMain.java:23)

                //java.lang.ArithmeticException: / by zero
                //	at madokast.ExceptionHandleMain.main(ExceptionHandleMain.java:25)

                System.out.println(alle.getMessage());
                //Index 1 out of bounds for length 1
                //For input string: "c"
                /// by zero


                continue;
            }
            /*
            catch (IndexOutOfBoundsException ie)
            {
                System.out.println("IndexOutOfBoundsException ie");
                continue;
            }
            catch (NumberFormatException ne)
            {
                System.out.println("NumberFormatException ne");
                continue;
            }
            catch (ArithmeticException ae)
            {
                System.out.println("ArithmeticException ae");
                continue;
            }
            */
            catch (Exception e)
            {
                System.out.println("unknown exception");
                continue;
            }
        }
        //1,2
        //1/2 = 0
        //8,4
        //8/4 = 2
        //3/0
        //NumberFormatException ne
        //3,0
        //ArithmeticException ae
        //1
        //IndexOutOfBoundsException ie
        //1,2,3
        //1/2 = 0
        //exit
        //
        //Process finished with exit code 0
    }

    public static void test2()
        throws IOException
    {
        FileInputStream fis = new FileInputStream("a.txt");
        //Exception in thread "main" java.io.FileNotFoundException: a.txt (系统找不到指定的文件。)
        //	at java.base/java.io.FileInputStream.open0(Native Method)
        //	at java.base/java.io.FileInputStream.open(FileInputStream.java:219)
        //	at java.base/java.io.FileInputStream.<init>(FileInputStream.java:157)
        //	at java.base/java.io.FileInputStream.<init>(FileInputStream.java:112)
        //	at madokast.ExceptionHandleMain.main(ExceptionHandleMain.java:100)
    }

    public static void test3(){
        File file = new File("./a.txt");

        if(file.exists())
        {
            //FileInputStream fis = new FileInputStream(file.getName());
        }


    }
    public static void test4(){
        try {
            test2();
        }
        catch (IOException ie)
        {
            System.out.println(ie.getMessage());
            //a.txt (系统找不到指定的文件。)
            System.out.println("123");
        }
    }

    public static void test5()
            throws ZeroException
    {
        int num;
        String enter;
        try {
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext())
            {
                enter=sc.nextLine();
                num=Integer.parseInt(enter);
                if(num==0)
                {
                    throw new Exception("your enter is 0");
                    //使用throw抛出異常
                }
            }
            }
        catch (NumberFormatException nf)
        {
            System.out.println(nf.getMessage());

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            //your enter is 0
            throw new ZeroException("0 Exception");
        }
    }

    public static void main(String[] args)
    {
        try {
            test5();
        }
        catch (ZeroException z)
        {
            System.out.println(z.getMessage());
            //0 Exception
        }
    }
}

class ZeroException extends RuntimeException
{
    public ZeroException(){}

    public ZeroException(String mag)
    {
        super(mag);
    }
}

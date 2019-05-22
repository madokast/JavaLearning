package tool;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.*;

public class Git {
    public static void main(String[] args) {
//        Shell shell = new Shell("/home/madokast/Documents/JavaLearning");
//        shell.exec("echo 123");
//        shell.close();

        //shellTest();
        shellProTest();
    }

    private static void shellProTest() {
        try {
            Process process = Runtime.getRuntime().exec("deepin-terminal");
            
            process.destroy();
        }catch (Exception e){e.printStackTrace();}
    }


    private static void shellTest() {
        String cmd = "pwd";//需要执行的指令
        File dir= new File("/home/madokast/Documents/JavaLearning");//工作目录

        Process process = null;
        StringBuilder result = new StringBuilder();
        BufferedReader bufIn = null;
        BufferedReader bufError = null;

        try{
            String[] command = {"/bin/sh","-c",cmd};
            process = Runtime.getRuntime().exec(command,null,dir);
            process.waitFor();//等待执行完成

            //输出流和错误输出流
            bufIn = new BufferedReader(
                    new InputStreamReader(
                            process.getInputStream(),"UTF-8"));
            bufError = new BufferedReader(
                    new InputStreamReader(
                            process.getErrorStream(),"UTF-8"));

            String line = null;
            while( (line=bufIn.readLine())!=null ){
                result.append(line).append('\n');
            }
            while( (line=bufError.readLine())!=null ){
                result.append(line).append('\n');
            }

            System.out.println(result.toString());
            result.delete(0,result.length());

            //--------------------------------------------
            System.out.println("process.isAlive() = " + process.isAlive());


            BufferedWriter printWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));


            printWriter.write("echo 123");
            printWriter.newLine();
            printWriter.flush();//写到shell
            process.waitFor();

            line = null;
            while( (line=bufIn.readLine())!=null ){
                result.append(line).append('\n');
            }
            while( (line=bufError.readLine())!=null ){
                result.append(line).append('\n');
            }

            System.out.println(result.toString());


        }catch (Exception e){
            System.out.println("----exception!----");
            e.printStackTrace();
        }finally {
            try {
                bufIn.close();
                bufError.close();
            }catch (Exception ee){ee.printStackTrace();}
        }

        if(process!=null){
            process.destroy();
        }
    }
}

package tool.GitXX;

import java.io.*;
import java.util.Scanner;

/**
 * git自动化工具
 * win10
 * Linux deepIn OS
 * Linux ubuntu 16.04
 * 测试成功
 *
 * the way to use it
 *      $ssh-keygen -t rsa -C "email@..."
 *      cosy .ssh/id_rsa.pub to github and set it
 *      then $git clone git...
 *      last $git config --global user.name "name"
 *      last $git config --global user.email "email@..."
 *      OK run it!
 *
 * @version 2019年5月23日
 */

public class Git {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入commit：");
        String commit = scanner.nextLine();

        String dir = "../";

        Shell shell = new Shell(dir);
        shell.exec("git add *");
        shell.exec("git commit -m "+'\''+commit+'\'');
        shell.exec("git push -u origin master");
        shell.exec("git pull origin");
    }

    /**
     * 以下都是测试用代码
     * 详细实现代码在 Shell 类中
     */
    private static void dirTest() {
        String dir = "../";
        File file = new File(dir);
        System.out.println(file.getAbsolutePath());
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
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

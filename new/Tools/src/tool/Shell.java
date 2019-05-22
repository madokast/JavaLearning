package tool;


import java.io.*;
import java.util.Objects;

public class Shell {
    private Process process = null;
    private String[] command = {"/bin/sh","-c","pwd"};
    private StringBuilder result = new StringBuilder();
    private String resultLine = null;
    private BufferedReader inInfo = null;
    private BufferedReader errorInfo = null;
    private PrintWriter outCmd = null;
    private boolean isSetup = false;

    /**
     * 创建shell服务进程
     * @param dir 输入shell工作目录，null表示和当前主进程目录相同
     */
    public Shell(String dir) {
        File file = null;
        if(dir!=null){
            file = new File(dir);
        }

        try{
            process = Runtime.getRuntime().exec(command,null,file);
            process.waitFor();//方法阻塞
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("shell进程创建失败");
            close();
        }

        if(process!=null){
            setupChannal();
            printInput();
        }
    }

    public void exec(String cmd) {
        outCmd.println(cmd);
        try {
            process.waitFor();
            printInput();
        }catch (Exception e){
            close();
            e.printStackTrace();
        }
    }

    /**
     * 关闭shell服务进程
     */
    public void close(){
        if(process!=null){
            process.destroy();
        }
        if(outCmd!=null){
            outCmd.close();
        }
        if(inInfo!=null){
            try {
                inInfo.close();
            }catch (Exception e){e.printStackTrace();}
        }
        if(errorInfo!=null){
            try {
                errorInfo.close();
            }catch (Exception e){e.printStackTrace();}
        }
        isSetup = false;

        System.out.println("成功关闭shell服务");
    }

    /**
     * 建立输入输出三个管道
     */
    private void setupChannal(){
        try{
            inInfo = new BufferedReader(new InputStreamReader(process.getInputStream(),"UTF-8"));
            errorInfo = new BufferedReader(new InputStreamReader(process.getErrorStream(),"UTF-8"));
        }catch (Exception e){
            System.out.println("管道建立失败");
            e.printStackTrace();
            close();
        }

        outCmd = new PrintWriter(process.getOutputStream());
    }

    /**
     * 打印输入管道的信息
     */
    private void printInput(){

        result.delete(0,result.length());//clear
        resultLine = null;


        try {
            while( (resultLine=inInfo.readLine())!=null ){
                result.append(resultLine).append('\n');
            }
            while( (resultLine=errorInfo.readLine())!=null ){
                result.append(resultLine).append('\n');
            }
        }catch (Exception e){
            e.printStackTrace();
            return;
        }

        if(result.length()!=0&&!isSetup){
            System.out.print("shell进程建立成功,");
            System.out.println("工作目录为:");
            isSetup = true;
        }
        System.out.println(result.toString());
        System.out.println();
    }
}

package linuxTool.myShell;


import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Shell {
    private Process process = null;
    private File file = null;
    private String[] command = null;
    private StringBuilder result = new StringBuilder();
    private String resultLine = null;
    private BufferedReader inInfo = null;
    private BufferedReader errorInfo = null;
    //private PrintWriter outCmd = null;
    private boolean isSetup = false;

    /**
     * 创建shell服务进程
     * @param dir 输入shell工作目录，null表示和当前主进程目录相同
     */
    public Shell(String dir) {
        if(dir!=null){
            file = new File(dir);
        }
    }

    public void exec(String cmd) {

        /**
         * 操作系统选择
         */
        if(System.getProperty("os.name").toLowerCase().startsWith("win")){
            execWin(cmd);
        }else {
            execLinux(cmd);
        }

        if(process!=null){
            setupChannal();
            printInput();
            close();
        }

        //System.out.println("---------------"+"执行结束"+"--------------\n\n");
    }

    /**
     * win
     * @param cmd
     */
    private void execWin(String cmd) {
        try{
            process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("win处理进程创建失败");
            close();
        }
    }

    /**
     * linux
     * @param cmd
     */
    private void execLinux(String cmd) {
//        System.out.println("开始执行："+cmd);
        command = new String[] {"/bin/sh","-c",cmd};

        try{
            process = Runtime.getRuntime().exec(command,null,file);
            process.waitFor();//方法阻塞 等待这个进程死亡
        } catch (Exception e){
            e.printStackTrace();
            System.err.println("shell进程创建失败");
            close();
        }
    }

    /**
     * 关闭shell服务进程
     */
    private void close(){
        if(process!=null){
            process.destroy();
        }
//        if(outCmd!=null){
//            outCmd.close();
//        }
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

        //System.out.println("成功关闭shell服务");
    }

    /**
     * 建立输入输出三个管道x
     * 仅仅输出2个
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

        //outCmd = new PrintWriter(process.getOutputStream());
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
            //System.out.print("shell进程建立成功,");
            //System.out.println("工作目录为:");
            isSetup = true;
        }
        System.out.println(result.toString());
        //System.out.println();
    }
}

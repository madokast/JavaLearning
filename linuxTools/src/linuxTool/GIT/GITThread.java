package linuxTool.GIT;

import linuxTool.Enviroment;
import linuxTool.GUItool.GUItools;
import linuxTool.myShell.Shell;
import linuxTool.tool.ThreadSleep;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * GIT提交线程
 * 感觉非常robust
 * 可以重启、可以被杀死
 *
 * 使用方法
 *      首先readyForTestArea，将窗口和文本框交过来
 *          文本框用于输出
 *          窗口用于任务完成后杀死
 *      然后sendCommitAndRun
 *          拿到commit 自动执行
 *      出现问题，kill杀死
 *          注意键盘事件需要写好一点
 *
 * 20190602
 */

public class GITThread extends Thread {
    private static String commit;
    private static TextArea textArea;
    private static JFrame jFrame;
    private static GITThread gitThread;

    public static void readyForTestArea(TextArea textArea,JFrame jFrame) {
        GITThread.textArea = textArea;
        GITThread.jFrame = jFrame;
    }

    public static void sendCommitAndRun(String commit) {
        GITThread.commit = commit;
        if (gitThread == null || gitThread.isDaemon()) {
            gitThread = new GITThread();
            gitThread.start();
        } else {
            textArea.append("GIT工具线程正在运行。Ctrl+c终止\n");
        }
    }

    public static void kill() {
        if (gitThread != null) {
            gitThread.stop();
            gitThread = null;
        }
    }


    private GITThread() {
    }

    @Override
    public void run() {
        GITThread.textArea.setEditable(false);

//        System.out.println("commit.length() = " + commit.length());

        if (GITThread.commit.length() == 0) {
            GITThread.textArea.append("无commit，拒绝执行\n");
            return;
        }

        GITThread.textArea.append("开始提交commit:"+commit+"\n");
        String dir = Enviroment.GIT_DIR;
        GITThread.textArea.append("库所在位置："+new File(dir).getAbsolutePath() +"\n");

        Shell shell = new Shell(dir,textArea);
        shell.exec("git add *");
        shell.exec("git commit -m "+'\''+commit+'\'');
        shell.exec("git push -u origin master");
        shell.exec("git pull origin");


        GITThread.textArea.append("提交任务完成，窗口即将关闭\n");
        ThreadSleep.sleep(Thread.currentThread(),2000);
        GITThread.jFrame.dispose();
//        GITThread.textArea.setEditable(true);
    }
}

package linuxTool.GIT;

import linuxTool.Enviroment;
import linuxTool.GUItool.GUItools;
import linuxTool.myShell.Shell;
import linuxTool.tool.ThreadSleep;

import javax.swing.*;
import java.awt.*;

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

        System.out.println("commit.length() = " + commit.length());

        if (GITThread.commit.length() == 0) {
            GITThread.textArea.append("无commit，拒绝执行\n");
            return;
        }

        GITThread.textArea.append("开始提交\n");
        String dir = "../";

        Shell shell = new Shell(Enviroment.GIT_DIR,textArea);
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

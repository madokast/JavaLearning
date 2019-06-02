package linuxTool.GIT;

import linuxTool.GUItool.GUItools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * GIT执行窗口
 * 代码需要大改
 *
 * 20190602
 */

public class GITWindows {
    private GITWindows(){}
    public static void GIT(){
        JFrame jFrame = new JFrame();
        final int width = 80;
        final int height = 40;
        String title = "---auto-git&hub for JavaLearning---";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ".repeat(/*(width-title.length())/2*/width/2+5)).append(title).append('\n');
        stringBuilder.append("commit:\n").append("今天也是充实的一天呢～\n");


        TextArea textArea = new TextArea(stringBuilder.toString(),height,width,TextArea.SCROLLBARS_NONE){
            public void println(String s){this.append(s);}
        };
        GITThread.readyForTestArea(textArea,jFrame);
//        textArea.setEditable(false);
        textArea.setCaretPosition(textArea.getText().length());
//        System.out.println("123");
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
//                System.out.println("e = " + String.format("%d",(int)e.getKeyChar()));

                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                    String commit = textArea.getText().split("\n")[textArea.getText().split("\n").length-1];
                    GITThread.sendCommitAndRun(commit);
                }

                /**
                 * ctrl+C终止GIT提交线程，同时关闭窗口，结束一切
                 * 同样是今日最佳
                 *
                 * 20190602
                 */
                if((int)e.getKeyChar()==3){
//                    System.out.println("收到停止命令");
                    GITThread.kill();
                    jFrame.dispose();
                }
            }
        });


//        TextField textField = new TextField(width);
//        textArea.setBackground(new Color(0,0,0,0));
        jFrame.add(textArea,BorderLayout.CENTER);
//        jFrame.add(textField,BorderLayout.SOUTH);
        jFrame.setUndecorated(true);
//        jFrame.setBackground(new Color(0,255,0,128));
        jFrame.pack();
        GUItools.frameCenter(jFrame);
        jFrame.setVisible(true);
    }
}

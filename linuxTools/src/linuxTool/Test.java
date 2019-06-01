package linuxTool;

import linuxTool.GUItool.GUItools;
import linuxTool.myShell.Shell;
import linuxTool.tool.StringTool;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Test {
    public static void main(String[] args) {

        transparent();
//        Shell shell = new Shell(null);
//        shell.exec("firefox");

//        System.out.println("StringTool.isCloseWithDoubleQuotation(\"123\") = " + StringTool.isCloseWithDoubleQuotation("123"));
//        System.out.println("StringTool.isCloseWithDoubleQuotation(\"\\\"123\\\"\") = " + StringTool.isCloseWithDoubleQuotation("\"123\""));
//        System.out.println("StringTool.removeDoubleQuotation(\"123\") = " + StringTool.removeDoubleQuotation("123"));
//        System.out.println("StringTool.removeDoubleQuotation(\"\\\"123\\\"\") = " + StringTool.removeDoubleQuotation("\"123\""));
    }

    private static void transparent(){
        JFrame jFrame = new JFrame() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                Graphics2D g2 = (Graphics2D) g;
                try {
                    BufferedImage imageIcon = ImageIO.read(
                            new File("/home/madokast/Documents/JavaLearning/linuxTools/image/splash.png"));
//                ImageIcon imageIcon = new ImageIcon("/home/madokast/Documents/JavaLearning/linuxTools/image/splash.png");
                    g2.drawImage(imageIcon, 0, 0, 300, 300, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        jFrame.setUndecorated(true);
        jFrame.setBackground(new Color(0,0,0,0));
        jFrame.setBounds(200,200,300,300);
        GUItools.frameCenter(jFrame);

        jFrame.setVisible(true);
    }
}


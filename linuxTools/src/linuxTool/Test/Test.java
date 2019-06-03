package linuxTool.Test;

import linuxTool.GIT.GITThread;
import linuxTool.GUItool.GUItools;
import linuxTool.GUItool.MyCanvas;
import linuxTool.myShell.Shell;
import linuxTool.tool.StringTool;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class Test {
    public static void main(String[] args) {

//        transparent();
//        GIT();
//        synchronized (Test.class) {
//            System.out.println("123");
//            try {
//                Test.class.wait();
//            } catch (Exception x) {
//            }
//            System.out.println("456");
//        }

//                for (String availableFontFamilyName : GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()) {
//                    System.out.println(availableFontFamilyName);
//                }

        windowsTest();

    }

    private static int oldX = -1;
    private static int oldY = -1;
    private static int jFrameNewLocalX;
    private static int jFrameNewLocalY;
    private static int moveX;
    private static int moveY;

    private static void windowsTest() {
        JFrame jFrame = new JFrame();
        MyCanvas myCanvas = new MyCanvas();
        BufferedImage bufferedImage = getImage();

        myCanvas.getImageAndPrintIt(bufferedImage);
        jFrame.add(myCanvas, BorderLayout.CENTER);

        myCanvas.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }

            long lastClick = 0L;
            long currentClick;
            @Override
            public void mouseClicked(MouseEvent e){
                currentClick = e.getWhen();
                if(currentClick-lastClick<500){
                    jFrame.dispose();
                }else {
                    lastClick = currentClick;
                }
            }

        });

        myCanvas.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {

                moveX = e.getX() - oldX;
                moveY = e.getY() - oldY;

//                oldX = e.getX();
//                oldY = e.getY();

                jFrameNewLocalX = jFrame.getX() + moveX;
                jFrameNewLocalY = jFrame.getY() + moveY;

                jFrame.setLocation(jFrameNewLocalX, jFrameNewLocalY);


            }
        });

        jFrame.setBounds(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
        GUItools.frameCenter(jFrame);

        jFrame.setVisible(true);
    }


    public static void GIT() {
        JFrame jFrame = new JFrame();
        final int width = 80;
        final int height = 40;
        String title = "---auto-git&hub for JavaLearning---";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ".repeat(/*(width-title.length())/2*/width / 2 + 5)).append(title).append('\n');
        stringBuilder.append("commit:\n").append("今天也是充实的一天呢～");


        TextArea textArea = new TextArea(stringBuilder.toString(), height, width, TextArea.SCROLLBARS_NONE) {
            public void println(String s) {
                this.append(s);
            }
        };
        GITThread.readyForTestArea(textArea, jFrame);
//        textArea.setEditable(false);
        textArea.setCaretPosition(textArea.getText().length());
        System.out.println("123");
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
//                System.out.println("e = " + String.format("%d",(int)e.getKeyChar()));

                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    String commit = textArea.getText().split("\n")[textArea.getText().split("\n").length - 1];
                    GITThread.sendCommitAndRun(commit);
                }

                //ctrl+c
                if ((int) e.getKeyChar() == 3) {
//                    System.out.println("收到停止命令");
                    GITThread.kill();
                    jFrame.dispose();
                }
            }
        });


//        TextField textField = new TextField(width);
//        textArea.setBackground(new Color(0,0,0,0));
        jFrame.add(textArea, BorderLayout.CENTER);
//        jFrame.add(textField,BorderLayout.SOUTH);
        jFrame.setUndecorated(true);
//        jFrame.setBackground(new Color(0,255,0,128));
        jFrame.pack();
        GUItools.frameCenter(jFrame);
        jFrame.setVisible(true);
    }

    //        for (String availableFontFamilyName : GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()) {
//            System.out.println(availableFontFamilyName);
//        }


//        Shell shell = new Shell(null);
//        shell.exec("firefox");

//        System.out.println("StringTool.isCloseWithDoubleQuotation(\"123\") = " + StringTool.isCloseWithDoubleQuotation("123"));
//        System.out.println("StringTool.isCloseWithDoubleQuotation(\"\\\"123\\\"\") = " + StringTool.isCloseWithDoubleQuotation("\"123\""));
//        System.out.println("StringTool.removeDoubleQuotation(\"123\") = " + StringTool.removeDoubleQuotation("123"));
//        System.out.println("StringTool.removeDoubleQuotation(\"\\\"123\\\"\") = " + StringTool.removeDoubleQuotation("\"123\""));

    private static BufferedImage imageWord() {
        int width = GUItools.getScreenWidth() / 2;
        int height = GUItools.getScreenHeight() / 8;
        String string = "さくら もゆ";

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(new Color(200, 120, 18));
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(Color.black);

//        Font font = new Font(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()[1],Font.BOLD,40);
        Font font = new Font(/*"AR PL UKai CN"*/"Noto Serif CJK JP", Font.PLAIN, 50);

        FontMetrics fontMetrics = graphics.getFontMetrics(font);
        int x = (width - fontMetrics.stringWidth(string)) / 2;
        int y = (height - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent();
        graphics.setFont(font);
        graphics.setColor(Color.pink);
        graphics.drawString(string, x, y);

        return bufferedImage;
    }

    private static void transparent() {
//        BufferedImage bufferedImage = opaque(getImage());
//        BufferedImage bufferedImage = opaque(getImage());
        BufferedImage bufferedImage = imageWord();
//        try{
//            ImageIO.write(bufferedImage,"png",new File("/home/madokast/Documents/JavaLearning/linuxTools/image/kuronew.png"));
//        }catch (Exception e){}


        JFrame jFrame = new JFrame() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                Graphics2D g2 = (Graphics2D) g;
//                g2.drawImage(backImage,0,0,backImage.getWidth(),backImage.getHeight(),null);
                g2.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);

            }
        };

        jFrame.setUndecorated(true);
        jFrame.setBackground(new Color(0, 0, 0, 0));
        jFrame.setBounds(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
//        jFrame.pack();
        GUItools.frameCenter(jFrame);
        jFrame.repaint();


        jFrame.setVisible(true);
    }

    private static BufferedImage getImage() {
        try {
            BufferedImage imageIcon = ImageIO.read(
                    new File("/home/madokast/Documents/JavaLearning/linuxTools/image/kuro2.png"));
            return imageIcon;
        } catch (Exception e) {
            BufferedImage bufferedImage = new BufferedImage(GUItools.getScreenWidth() / 2, GUItools.getScreenHeight() / 8, TYPE_INT_RGB);
            Graphics graphics = bufferedImage.getGraphics();
            graphics.setColor(Color.RED);
            graphics.fillRect(0, 0, GUItools.getScreenWidth() / 2, GUItools.getScreenHeight() / 8);
            return bufferedImage;
        }
    }

    private static BufferedImage opaque(BufferedImage source) {
        BufferedImage bufferedImage = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = bufferedImage.getGraphics();
//        System.out.println("des.getRGB(0,0) = " + String.format("%x",source.getRGB(0, 0)));

        for (int i = source.getMinX(); i < source.getWidth(); i++) {
            for (int j = source.getMinY(); j < source.getHeight(); j++) {
                int rgb = source.getRGB(i, j);

                if ((rgb >> 24) == 0) {
                    graphics.setColor(new Color(0, 0, 0, 0));
                    graphics.drawLine(i, j, i, j);
                } else {
                    graphics.setColor(new Color(rgb | 0xff000000));
                    graphics.drawLine(i, j, i, j);
                }
            }
        }

//        System.out.println("des.getRGB(0,0) = " + String.format("%x",source.getRGB(0, 0)));

        return bufferedImage;
    }
}


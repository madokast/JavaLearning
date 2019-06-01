package linuxTool.GUItool;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Splash {
//    private static Splash splash = new Splash();
//    private static Splash getInstance()
//    {
//        if(splash==null)
//            splash = new Splash();
//
//        return splash;
//    }

//    private static int width;
//    private static int height;

//    private Image splashImage;

//    private MyCanvas myCanvas;

//    private static String imageDirection;
//    private static BufferedImage bufferedImage;
//    private BufferedImage bufferedImage;


//    private Splash()
//    {
//        int width, height;
//
//        try{
//            bufferedImage = ImageIO.read(new File(imageDirection));
//            width = bufferedImage.getWidth();
//            height = bufferedImage.getHeight();
//            Graphics2D graphics2D = (Graphics2D)this.getGraphics();
//            graphics2D.drawImage(bufferedImage,0,0,width,height,null);
////            myCanvas.setSize(width,height);
////            myCanvas.setBackground(new Color(0,0,0,0));
////            myCanvas.getImageAndPrintIt(bufferedImage);
//            this.setBounds(0,0,width,height);
//            this.setBackground(new Color(0,0,0,0));
//        }catch (Exception e){
//            e.printStackTrace();
//            if(imageDirection == null){
//                System.err.println("警告：图片地址参数为空，显示空白图");
//            }else {
//                System.err.println("警告：图片载入失败，显示空白图");
//            }
//            width = GUItools.getScreenWidth()/2;
//            height = GUItools.getScreenHeight()/8;
////            myCanvas.setSize(width,height);
////            myCanvas.setBackground(Color.pink);
//            this.setBounds(0,0,width,height);
//        }finally {
////            this.add(myCanvas,BorderLayout.CENTER);
//            this.setUndecorated(true);
//            this.setAlwaysOnTop(true);
//            this.pack();
//            GUItools.frameCenter(this);
//        }

//        this.setUndecorated(true);
//        this.setBackground(new Color(0,0,0,0));//设置透明
//        this.setAlwaysOnTop(true);
//    }

//    public void paint(Graphics g) {
//        super.paint(g);
//        Graphics2D graphics2D = (Graphics2D)g;
//        graphics2D.drawImage(Splash.bufferedImage,0,0,Splash.width,Splash.height,null);

//        try{
//            graphics2D.drawImage(bufferedImage,0,0,width,height,null);
//        }catch (Exception e){
////            if(imageDirection == null){
////                System.err.println("警告：图片地址参数为空，显示空白图");
////            }else {
////                System.err.println("警告：图片载入失败，显示空白图");
////            }
////            myCanvas = new MyCanvas();
////            width = GUItools.getScreenWidth()/2;
////            height = GUItools.getScreenHeight()/8;
////            myCanvas.setSize(width,height);
////            myCanvas.setBackground(Color.pink);
//            width = GUItools.getScreenWidth()/2;
//            height = GUItools.getScreenHeight()/8;
//            graphics2D.setColor(Color.pink);
//            graphics2D.drawRect(0,0,width,height);
//        }


//        ImageIcon imageIcon = new ImageIcon("/home/madokast/Documents/JavaLearning/linuxTools/image/splash.png");
//        graphics2D.drawImage(imageIcon.getImage(), 0, 0, imageIcon.getIconWidth() ,imageIcon.getIconHeight(),null);

//    }





    public static void exhibit(String imageDir,int duration) {
//        JFrame jFrame;
        try{
            final BufferedImage bufferedImage = ImageIO.read(new File(imageDir));
            final int width = bufferedImage.getWidth();
            final int height = bufferedImage.getHeight();

            final JFrame jFrame = new JFrame() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    Graphics2D g2 = (Graphics2D) g;
                    try {
                        BufferedImage imageIcon = ImageIO.read(new File(imageDir));
//                ImageIcon imageIcon = new ImageIcon("/home/madokast/Documents/JavaLearning/linuxTools/image/splash.png");
                        g2.drawImage(imageIcon, 0, 0, width, height, null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            jFrame.setUndecorated(true);
            jFrame.setBackground(new Color(0,0,0,0));
//            jFrame.setBackground(Color.pink);
            jFrame.setBounds(0,0,width,height);
            GUItools.frameCenter(jFrame);


            new Thread(()->{jFrame.setVisible(true);
                try {
                    Thread.currentThread().sleep(duration);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
                jFrame.dispose();}).start();

            int i = 100;
            while(--i<0){
                try {
                    jFrame.repaint(10);
                    Thread.currentThread().sleep(duration/100);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }

        }catch (Exception e){
            if(imageDir == null){
                System.err.println("警告：图片地址参数为空，显示空白图");
            }else {
                System.err.println("警告：图片载入失败，显示空白图");
            }
            final int width = GUItools.getScreenWidth()/2;
            final int height = GUItools.getScreenHeight()/8;

            MyCanvas myCanvas = new MyCanvas();
            myCanvas.setSize(width,height);
            myCanvas.setBackground(Color.pink);

            final JFrame jFrame = new JFrame();
            jFrame.setUndecorated(true);
            jFrame.setBounds(0,0,width,height);
            jFrame.add(myCanvas,BorderLayout.CENTER);
            GUItools.frameCenter(jFrame);

            jFrame.setVisible(true);
            try {
                Thread.currentThread().sleep(duration);
            } catch (Exception ee) {
                ee.printStackTrace();
            }
            jFrame.dispose();
        }





//            JFrame jFrame = new JFrame() {
//                @Override
//                public void paint(Graphics g) {
//                    super.paint(g);
//                    Graphics2D g2 = (Graphics2D) g;
//                    BufferedImage imageIcon = ImageIO.read(new File(imageDir));
//                    g2.drawImage(imageIcon, 0, 0, 300, 300, null);
//                }
//            };
//
//            jFrame.setUndecorated(true);
//            jFrame.setBackground(new Color(0,0,0,0));
//            jFrame.setBounds(0,0,300,300);
//            GUItools.frameCenter(jFrame);
//
//            jFrame.setVisible(true);
//
//
//
//
//
//
//
//
//
//
//
//        JFrame jFrame = new JFrame() {
//            @Override
//            public void paint(Graphics g) {
//                super.paint(g);
//                Graphics2D g2 = (Graphics2D) g;
//                try {
//                    final BufferedImage bufferedImage = ImageIO.read(new File(imageDir));
//                    final int width = bufferedImage.getWidth();
//                    final int height = bufferedImage.getHeight();
//                    g2.drawImage(bufferedImage, 0, 0, width, height, null);
//                    this.setUndecorated(true);
//                    this.setBackground(new Color(0,0,0,0));
//                    this.setBounds(0,0,width,height);
//                } catch (Exception e) {
//                    if(imageDir == null){
//                        System.err.println("警告：图片地址参数为空，显示空白图");
//                    }else {
//                        System.err.println("警告：图片载入失败，显示空白图");
//                    }
//                    final int width = GUItools.getScreenWidth()/2;
//                    final int height = GUItools.getScreenHeight()/8;
//
//                    g2.setColor(Color.pink);
//                    g2.setBackground(Color.pink);
//                    g2.drawRect(0,0,width,height);
//                    this.setBounds(0,0,width,height);
//                    this.setUndecorated(true);
//                }finally {
//                    GUItools.frameCenter(this);
//                }
//            }
//        };
//
////        jFrame.setUndecorated(true);
////        jFrame.setBackground(new Color(0,0,0,0));
//////        jFrame.setBounds(0,0,300,300);
////        jFrame.pack();
//
//        jFrame.setVisible(true);
//
//        try {
//            Thread.currentThread().sleep(duration);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        jFrame.dispose();




//        imageDirection = imageDir;
//        JFrame splash;
//        try{
//            BufferedImage bufferedImage = ImageIO.read(new File(imageDirection));
//            width = bufferedImage.getWidth();
//            height = bufferedImage.getHeight();
//
//            splash = new Splash();
//            splash.setUndecorated(true);
//            splash.setBackground(new Color(0, 0, 0, 0));
//            splash.setBounds(0, 0, width, height);
//            GUItools.frameCenter(splash);
////            System.out.println("try");
//        }catch (Exception e){
//            //e.printStackTrace();
//            if(imageDirection == null){
//                System.err.println("警告：图片地址参数为空，显示空白图");
//            }else {
//                System.err.println("警告：图片载入失败，显示空白图");
//            }
//            width = GUItools.getScreenWidth()/2;
//            height = GUItools.getScreenHeight()/8;
//
//            splash = new JFrame();
//            splash.setUndecorated(true);
//            splash.setBackground(Color.pink);
//            splash.setBounds(0, 0, width, height);
//            GUItools.frameCenter(splash);
////            System.out.println("catch");
//        }


//        splash.setBounds(0, 0, width, height);
//        GUItools.frameCenter(splash);
//        splash.repaint();


//        splash.setVisible(true);
//        try {
//            Thread.currentThread().sleep(duration);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        splash.dispose();
    }

//    private static void exhibt(){
//        splash.setVisible(true);
//    }
//
//    private static void close()
//    {
//        splash.dispose();
//
//    }

}

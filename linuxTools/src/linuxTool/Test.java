package linuxTool;

import linuxTool.GUItool.GUItools;
import linuxTool.myShell.Shell;
import linuxTool.tool.StringTool;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

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
//        BufferedImage bufferedImage = opaque(getImage());
        BufferedImage bufferedImage = getImage();
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
        jFrame.setBackground(new Color(0,0,0,0));
        jFrame.setBounds(0,0,bufferedImage.getWidth(),bufferedImage.getHeight());
//        jFrame.pack();
        GUItools.frameCenter(jFrame);
        jFrame.repaint();


        jFrame.setVisible(true);
    }

    private static BufferedImage getImage(){
        try{
            BufferedImage imageIcon = ImageIO.read(
                    new File("/home/madokast/Documents/JavaLearning/linuxTools/image/kuronew.png"));
            return imageIcon;
        }catch (Exception e){
            BufferedImage bufferedImage = new BufferedImage(GUItools.getScreenWidth()/2,GUItools.getScreenHeight()/8,TYPE_INT_RGB);
            Graphics graphics = bufferedImage.getGraphics();
            graphics.setColor(Color.RED);
            graphics.fillRect(0,0,GUItools.getScreenWidth()/2,GUItools.getScreenHeight()/8);
            return bufferedImage;
        }
    }

    private static BufferedImage opaque(BufferedImage source){
        BufferedImage bufferedImage = new BufferedImage(source.getWidth(),source.getHeight(),BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = bufferedImage.getGraphics();
//        System.out.println("des.getRGB(0,0) = " + String.format("%x",source.getRGB(0, 0)));

        for (int i = source.getMinX(); i < source.getWidth(); i++) {
            for (int j = source.getMinY(); j < source.getHeight(); j++) {
                int rgb = source.getRGB(i,j);

                if((rgb>>24)==0){
                    graphics.setColor(new Color(0,0,0,0));
                    graphics.drawLine(i,j,i,j);
                }else {
                    graphics.setColor(new Color(rgb|0xff000000));
                    graphics.drawLine(i,j,i,j);
                }
            }
        }

//        System.out.println("des.getRGB(0,0) = " + String.format("%x",source.getRGB(0, 0)));

        return bufferedImage;
    }
}


package linuxTool.GUItool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImagePreloading{
    private static final String PRELOAD_IMAGE_DIR = "/home/madokast/Documents/JavaLearning/linuxTools/image/kuro.png";
    public static final String IMAGE = "kuro.png";

    private static BufferedImage bufferedImage = null;

    public static void preload(){
        BufferedImage source;

        try{
            source = ImageIO.read(new File(PRELOAD_IMAGE_DIR));
        }catch (Exception e){
            System.err.println("错误：图片预载入失败！");
            source = new BufferedImage(0,0,1);
        }

        BufferedImage bufferedImage = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = bufferedImage.getGraphics();

        for (int i = source.getMinX(); i < source.getWidth(); i++) {
            for (int j = source.getMinY(); j < source.getHeight(); j++) {
                int rgb = source.getRGB(i, j);

                if ((rgb >> 24) == 0) {
                    graphics.setColor(new Color(00, 0, 0, 0));
                    graphics.drawLine(i, j, i, j);
                } else {
                    graphics.setColor(new Color(rgb | 0xff000000));
                    graphics.drawLine(i, j, i, j);
                }
            }
        }

        try{ImagePreloading.class.notify();}catch (Exception e){}
        ImagePreloading.bufferedImage = bufferedImage;
    }

    public static boolean isPreloaded(){
        return bufferedImage!=null;
    }

    public static BufferedImage getPreloadImage(){
        return bufferedImage;
    }
}

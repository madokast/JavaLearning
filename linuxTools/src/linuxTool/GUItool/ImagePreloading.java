package linuxTool.GUItool;

import linuxTool.Enviroment;
import linuxTool.tool.ThreadSleep;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public class ImagePreloading{
//    private static final String PRELOAD_IMAGE_DIR = "/home/madokast/Documents/JavaLearning/linuxTools/image/kuro.png";
//    public static final String IMAGE = "kuro.png";

    private static BufferedImage bufferedImage = null;
    private static boolean preloaded = false;

    public static void preload(){
//        System.out.println("执行预载入");
        BufferedImage source;

        try{
            source = ImageIO.read(new File(Enviroment.PRELOAD_IMAGE_DIR));
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

//        System.out.println("其实已经完工了。可是我如果偷懒了呢？");
//        ThreadSleep.sleep(Thread.currentThread(),5000);

        synchronized (ImagePreloading.class) {
            ImagePreloading.bufferedImage = bufferedImage;
            preloaded = true;
//            System.out.println("预载入成功，开始唤醒");
            try {
                ImagePreloading.class.notify();
            } catch (Exception e) {
            }
        }

    }

    public static boolean isPreloaded() {
        return preloaded;
    }

    public static BufferedImage getBufferedImage() {
        return bufferedImage;
    }
}

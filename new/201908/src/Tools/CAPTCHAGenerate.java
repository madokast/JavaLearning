package Tools;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CAPTCHAGenerate {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public CAPTCHAGenerate(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public ImgAndInfo getCAPTCHA(){
        System.out.println("getCAPTCHA 1223");

        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics graphics = bufferedImage.getGraphics();

        graphics.setColor(Color.pink);
        graphics.fillRect(0,0,width,height);

        graphics.setColor(Color.BLUE);
        graphics.drawRect(0,0,width-1,height-1);

        String captche = ""+randomOne()+randomOne()+randomOne()+randomOne();

        graphics.setFont(new Font(null,Font.PLAIN,30));
        graphics.drawString(captche,width/3,height/2);

        graphics.setColor(Color.green);
        for (int i = 0; i < 10; i++) {
            int x1 = new Random().nextInt(width);
            int x2 = new Random().nextInt(width);
            int y1 = new Random().nextInt(height);
            int y2 = new Random().nextInt(height);

            graphics.drawLine(x1,y1,x2,y2);
        }


        return new ImgAndInfo(bufferedImage,captche);
    }

    private char randomOne(){
        String src = "QWERTYUIOPASDFGHJKLZXCVBNM123456789qwertyuiopasdfghjklzxcvbnm";
        final Random random = new Random();
        final int i = random.nextInt(src.length());

        return src.charAt(i);
    }

    public BufferedImage getBlankImg(Color color){
        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        final Graphics graphics = bufferedImage.getGraphics();

        graphics.setColor(color);
        graphics.fillRect(0,0,bufferedImage.getWidth(),bufferedImage.getHeight());

        return bufferedImage;
    }


    public CAPTCHAGenerate() {
    }

    public static void main(String[] args) {
        final BufferedImage blankImg = new CAPTCHAGenerate(200, 100).getBlankImg(Color.BLUE);
    }

    public class ImgAndInfo{
        private BufferedImage img;
        private String info;

        public ImgAndInfo() {
        }

        public ImgAndInfo(BufferedImage img, String info) {
            this.img = img;
            this.info = info;
        }

        public BufferedImage getImg() {
            return img;
        }

        public String getInfo() {
            return info;
        }

        public void setImg(BufferedImage img) {
            this.img = img;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }
}

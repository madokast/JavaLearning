import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageIOMain {
    private Frame f= new Frame("rendImage");
    private BufferedImage image;
    private Graphics g;
    private Canvas c = new Canvas(){
        public void paint(Graphics g){
          g.drawImage(image,0,0,100,100,null);
      }
    };


    private void ini() throws IOException {
        image = ImageIO.read(new File("D:\\Documents\\JAVAlearning\\test.PNG"));
        g=image.getGraphics();
        c.setPreferredSize(new Dimension(300,300));
        c.paint(g);
        f.add(c);
        f.pack();
        f.setVisible(true);

    }

    public static void main(String[] args) throws IOException {
        new ImageIOMain().ini();
    }
}

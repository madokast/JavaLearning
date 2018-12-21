package madokast;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawCircleMain {
    private double x=-1;
    private double px=-1;
    private double y=-1;
    private double py=-1;
    private double w=0;
    private final int CANVAS_WIDTH = 300;
    private final int CANVAS_HIGHTH = 300;
    private double r = 100;

    private Frame f = new Frame("DrawCircle");

    private BufferedImage bi = new BufferedImage(CANVAS_WIDTH,CANVAS_HIGHTH,BufferedImage.TYPE_INT_RGB);
    private Graphics g = bi.getGraphics();
    private CircleDrawCanvas cdc = new CircleDrawCanvas(bi);

    private Timer timer = new Timer(10,e->
    {
        px=x;
        py=y;

        x=Math.sin(w)*r+CANVAS_WIDTH/2;
        y=Math.cos(w)*r+CANVAS_HIGHTH/2;
        w+=Math.PI/1800;
        r=100*(1-w/(4*Math.PI));

        if(px>0&&py>0&&x>0&&y>0){
            g.setColor(new Color(0x000000));
            g.drawLine((int)px,(int)py,(int)x,(int)y);
        }

        cdc.repaint();


    });

    public void ini(){
        cdc.setPreferredSize(new Dimension(CANVAS_WIDTH,CANVAS_HIGHTH));

        g.fillRect(0,0,CANVAS_WIDTH,CANVAS_HIGHTH);

        f.add(cdc,BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);

        timer.start();
    }

    public static void main(String[] args) {
        new DrawCircleMain().ini();

    }

}

class CircleDrawCanvas extends Canvas{
    private Image image;
    public CircleDrawCanvas(Image image){
        this.image=image;
    }

    public void paint(Graphics g){
        g.drawImage(image, 0, 0, null);
    }
}

package madokast;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRenderedImage;

public class AWT6 {
    //用于保存颜色
    private Color foreColor = new Color(255,0,0);

    //鼠标位置
    private int preX = -1;
    private int preY = -1;

    public void handDraw(){
        Frame f = new Frame("hand draw");

        //画图区域大小
        final int AREA_WIDTH = 500;
        final int AREA_HEIGHT = 400;


        //右键菜单 选择画笔颜色
        PopupMenu pop = new PopupMenu();
        MenuItem redItem = new MenuItem("red");
        MenuItem greenItem = new MenuItem("green");
        MenuItem blueItem = new MenuItem("blue");


        //BufferedImage类 构造器 画布大小 image类型
        BufferedImage image = new BufferedImage(AREA_WIDTH,AREA_HEIGHT,BufferedImage.TYPE_INT_RGB);

        //从 BufferedImage 的 image 得到 graphics
        Graphics g = image.getGraphics();

        Canvas drawArea = new Canvas(){
            public void paint(Graphics g) {
                g.drawImage(image,0,0,null);
            }
        };

        ActionListener menuListener = e->{
          if(e.getActionCommand().equals("green"))
              foreColor = new Color(0,255,0);
          if(e.getActionCommand().equals("red"))
              foreColor = new Color(255,0,0);
          if(e.getActionCommand().equals("blue"))
              foreColor = new Color(0,0,255);
        };

        redItem.addActionListener(menuListener);
        greenItem.addActionListener(menuListener);
        blueItem.addActionListener(menuListener);

        pop.add(redItem);
        pop.add(greenItem);
        pop.add(blueItem);

        drawArea.add(pop);


        g.fillRect(0,0,AREA_WIDTH,AREA_HEIGHT);

        drawArea.setPreferredSize(new Dimension(AREA_WIDTH,AREA_HEIGHT));

        //鼠标移动监听器
        drawArea.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(preX>0&&preY>0){
                    g.setColor(foreColor);
                    g.drawLine(preX,preY,e.getX(),e.getY());
                }
                preX=e.getX();
                preY=e.getY();

                drawArea.repaint();
            }
        });

        drawArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.isPopupTrigger())
                {
                    pop.show(drawArea,e.getX(),e.getY());
                }
                preX=-1;
                preY=-1;

            }
        });

        f.add(drawArea);
        f.pack();
        f.setVisible(true);
    }



    public static void main(String[] args) {
        if(false)
            new AWT6().handDraw();

        String[] read = ImageIO.getReaderFormatNames();
        String[] write = ImageIO.getWriterFormatNames();
        for(String t:read)
            System.out.print(t+"\t");
        //JPG	jpg	tiff	bmp	BMP	gif	GIF	WBMP	png	PNG	JPEG	tif	TIF	TIFF	jpeg	wbmp

        System.out.printf("\n");
        for(String t:write)
            System.out.print(t+"\t");
        //JPG	jpg	tiff	bmp	BMP	gif	GIF	WBMP	png	PNG	JPEG	tif	TIF	TIFF	wbmp	jpeg
    }
}

package madokast;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class WindowFrame extends Frame {
    private static WindowFrame windowFrame;
    public static WindowFrame getInstance()
    {
        if(windowFrame==null)
        {
            windowFrame=new WindowFrame();
        }
        return windowFrame;
    }

    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 600;

    private WindowFrame()
    {
        this.setTitle("Timer V0.1");
        try {
            this.setIconImage(ImageIO.read(new File("20181219Timer/image/icon.JPG")));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        this.setMenuBar(MyMenuBar.getInstance());

        this.add(TextAreaPanel.getInstance(), BorderLayout.CENTER);
        this.add(DownPanel.getInstance(),BorderLayout.SOUTH);

        this.addWindowListener(new ExitWindowAdapter());
        this.pack();
        this.setBounds(frameLocationMiddle(this).width, frameLocationMiddle(this).height,
                WINDOW_WIDTH, WINDOW_HEIGHT);

        ImportLineTextField.getInstance().requestFocus();

        this.setVisible(true);
    }

    class ExitWindowAdapter extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    private Dimension frameLocationMiddle(Frame frame) {
        int windowWidth = frame.getWidth(); //获得窗口宽
        int windowHeight = frame.getHeight(); //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高
        return new Dimension(screenWidth / 2 - windowWidth, screenHeight / 2 - windowHeight);//设置窗口居中显示
    }
}

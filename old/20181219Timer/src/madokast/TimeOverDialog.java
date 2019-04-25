package madokast;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TimeOverDialog extends Dialog {
    private static TimeOverDialog timeOverDialog;
    public static TimeOverDialog getInstance()
    {
        if(timeOverDialog==null)
        {
            timeOverDialog = new TimeOverDialog();
        }

        return timeOverDialog;
    }


    private TimeOverDialog()
    {
        super(WindowFrame.getInstance(),"Time Over",true);

        Label label = new Label();
        label.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label.setText("time over");

        Button button =new Button("OK");

        button.addActionListener(e->{
            this.setVisible(false);
            ImportLineTextField.getInstance().setText(null);
        });

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    TimeOverDialog.getInstance().setVisible(false);
            }
        });

        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    TimeOverDialog.getInstance().setVisible(false);
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                TimeOverDialog.getInstance().setVisible(false);
            }
        });

        this.add(label,BorderLayout.CENTER);
        this.add(button,BorderLayout.SOUTH);

        this.pack();
        this.setBounds(LocationMiddle(this).width,LocationMiddle(this).height,
                this.getWidth(),this.getHeight());
    }

    private Dimension LocationMiddle(Dialog dialog) {
        int windowWidth = dialog.getWidth(); //获得窗口宽
        int windowHeight = dialog.getHeight(); //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高
        return new Dimension(screenWidth / 2 - windowWidth, screenHeight / 2 - windowHeight);//设置窗口居中显示
    }
}

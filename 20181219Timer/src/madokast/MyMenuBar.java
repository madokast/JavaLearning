package madokast;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMenuBar extends MenuBar {
    private static MyMenuBar myMenuBar;
    public static MyMenuBar getInstance()
    {
        if(myMenuBar==null)
        {
            myMenuBar=new MyMenuBar();
        }

        return myMenuBar;
    }

    private MyMenuBar()
    {
        Menu AdvancedMenu = new Menu("Advanced");
        MenuItem exitMenuItem = new MenuItem("exit");

        this.add(AdvancedMenu);
        AdvancedMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(new ExitMenuItemActionListener());
    }

    class ExitMenuItemActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            InfoTextArea infoTextArea = InfoTextArea.getInstance();

            infoTextArea.append("\n\nthanks for using");
            try {
                for (int i = 0; i < 6; i++) {
                    infoTextArea.append(".");
                    Thread.sleep(200);
                }
            } catch (Exception except) {
                System.out.println("exit...");
            }
            System.exit(0);
        }
    }
}

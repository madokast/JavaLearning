package madokast;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ImportLineTextField extends TextField {
    private static ImportLineTextField importLineTextField;
    public static ImportLineTextField getInstance()
    {
        if(importLineTextField==null)
        {
            importLineTextField=new ImportLineTextField();
        }

        return importLineTextField;
    }

    private ImportLineTextField(){
        this.setFont(new Font("Times New Roman",Font.PLAIN,20));
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    SettingTime.runButtonAction();
                }
            }
        });
    }
}

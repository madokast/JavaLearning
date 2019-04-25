package madokast;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RunButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        SettingTime.runButtonAction();
    }
}

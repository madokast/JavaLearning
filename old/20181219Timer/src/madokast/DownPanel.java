package madokast;

import javax.swing.*;
import java.awt.*;

public class DownPanel extends Panel{
    private static DownPanel downPanel;
    public static DownPanel getInstance()
    {
        if(downPanel==null)
        {
            downPanel = new DownPanel();
        }

        return downPanel;
    }

    private DownPanel()
    {
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.add(Box.createHorizontalStrut(30));
        this.add(TimingCanvas.getInstance());
        this.add(Box.createHorizontalStrut(200));
        this.add(ImportLineTextField.getInstance());
        this.add(Box.createHorizontalStrut(30));
        this.add(RunButton.getInstance());
        this.add(Box.createHorizontalStrut(30));
    }
}

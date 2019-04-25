package madokast;

import java.awt.*;

public class RunButton extends Button {
    private static RunButton runButton;
    public static RunButton getInstance()
    {
        if(runButton==null)
        {
            runButton=new RunButton();
        }

        return runButton;
    }

    private RunButton()
    {
        this.setFont(new Font("Times New Roman",Font.PLAIN,20));
        this.setLabel("run!");
        this.addActionListener(new RunButtonActionListener());
    }
}

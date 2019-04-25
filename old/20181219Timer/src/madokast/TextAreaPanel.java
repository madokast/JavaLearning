package madokast;

import java.awt.*;

public class TextAreaPanel extends Panel{
    private static Panel textAreaPanel;

    public static Panel getInstance()
    {
        if(textAreaPanel==null)
        {
            textAreaPanel=new TextAreaPanel();
        }

        return textAreaPanel;
    }

    private TextAreaPanel()
    {
        this.setLayout(new BorderLayout());
        this.add(InfoTextArea.getInstance(),BorderLayout.CENTER);
    }
}

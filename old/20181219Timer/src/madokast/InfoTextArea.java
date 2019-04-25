package madokast;

import java.awt.*;

public class InfoTextArea extends TextArea {
    private static InfoTextArea infoTextArea;
    public static InfoTextArea getInstance()
    {
        if(infoTextArea==null)
        {
            infoTextArea = new InfoTextArea();
        }
        return infoTextArea;
    }

    private InfoTextArea()
    {
        this.setRows(5);
        this.setColumns(20);

        this.setFont(new Font("Times New Roman",Font.PLAIN,20));
    }
}

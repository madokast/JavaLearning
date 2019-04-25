package madokast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SettingTime {
    private static int seconds;

    public static void settingTimeString(String str)
    {
        TimerCount.getInstance().stop();

        try {
           seconds = (int)(Double.parseDouble(str)*60);
           TimingCanvas.getInstance().paintString(seconds);

           SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
           InfoTextArea.getInstance().append("["+df.format(new Date())+"]Start "+seconds+"s countdown\n");

           TimerCount.getInstance().start(seconds);
        }
        catch (Exception e)
        {
            NumberErrorDialog.getInstance().setVisible(true);
        }
    }

    public static void runButtonAction()
    {
        String str = ImportLineTextField.getInstance().getText();
        ImportLineTextField.getInstance().setText(null);

        settingTimeString(str);
    }
}

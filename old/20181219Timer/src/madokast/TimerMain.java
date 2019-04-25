package madokast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimerMain {
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        InfoTextArea.getInstance().append("["+df.format(new Date())+"]Hello,world!\n");
        WindowFrame.getInstance();
    }
}

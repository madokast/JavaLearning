package Java并发编程的艺术.Tools;

public class Sleep {
    public static void sleep(int ms){
        try {
            Thread.currentThread().sleep(ms);
        }catch (Exception e){e.printStackTrace();}
    }
}

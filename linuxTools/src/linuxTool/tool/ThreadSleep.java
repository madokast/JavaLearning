package linuxTool.tool;

public class ThreadSleep {
    private ThreadSleep(){}

    public static void sleep(Thread currentThread,int ms){
        try{
            currentThread.sleep(ms);
        }catch (Exception e){}
    }
}

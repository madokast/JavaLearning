package fileTest;

public class A {
    private static Object s = new Object();
    private static int count = 0;
    public static void main(String[] argv){
        for(;;){
            new Thread(new Runnable(){
                public void run(){
                    synchronized(s){
                        count += 1;
                        System.err.println("New thread #"+count);
                    }
                    for(;;){
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e){
                            System.err.println(e);
                        }
                    }
                }
            }).start();
        }
    }
}

//New thread #140529
//[254.809s][warning][os,thread] Failed to start thread - _beginthreadex failed (EACCES) for attributes: stacksize: default, flags: CREATE_SUSPENDED STACK_SIZE_PARAM_IS.
//Exception in thread "main" java.lang.OutOfMemoryError: unable to create native thread: possibly out of memory or process/resource limits reached
//	at java.base/java.lang.Thread.start0(Native Method)
//	at java.base/java.lang.Thread.start(Thread.java:804)
//	at fileTest.A.main(A.java:22)
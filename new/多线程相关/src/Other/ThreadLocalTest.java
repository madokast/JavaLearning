package Other;

public class ThreadLocalTest {
    public static void main(String[] args) {
        final ThreadLocal<Integer> num = new ThreadLocal<>(){
            @Override
            protected Integer initialValue() {
                return 0;
            }
        };

        for (int i = 0; i < 3; i++) {
            new MyThread(num).start();
        }
    }

    private static class MyThread extends Thread{
        private ThreadLocal<Integer> num;
        MyThread(ThreadLocal<Integer> a){
            this.num=a;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                Integer integer = num.get();
                integer=integer+1;
                num.set(integer);
                System.out.println(Thread.currentThread().getName()+"::"+num.get()+"["+num.hashCode());
            }
        }
    }
}

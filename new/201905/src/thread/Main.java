package thread;

public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("thread01");

        myThread.start();
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"  "+i);
            try{
                Thread.currentThread().sleep(1);
            }catch (Exception e){}
        }

    }
}

//main  0
//thread01  0
//thread01  1
//main  1
//thread01  2
//main  2
//thread01  3
//main  3
//thread01  4
//main  4
//thread01  5
//main  5
//thread01  6
//main  6
//thread01  7
//main  7
//thread01  8
//main  8
//thread01  9
//main  9
//thread01  10
//main  10
//thread01  11
//main  11
//thread01  12
//main  12
//thread01  13
//main  13
//thread01  14
//main  14
//thread01  15
//main  15
//thread01  16
//main  16
//thread01  17
//main  17
//thread01  18
//main  18
//thread01  19
//main  19

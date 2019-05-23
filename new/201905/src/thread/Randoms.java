package thread;

import java.util.Random;

public class Randoms {
    public static int nextInt(){
        return new Random().nextInt(10)+100;
    }
}

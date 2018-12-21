package madokast.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList nums = new ArrayList();
        nums.add(2);
        nums.add(-5);
        nums.add(3);
        nums.add(0);
        System.out.println("nums = " + nums);

        //反序
        Collections.reverse(nums);
        System.out.println("nums = " + nums);

        //自然升序
        Collections.sort(nums);
        System.out.println("nums = " + nums);

        //洗牌
        Collections.shuffle(nums);
        System.out.println("nums = " + nums);
        
        //nums = [2, -5, 3, 0]
        //nums = [0, 3, -5, 2]
        //nums = [-5, 0, 2, 3]
        //nums = [-5, 2, 3, 0]
        
        //fill
        Collections.fill(nums,1);
        System.out.println("nums = " + nums);
        //nums = [1, 1, 1, 1]
        
        
        //可以用Collection得到綫程安全的同步集合
        List sl = Collections.synchronizedList(new ArrayList<>());
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        System.out.println("sl = " + sl);
        //sl = [1, 2, 3, 4]
        System.out.println(sl.getClass());
        //class java.util.Collections$SynchronizedRandomAccessList
    }
}

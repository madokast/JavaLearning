package IDEAJAVALEARN.nineInherit;

import java.util.Iterator;
import java.util.Set;

public class Member extends Host {
    public Member(int money, int ID) {
        super(money, ID);
//        number++;
    }

    public void receive(Set<Integer> set){
        Iterator<Integer> integerIterator = set.iterator();
        int money = integerIterator.next();
        this.setMoney(this.getMoney()+money);

        System.out.println("用户"+this.getID()+"收到"+money+",余额"+this.getMoney());
    }

//    private static int number;
//    static {
//        number=0;
//    }

//    public static int getNumber() {
//        return number;
//    }
}

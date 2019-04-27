package IDEAJAVALEARN.nineInherit;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestRed {
    public static void main(String[] args) {
        int num = 20;
        int money = 10000000;
        Host host = new Host(money,999);
        List<Member> list = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            list.add( new Member(0,i));
        }

        do{
            Set<Integer> set = host.send(num);
            for (int i = 0; i < num; i++) {
                list.get(i).receive(set);
            }
            System.out.println("--------------------------------");
        }while (host.getMoney()>num);

    }
}

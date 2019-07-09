package Stream流;

import javax.print.DocFlavor;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class 元素过滤 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("321");
        list.add("abc");
        list.add("def");

        before8(list);
        after8(list);
    }

    private static void after8(List<String> list){
        List<String> listABC = new ArrayList<>();
        list.stream().filter(s->s.charAt(0)>='a'&&s.charAt(0)<='z').forEach(s->listABC.add(s));
        System.out.println(listABC);
    }

    private static void before8(List<String> list){
        List<String> listABC = new ArrayList<>();
        for (String s:list
             ) {
            if(s.charAt(0)>='a'&&s.charAt(0)<='z')
                listABC.add(s);
        }

        System.out.println(listABC);
    }
}

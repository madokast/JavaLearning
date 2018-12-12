package madokast;

import java.util.*;

public class MapTest {
    public static void test1(){
        Map map = new HashMap();
        System.out.println("MapPut "+map.put("xyz",10));//MapPut null
        System.out.println("MapPut "+map.put("abc",11));//MapPut null
        System.out.println("MapPut "+map.put("bdf",10));//MapPut null
        System.out.println("MapPut "+map.put("xyz",15));//MapPut 10
        System.out.println("MapPut "+map.put("opq",10));//MapPut null

        System.out.println("map = " + map);
        //map = {opq=10, abc=11, bdf=10, xyz=15}

        System.out.println("containKey "+map.containsKey("xyz"));//containKey true
        System.out.println("containKey "+map.containsKey("aaa"));//containKey false

        System.out.println("containValue "+map.containsValue(10));//containValue true
        System.out.println("containValue "+map.containsValue(20));//containValue false

        for(Object key: map.keySet()){
            System.out.println(key + " -->> " + map.get(key));
        }
        //opq -->> 10
        //abc -->> 11
        //bdf -->> 10
        //xyz -->> 15

        map.remove("opq");
        System.out.println("map = " + map);
        //map = {abc=11, bdf=10, xyz=15}

        Set me = map.entrySet();
        System.out.println("me = " + me);
        //me = [abc=11, bdf=10, xyz=15]
    }

    public static void test2(){
        Map map = new HashMap();
        map.put("JAVA",109);
        map.put("IOS",99);
        map.put("AJAX",79);
        System.out.println("map = " + map);
        //map = {JAVA=109, IOS=99, AJAX=79}

        map.replace("XML",66);
        System.out.println("map = " + map);
        //map = {JAVA=109, IOS=99, AJAX=79}

        map.merge("IOS",10,(oldVal,param)->
                (Integer)oldVal+(Integer)param
        );
        System.out.println("map = " + map);
        //map = {JAVA=109, IOS=109, AJAX=79}


        map.computeIfAbsent("JAVA",(key)->
                ((String)(key)).length()
        );
        System.out.println("map = " + map);
        //map = {JAVA=109, IOS=109, AJAX=79}


        map.computeIfAbsent("JAVA123",(key)->
                ((String)(key)).length()
        );
        System.out.println("map = " + map);
        //map = {JAVA=109, JAVA123=7, IOS=109, AJAX=79}


        map.computeIfPresent("JAVA",(key,value)->
                        (Integer)value*(Integer)value
                );
        System.out.println("map = " + map);
        //map = {JAVA=11881, JAVA123=7, IOS=109, AJAX=79}

    }

    public static void main(String[] args) {
        test1();
        System.out.println("***********************");
        test2();
    }
}

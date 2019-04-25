import java.util.HashMap;
import java.util.Hashtable;

public class HashMapHashTable {

    public static void testHashMap(){
        HashMap hm = new HashMap();
        hm.put(null,null);
        System.out.println("hm = " + hm);
        hm.put(null,null);
        System.out.println("hm = " + hm);
        hm.put("123",null);
        System.out.println("hm = " + hm);
        hm.put("234",null);
        System.out.println("hm = " + hm);
        //hm = {null=null}
        //hm = {null=null}
        //hm = {null=null, 123=null}
        //hm = {null=null, 123=null, 234=null}
    }

    public static void testHshTable(){
        Hashtable ht = new Hashtable();
        ht.put(new A(6000),"JAVA JIANGYI");
        ht.put(new A(87563),"JAVAEE");
        ht.put(new A(1232),new B());
        System.out.println("ht = " + ht);
        //ht = {A{count=6000}=JAVA JIANGYI, A{count=87563}=JAVAEE, A{count=1232}=B{}}

        System.out.println(ht.containsValue("11"));
        System.out.println(ht.containsValue("1"));
        //true
        //true
        //仅仅使用equals判断value是否相同

        System.out.println(ht.containsKey(new A(87563)));
        System.out.println(ht.containsKey(new A(87561)));
        //true
        //false
        //使用equals和hashcode一起判断key是否相同

        ht.remove(new A(1232));
        System.out.println("ht = " + ht);
        //ht = {A{count=6000}=JAVA JIANGYI, A{count=87563}=JAVAEE}
    }

    public static void main(String[] args) {
        testHashMap();
        System.out.println("***************");
        testHshTable();
    }
}

class A{
    int count;
    public A(int count){
        this.count=count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof A)) return false;
        A a = (A) o;
        return count == a.count;
    }

    @Override
    public int hashCode() {
        return this.count;
    }

    @Override
    public String toString() {
        return "A{" +
                "count=" + count +
                '}';
    }

    public void setCount(int count) {
        this.count = count;
    }
}

class B{
    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public String toString() {
        return "B{}";
    }
}

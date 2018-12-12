import java.util.Objects;
import java.util.TreeMap;

public class TreeMapMain {
    public static void main(String[] args) {
        TreeMap tm = new TreeMap();
        tm.put(new R(3),"JAVAEE");
        tm.put(new R(-5),"JAVA");
        tm.put(new R(9),"Android");
        System.out.println("tm = " + tm);
        //tm = {R{count=-5}=JAVA, R{count=3}=JAVAEE, R{count=9}=Android}

        System.out.println("first "+tm.firstEntry());

        System.out.println("last"+tm.lastKey());

        System.out.println(">2 "+tm.higherKey(new R(2)));

        System.out.println("<2 "+tm.lowerEntry(new R(2)));

        System.out.println("sub map "+tm.subMap(new R(-1),new R(4)));

        //first R{count=-5}=JAVA
        //lastR{count=9}
        //>2 R{count=3}
        //<2 R{count=-5}=JAVA
        //sub map {R{count=3}=JAVAEE}


    }
}

class R implements Comparable{
    int count;
    public R(int count){
        this.count=count;
    }

    @Override
    public String toString() {
        return "R{" +
                "count=" + count +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        R r =(R)o;
        return count>r.count ? 1:
                count<r.count ? -1:0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof R)) return false;
        R r = (R) o;
        return count == r.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}

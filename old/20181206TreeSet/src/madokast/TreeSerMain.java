package madokast;
/*TreeSet can keep element order when adding it
* red black
* */

import java.util.TreeSet;

public class TreeSerMain {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add(5);
        ts.add(2);
        ts.add(10);
        ts.add(-9);

        System.out.println("ts = " + ts);
        //ts = [-9, 2, 5, 10]
        //an oder kept

        System.out.println("1st : "+ts.first());//1st : -9
        System.out.println("last :"+ts.last());//last :10

        System.out.println("lower 1"+ts.lower(1));//lower 1-9
        System.out.println("higher :"+ts.higher(5));//higher :10

        System.out.println("higher :"+ts.higher(10));//higher :null
        //cannot find pointed element, return null

        System.out.println("subset 0~6"+ts.subSet(0,6));//subset 0~6[2, 5]

        System.out.println(ts.first().getClass());//class java.lang.Integer
        //Integer

        //TreeSet ts2 = new TreeSet();
        //ts2.add(new NoComparable(2));
        //ts2.add(new NoComparable(3));
        // Exception in thread "main" java.lang.ClassCastException:
        // class madokast.noComparable cannot be cast to class java.lang.Comparable
        // (madokast.noComparable is in unnamed module of loader 'app';
        // java.lang.Comparable is in module java.base of loader 'bootstrap')

        TreeSet ts3 = new TreeSet();
        ts3.add(new WithComparable(5));
        ts3.add(new WithComparable(4));
        ts3.add(new WithComparable(-2));
        ts3.add(new WithComparable(10));
        ts3.add(new WithComparable(-12));

        System.out.println("ts3 = " + ts3);
        //ts3 = [-2, 4, 5, 10, -12]
        //beautiful

        System.out.println("****************R************");
        TreeSet ts4 = new TreeSet();
        ts4.add(new R(5));
        ts4.add(new R(-3));
        ts4.add(new R(9));
        ts4.add(new R(-2));
        System.out.println("ts4 = " + ts4);
        //ts4 = [R{count=-3}, R{count=-2}, R{count=5}, R{count=9}]

        R rfirst = (R)ts4.first();
        rfirst.count=20;
        R rlast = (R)ts4.last();
        rlast.count=-2;
        System.out.println("ts4 = " + ts4);
        //ts4 = [R{count=20}, R{count=-2}, R{count=5}, R{count=-2}]
        //无序状态
        //且有重复

        System.out.println(ts4.remove(new R(-2)));//false
        System.out.println("ts4 = " + ts4);
        //ts4 = [R{count=20}, R{count=-2}, R{count=5}, R{count=-2}]
        //无法删除？为什么？

        System.out.println(ts4.remove(new R(5)));//true
        System.out.println("ts4 = " + ts4);
        //ts4 = [R{count=20}, R{count=-2}, R{count=-2}]
        //删除成功

        System.out.println(ts4.remove(new R(-2)));//true
        System.out.println("ts4 = " + ts4);
        //ts4 = [R{count=20}, R{count=-2}]
        //此时可以正常删除

        //不要修改放入Set中的实例变量


        System.out.println("****************R2************");
        TreeSet ts5 = new TreeSet(
                (o1,o2)->{
                    R r1 = (R)o1;
                    R r2 = (R)o2;
                    return r1.count>r2.count? -1:
                            r1.count<r2.count? 1:0;
                }
        );
        ts5.add(new R(5));
        ts5.add(new R(-3));
        ts5.add(new R(9));
        ts5.add(new R(-2));
        System.out.println("ts5 = " + ts5);
        //ts5 = [R{count=9}, R{count=5}, R{count=-2}, R{count=-3}]
        //it means the int compareTo(Object o) in class R doesn't work

    }
}

class NoComparable{
    private int x;
    public NoComparable(int x){this.x=x;}

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}

class WithComparable implements Comparable{
    @Override
    public int compareTo(Object o) {
        if(o==this)
            return 0;
        if(o!=null&&(o instanceof WithComparable)){
            if(Math.abs(x)>Math.abs(((WithComparable) o).getX()))
            return 1;
            else if(Math.abs(x)==Math.abs(((WithComparable) o).getX()))
                return 0;
            else if(Math.abs(x)<Math.abs(((WithComparable) o).getX()))
                return -1;
        }

        System.out.println("error");
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if(o==this)
            return true;
        if(o!=null&&(o instanceof WithComparable)){
            if(Math.abs(x)>Math.abs(((WithComparable) o).getX()))
                return false;
            else if(Math.abs(x)==Math.abs(((WithComparable) o).getX()))
                return true;
            else if(Math.abs(x)<Math.abs(((WithComparable) o).getX()))
                return false;
        }

        System.out.println("error");
        return false;
    }

    private int x;
    public WithComparable(int x){this.x=x;}

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getX());
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
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(obj!=null&&obj.getClass()==R.class){
            R r = (R)obj;
            return this.count==r.count;
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        R r=(R)o;
        return this.count>r.count? 1:
                (this.count<r.count? -1:0);
    }
}
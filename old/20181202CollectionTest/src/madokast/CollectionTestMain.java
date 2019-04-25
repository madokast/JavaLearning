package madokast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 测试一下文档注释。有趣
 * @author zrx
 * @version 1.0
 */

public class CollectionTestMain {
    public static void arraylistAndCollection(){
        //initialize an array-list and use collection class to operate it
        //because collection is the super class of array-list
        Collection c = new ArrayList();

        //add elements into it
        //when no generic used different object can be put into one collection
        //because the collection only contains the reference to the object
        //every object in the collection forget its class but Object
        c.add("sunwukong");
        c.add(123);
        System.out.println("c.size= "+c.size());//2
        System.out.println(c);//c==c.toString

        //remove
        c.remove(123);
        System.out.println("c.size= "+c.size());//1

        //交集
        Collection c1 = new ArrayList();
        Collection c2 = new ArrayList();
        c1.add(1);c1.add(2);c1.add(3);c1.add(4);
        c2.add(3);c2.add(4);c2.add(5);c2.add(6);
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        c1.retainAll(c2);//交集運算
        System.out.println("c1 = " + c1);//c1 = [3, 4]

        //everyone has its once toString
        c.add(c1);
        c.add("ABC");
        c.add(123);
        System.out.println("c = " + c.toString());//c = [sunwukong, [3, 4], ABC, 123]
    }
    
    public static void transverseCollection(){
        Collection books=new HashSet();
        books.add("ABC");
        books.add("EFG");
        books.add("XYZ");


        //use lambda to transverse collection
        //get every element and put it to a,then you write how to operate a
        books.forEach(a-> System.out.println("a = " + a));
        //a = ABC
        //a = EFG
        //a = XYZ


        //get iterator
        Iterator it=books.iterator();
        while(it.hasNext()){
            String book=(String)it.next();
            System.out.println("book = " + book);
            if(book=="EFG"){//remove element of last next
                it.remove();
                //it is OK


                //books.remove(book);
                //it is bad
                //java.util.ConcurrentModificationException
                //同時修飾異常
            }

            book="test";
            //no change
        }
        //book = ABC
        //book = EFG
        //book = XYZ
        System.out.println("books = " + books);
        //books = [ABC, XYZ]

        it=books.iterator();//goto beginning
        //java iterator有重置的功能吗
        //和C#不同，C#有reset，java只有hasnext和next，唯一的方式是再调用iterator()得到一个新的迭代器
        it.forEachRemaining(fer-> System.out.println("fer = " + fer));
        //fer = ABC
        //fer = XYZ

        //removeIf and lambda expression
        //i can use it to remove all match the require
        books.removeIf(ele->((String)ele).substring(2).equals("C"));
        System.out.println("books = " + books);
        //books = [XYZ]
    }
    
    public static void main(String[] args) {
        //CollectionTestMain.arraylistAndCollection();
        CollectionTestMain.transverseCollection();

        int a=(int)3E100;
        System.out.println(a);//2147483647





    }
}

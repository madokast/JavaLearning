import java.util.*;

public class ListTestMain {
    public static void list1(){
        List books = new ArrayList();
        books.add(new String("123"));
        books.add(new String("abcde"));
        books.add(new String("@#"));
        System.out.println("books = " + books);//books = [123, abc, @#$]

        books.add(1,new String("2nd?"));
        for(int i=0;i<books.size();i++){
            System.out.print(books.get(i)+"\t");
        }//123	2nd?	abc	@#$
        System.out.println("\n");

        HashSet hs = new HashSet();
        hs.add(books.get(1));
        hs.add(books.get(2));
        hs.add(books.get(3));
        System.out.println("hs = " + hs);
        //hs = [@#$, abc, 2nd?]

        books.add(0,hs);
        System.out.println("books = " + books);
        //books = [[@#$, abc, 2nd?], 123, 2nd?, abc, @#$]
        //sou sou sou

        System.out.println("subList"+books.subList(0,3));
        //subList[[@#$, abc, 2nd?], 123, 2nd?]

        books.set(0,new String("1"));

        books.sort((o1,o2)-> ((String)o1).length()-((String)o2).length());
        System.out.println("books = " + books);
        //books = [1, @#, 123, 2nd?, abcde]

        books.replaceAll(ele->((String)ele).length());
        System.out.println("books = " + books);
        //books = [1, 2, 3, 4, 5]

        ListIterator li = books.listIterator();
        while(li.hasNext())
            System.out.print(li.next()+"\t");
        //1	2	3	4	5

        System.out.print("\n");

        while(li.hasPrevious()) {
            System.out.print(li.previous()+"\t");
        }
        //5	4	3	2	1

        System.out.print("\n");

        Iterator it = books.iterator();
        System.out.println("li = " + li.getClass());//java.util.ArrayList$ListItr
        System.out.println("it = " + it.getClass());//java.util.ArrayList$Itr

        System.out.println(it instanceof Iterator);//true


    }
    public static void main(String[] args) {
        list1();
    }
}

package madokast;

import java.util.LinkedList;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList books = new LinkedList();
        books.offer("offer1");
        System.out.println("books = " + books);
        books.offer("offer2");
        System.out.println("books = " + books);
        books.push("push1");
        System.out.println("books = " + books);
        books.push("push2");
        System.out.println("books = " + books);
        books.offerFirst("offerFirst1");
        System.out.println("books = " + books);
        books.offerFirst("offerFirst2");
        System.out.println("books = " + books);
        books.offerLast("offerLast2");
        System.out.println("books = " + books);
        books.offerLast("offerLast2");
        System.out.println("books = " + books);
        //books = [push2, push1, offer1, offer2]
        //offer放在尾部
        //push放在頭部
        //offerFirst頭部
        //offerLast尾部




    }
}

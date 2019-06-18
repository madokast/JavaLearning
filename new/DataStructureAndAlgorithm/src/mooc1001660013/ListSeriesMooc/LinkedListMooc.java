package mooc1001660013.ListSeriesMooc;

import java.util.ArrayList;
import java.util.List;

public class LinkedListMooc implements ListMooc {
    Node dummy;

    public LinkedListMooc(){
        //dummy.next 一定不为空
        this.dummy = new Node(Integer.MAX_VALUE,new Node(Integer.MAX_VALUE,null));
    }

    private class Node {
        int data;
        Node next;

        private Node() {
        }

        public Node(int e) {
            this.data = e;
            this.next=null;
        }

        public Node(int e, Node next) {
            this(e);
            this.next = next;
        }
    }

    @Override
    public int size() {
        Node node = dummy.next.next;
        int size = 0;
        while (node!=null){
            size++;
            node = node.next;
        }
        return size;
    }

    @Override
    public int get(int i) {
        Node node = dummy.next;
        int j=0;
        while (node!=null){
            node=node.next;
            if(i==j){
                if(node==null){
                    System.err.println("err in get");
                    return i;
                }

                return node.data;
            }
            else
                j++;
        }

        System.err.println("err in get");
        return i;
    }

    @Override
    public boolean insert(int e, int i) {
        Node insert = new Node(e);
        Node node = dummy.next;
        int j = 0;
        while (node!=null){
            if(i==j){
                Node next = node.next;
                node.next = insert;
                insert.next = next;
                return true;
            }

            node=node.next;
            j++;
        }

        System.err.println("err in insert");
        return false;
    }

    @Override
    public boolean delete(int i) {
        Node node = dummy.next;
        int j=0;
        while (node!=null){
            if(i==j){
                try {
                    node.next=node.next.next;
                    return true;
                }catch (Exception e){
                    System.err.println("err in delete");
                    return false;
                }
            }
            node=node.next;
            j++;
        }

        System.err.println("err in delete");
        return false;
    }

    @Override
    public String toString() {
        List list = new ArrayList(size());
        for (int i = 0; i < size(); i++) {
            list.add(get(i));
        }
        return list.toString();
    }
}

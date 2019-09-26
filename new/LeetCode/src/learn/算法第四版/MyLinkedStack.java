package learn.算法第四版;

import java.util.Iterator;

public class MyLinkedStack<E> implements Stack<E> {
    private class Node{
        E e;
        Node next;
    }

    private Node first;
    private int number;

    @Override
    public void push(E e) {
        Node oldFirst = first;
        first = new Node();
        first.e = e;
        first.next=oldFirst;
        number++;
    }

    @Override
    public E pop() {
        E e = first.e;
        first = first.next;
        number--;
        return e;
    }

    @Override
    public boolean isEmpty() {
        return first==null;
    }

    @Override
    public int size() {
        return number;
    }

    @Override
    public Iterator iterator() {
        return new MyLinkedStackIterator();
    }

    private class MyLinkedStackIterator implements Iterator{
        private Node node;

        MyLinkedStackIterator(){node = first;}

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return node!=null;
        }

        @Override
        public Object next() {
            E e = node.e;
            node = node.next;
            return e;
        }
    }
}

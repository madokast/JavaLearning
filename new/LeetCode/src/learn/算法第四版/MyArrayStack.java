package learn.算法第四版;

import java.util.Iterator;

public class MyArrayStack<E> implements Stack<E> {
    private E[] array;
    private int i;

    public MyArrayStack(){
        array = (E[]) (new Object[1]);
        i = 0;
    }

    private void resize(int size){
        E[] newArray = (E[]) (new Object[size]);
        System.arraycopy(array,0,newArray,0,size());
        array = newArray;
    }


    @Override
    public void push(E e) {
        if(i>=array.length)
            resize(array.length*2);

        array[i++] = e;
    }

    @Override
    public E pop() {
        E e = array[--i];
        if(i>0&&i<=array.length/4)
            resize(array.length/2);

        return e;
    }

    @Override
    public boolean isEmpty() {
        return size()>0;
    }

    @Override
    public int size() {
        return i;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayStackIterator();
    }

    private class MyArrayStackIterator implements Iterator<E>{
        private int i;

        private  MyArrayStackIterator(){
            i=size()-1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return i>=0;
        }

        @Override
        public E next() {
            return array[i--];
        }
    }
}

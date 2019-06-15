package mooc1001660013;

import Tools.ArrToString;

public class ArrayListMooc implements ListMooc{
    private int[] arr;
    private int size;
    private ArrayListMooc(){}
    public ArrayListMooc(int length){
        arr = new int[length];
        size=0;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public int get(int i) {
        if(i<0||i>=size){
            System.err.println("error in get");
            return i;
        }

        return arr[i];
    }

    @Override
    public boolean insert(int e,int i) {
        if(i<0||i>size||size==arr.length){
            System.err.println("error in insert");
            return false;
        }

        for (int j = size-1; j >= i; j--) {
            arr[j+1]=arr[j];
        }
        arr[i]=e;
        size++;
        return true;
    }

    @Override
    public boolean delete(int i) {
        if(i<0||i>=size||size==0){
            System.err.println("error in delete");
            return false;
        }

        for (int j = i; j < size-1; j++) {
            arr[j]=arr[j+1];
        }

        size--;
        return true;
    }

    @Override
    public String toString(){
        return ArrToString.arrToString(arr,size);
    }
}

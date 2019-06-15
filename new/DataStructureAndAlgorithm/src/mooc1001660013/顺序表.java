package mooc1001660013;

public class 顺序表 {
    public static void main(String[] args) {
        ArrayListMooc arrayListMooc = new ArrayListMooc(10);
        arrayListMooc.insert(1);
        arrayListMooc.insert(2);
        arrayListMooc.insert(3);
        arrayListMooc.print();

        arrayListMooc.insert(4,0);
        arrayListMooc.print();

        arrayListMooc.delete(1);
        arrayListMooc.print();

        arrayListMooc.delete();
        arrayListMooc.print();

        System.out.println(arrayListMooc.get(0));
        System.out.println(arrayListMooc.get(1));

        System.out.println(arrayListMooc.search(2));
        System.out.println(arrayListMooc.search(1));

        System.out.println(arrayListMooc.isSorted());
    }
}

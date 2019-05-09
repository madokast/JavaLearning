package N215_233;

public class SystemTest {
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis = " + currentTimeMillis);

        int[] arr1 = {1, 2, 3};
        int[] arr2 = new int[5];
        for (int i : arr1) {
            System.out.println("i = " + i);
        }
        System.out.println("--------------------");
        for (int i : arr2) {
            System.out.println("i = " + i);
        }
        System.out.println("--------------------");

        System.arraycopy(arr1,0,arr2,0,3);
        for (int i : arr2) {
            System.out.println("i = " + i);
        }
    }
}

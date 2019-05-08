package N215;

public class AssertionErrorTest {
    public static void main(String[] args) {
        System.out.println(1);
        throw new AssertionError("AssertionError");
        //System.out.println(2);
    }
}

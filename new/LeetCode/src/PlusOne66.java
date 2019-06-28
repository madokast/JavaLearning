import java.util.Arrays;

public class PlusOne66 {
    public static void main(String[] args) {
        Arrays.stream(new PlusOne66().plusOne(new int[] {9})).forEach(System.out::print);
    }

    public int[] plusOne(int[] digits) {
        int carry = 0;
        int add = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i] = digits[i]+add+carry;
            add=0;carry=0;
            if(digits[i]>=10){
                digits[i]-=10;
                carry=1;
            }
        }

        if(carry==1){
            int[] a = new int[digits.length+1];
            a[0]=1;
            return a;
        }
        return digits;
    }
}

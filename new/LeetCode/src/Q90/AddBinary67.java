package Q90;

public class AddBinary67 {
    public static void main(String[] args) {
        System.out.println(new AddBinary67().addBinary("0", "0000"));
    }

    public String addBinary(String a, String b) {
        int[] arr = new int[Math.max(a.length(),b.length())+1];
        int[] brr = new int[Math.max(a.length(),b.length())+1];

        int j = arr.length-1;
        for (int i = a.length()-1; i >= 0; i--) {
            arr[j--] = a.charAt(i) - '0';
        }
//        Tools.printIntArr(arr);
        j = arr.length-1;
        for (int i = b.length()-1; i >= 0; i--) {
            brr[j--] = b.charAt(i) - '0';
        }
//        Tools.printIntArr(brr);

        int carry = 0;

        for (int i = arr.length-1; i >= 0; i--) {
            arr[i]+=brr[i]+carry;
            if(arr[i]>=2){
                arr[i]-=2;
                carry=1;
            }else
                carry=0;
        }

        int i = 0;
        while (i<arr.length&&arr[i]==0)
            i++;

        System.out.println(i);

        StringBuilder stringBuilder = new StringBuilder(arr.length-i);
        for (; i < arr.length; i++) {
            stringBuilder.append(arr[i]);
        }



        return stringBuilder.length()==0?"0":stringBuilder.toString();
    }
}

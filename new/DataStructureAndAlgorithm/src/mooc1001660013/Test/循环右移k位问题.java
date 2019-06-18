package mooc1001660013.Test;


import Tools.ArrToString;

public class 循环右移k位问题 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        ArrToString.printArrat(arr);
//        reverse(arr);
//        ArrToString.printArrat(arr);

        循环地右移k位(arr,4);
        ArrToString.printArrat(arr);
    }

    public static void 循环地右移k位(int[] arr,int k){
        reversePart(arr,arr.length-k,arr.length);
        ArrToString.printArrat(arr);
        reversePart(arr,0,arr.length-k);
        ArrToString.printArrat(arr);
        reverse(arr);
    }

    private static void reversePart(int arr[],int i,int j){
        for (int k = i; k < (j+i)/2; k++) {
            swap(arr,k,j-k+i-1);
        }
    }

    private static void reverse(int arr[]) {
        for (int i = 0; i < arr.length/2; i++) {
            swap(arr,i,arr.length-i-1);
        }
    }

    private static void swap(int[] arr,int i,int j){
//        System.out.println(i+j+"");
        arr[i]=arr[j]^arr[i];
        arr[j]=arr[j]^arr[i];
        arr[i]=arr[j]^arr[i];
    }
}

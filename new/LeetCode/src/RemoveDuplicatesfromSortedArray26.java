import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesfromSortedArray26 {
    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println(new RemoveDuplicatesfromSortedArray26().removeDuplicates(arr));
        for (int t:arr
             ) {
            System.out.print(t);
        }
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return 1;

        int left = 0;
        int right;
        for (right = 1; right < nums.length; right++) {
            if(nums[right]==nums[left])
                continue;
            else {
                left++;
                swap(nums,left,right);
            }
        }

        return left+1;
    }

    public void swap(int[] arr,int i,int j){
        if(arr[i]==arr[j])
            return;

        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }
}

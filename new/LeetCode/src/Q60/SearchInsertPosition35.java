package Q60;

public class SearchInsertPosition35 {
    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition35().searchInsert(new int[]{1}, 1));
    }

    public int searchInsert(int[] nums, int target) {
        int right = nums.length-1;
        if(right==-1)
            return 0;
        int left = 0;
        int mid = 0;
        while(right>=left){
            mid = (right+left)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                right=mid-1;
            else
                left=mid+1;
        }
//        System.out.println(left);
//        System.out.println(right);
//        System.out.println(mid);
        return (left>mid)?left:mid;
    }
}

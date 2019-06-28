import java.util.Arrays;

public class MaximumSubarray53 {
    //Input: [-2,1,-3,4,-1,2,1,-5,4],
    //Output: 6
    //Explanation: [4,-1,2,1] has the largest sum = 6.
    public static void main(String[] args) {
        System.out.println("new MaximumSubarray53().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}) = " + new MaximumSubarray53().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        int maxSum = 0;
        int curSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            curSum+=nums[i];
            if(curSum<0)
                curSum=0;
            if(curSum>maxSum)
                maxSum=curSum;
            if(nums[i]>max)
                max=nums[i];
        }

        if(maxSum==0)
            return max;

        return maxSum;
    }
}

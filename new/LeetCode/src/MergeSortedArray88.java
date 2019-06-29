import tools.Tools;

public class MergeSortedArray88 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,0,0,0,0};
        int[] b = {-1,-1,10,10};

        new MergeSortedArray88().merge(a,5,b,4);
        Tools.printIntArr(a);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m+n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if(nums1[i]>nums2[j]){
                nums[k] = nums2[j];
                k++;
                j++;
            }else{
                nums[k] = nums1[i];
                k++;
                i++;
            }
        }
        //剩余项目
        while (i<m){
            nums[k] = nums1[i];
            k++;
            i++;
        }
        while (j<n){
            nums[k] = nums2[j];
            k++;
            j++;
        }

        for(i=0;i<nums.length;i++){
            nums1[i]=nums[i];
        }
    }
}

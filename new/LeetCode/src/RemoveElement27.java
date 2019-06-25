import javax.swing.*;

public class RemoveElement27 {
    public static void main(String[] args) {

    }

    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                swap(nums, left, i);
                left++;
            }
        }
        return left;
    }

    public void swap(int[] arr, int i, int j) {
        if (i == j)
            return;

        if (arr[i] == arr[j])
            return;

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}

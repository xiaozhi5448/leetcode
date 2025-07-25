package array;

public class RotateArray_189 {
    private void reverse(int[] nums, int start, int end){
        int left = start, right = end;
        while(left < right){
            int pivot = nums[right];
            nums[right] = nums[left];
            nums[left] = pivot;
            left++;
            right--;
        }
    }

    public void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
}

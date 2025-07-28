package sort;

public class BinarySearch_35 {
    public int binarySearch(int[] nums, int target){
        if(target < nums[0]){
            return 0;
        }
        if(target > nums[nums.length-1]){
            return nums.length;
        }
        int left = 0, right = nums.length - 1, mid = (left+right) / 2;
        while(left  <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(target < nums[mid]){
                right = mid - 1;
            }
            if(target > nums[mid]){
                left = mid + 1;
            }
        }
        return left;
    }
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target);
    }
}

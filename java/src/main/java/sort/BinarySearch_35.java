package sort;

public class BinarySearch_35 {
    private int binarySearch(int[] nums, int target){
        if(nums.length == 0 || target <= nums[0]){
            return 0;
        }
        int left=0,right=nums.length-1;
        int mid;
        while(left <= right){
            if(left == right){
                if(target == nums[left] || target < nums[left])
                    return left;
                else{
                    return left+1;
                }
            }
            mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }else if(target < nums[mid]){
                right = Math.max(mid-1, left);
            }else{
                left = Math.min(mid+1, right);
            }
        }
        return left;
    }
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target);
    }
}

package array;

public class RemoveDuplicate_26 {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        while(right < nums.length){
            if(nums[right] != nums[right-1]){
                nums[++left] = nums[right++];
            }else{
                right++;
            }
        }
        return left+1;
    }
}

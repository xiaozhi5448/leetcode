package hard;

public class JumpGame {
    int count = 0;
    private int findMax(int[] nums, int startIndex, int endIndex){
        if(startIndex == endIndex){
            return startIndex;
        }
        int max_index = startIndex;
        for(int i = startIndex; i <=endIndex; i++){
            if(i >= nums.length)
                break;
            max_index = nums[max_index] > nums[i]? max_index: nums[i];
        }
        return max_index;
    }
    public int jump(int[] nums) {
        count = 0;
        int index = 0;
        while(index < nums.length){
            if(index + nums[index] >= nums.length - 1){
                count++;
                break;
            }
            index += findMax(nums, index + 1, index + nums[index]);
            count++;

        }
        return count;

    }
}

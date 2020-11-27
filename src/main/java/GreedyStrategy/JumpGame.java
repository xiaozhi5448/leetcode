package GreedyStrategy;
/*
贪心算法
 */
public class JumpGame {
    int count = 0;
    private int findMax(int[] nums, int startIndex, int endIndex){
        if(startIndex == endIndex){
            return startIndex;
        }
        int max_index = startIndex;
        for(int i = startIndex + 1; i <=endIndex; i++){
            if(i >= nums.length)
                break;
            if(nums[i] + i >= nums[max_index] + max_index){
                max_index = i;
            }
        }
        return max_index;
    }
    public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        count = 0;
        int index = 0;
        while(index < nums.length){
            if(index + nums[index] >= nums.length - 1){
                count++;
                break;
            }
            index = findMax(nums, index + 1, index + nums[index]);
            count++;
        }
        return count;
    }
}

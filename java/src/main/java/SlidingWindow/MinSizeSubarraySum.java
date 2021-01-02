package SlidingWindow;

public class MinSizeSubarraySum {
    private int sum(int[] nums, int left, int right){
        int res = 0;
        for(int i = left; i < right && i < nums.length; i++){
            res += nums[i];
        }
        return res;
    }
    public int minSubArrayLen(int s, int[] nums) {
        int left=0, right=0;
        int distance = Integer.MAX_VALUE;
        while(left < nums.length){
            if(sum(nums, left, right) < s){
                if(right < nums.length){
                    right++;
                }else{
                    break;
                }
            }else{
                distance = right - left > distance? distance: right - left;
                left++;
            }
        }
        if(distance == Integer.MAX_VALUE){
            distance = 0;
        }
        return distance;
    }
}

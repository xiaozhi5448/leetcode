package dp;

/**
 * 连续子数组最大和
 *
 * 动态规划
 * dp[i]表示以num[i]结尾的最大子数组和
 * dp[i] = Math.max(dp[i-1]+nums[i], nums[i])
 */
public class MaxSumOfSubarr_offer42 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return -1;
        }else if(nums.length == 1){
            return nums[0];
        }else{
            int res = Integer.MIN_VALUE;
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            res = Math.max(dp[0], res);
            for(int i = 1; i< nums.length; i++){
                dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}

package dp;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 动态规划
 */
public class LongestIncArr_300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = dp[0];
        for(int i = 1; i< nums.length; i++){
            int max =1;
            // 状态转移（重点）
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    max = Math.max(max, dp[j]+1);
                }
            }
            dp[i] = max;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

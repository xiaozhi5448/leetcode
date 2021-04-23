package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，
 * 子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 *
 *     answer[i] % answer[j] == 0 ，或
 *     answer[j] % answer[i] == 0
 *
 * 如果存在多个有效解子集，返回其中任何一个均可。
 */
public class LargestDivisibleSubset_368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if(nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxSize = 1,maxVal = 0;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] >= nums[j] && nums[i] % nums[j] == 0)
                    dp[i] = Math.max(dp[i], dp[j] + 1);

                if(dp[i] > maxSize){
                    maxSize = dp[i];
                    maxVal = nums[i];
                }
            }
        }
        if(maxSize == 1){
            res.add(nums[0]);
            return res;
        }
        while(maxSize > 0){
            for(int i = 0; i < nums.length; i++){
                if(dp[i] == maxSize && maxVal % nums[i] == 0){
                    res.add(nums[i]);
                    maxVal = nums[i];
                    maxSize--;
                    break;
                }
            }
        }
        return res;
    }
}

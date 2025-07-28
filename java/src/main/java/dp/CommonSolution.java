package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonSolution {

    /**
     * 279. 完全平方数
     * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
     *
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 12
     * 输出：3
     * 解释：12 = 4 + 4 + 4
     * 示例 2：
     *
     * 输入：n = 13
     * 输出：2
     * 解释：13 = 4 + 9
     *
     * 提示：
     *
     * 1 <= n <= 104
     */
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 1; i < n+1; i++){
            double sqrt = Math.sqrt(i);
            if(sqrt == Math.ceil(sqrt)){
                dp[i] = 1;
            }else{
                for(int t = 1;  t*t <= i; t++){
                    dp[i] = Math.min(dp[i], dp[i - t * t] + 1);
                }
            }
        }
        return dp[n];
    }

    /**
     * 322. 零钱兑换
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     *
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     *
     * 你可以认为每种硬币的数量是无限的。
     *
     *
     *
     * 示例 1：
     *
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * 示例 2：
     *
     * 输入：coins = [2], amount = 3
     * 输出：-1
     * 示例 3：
     *
     * 输入：coins = [1], amount = 0
     * 输出：0
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int invalid = Integer.MAX_VALUE / 2;
        Arrays.fill(dp, invalid);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            // 滑动窗口维护 最小值, 减少复杂度
            for(Integer till: coins){
                if(i - till >= 0){
                    dp[i] = Math.min(dp[i], dp[i-till] + 1);
                }
            }
        }
        return dp[amount] == invalid? -1: dp[amount];
    }

    /**
     * 139. 单词拆分
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
     *
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     *
     *
     *
     * 示例 1：
     *
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
     * 示例 2：
     *
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     *      注意，你可以重复使用字典中的单词。
     * 示例 3：
     *
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Set<Integer> wordLen = new HashSet<>();
        wordDict.forEach(word -> wordLen.add(word.length()));
        boolean[] flags = new boolean[s.length() + 1];
        flags[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int len: wordLen){
                if(i - len >= 0 && words.contains(s.substring(i - len, i))){
                    flags[i] = flags[i-len];
                    if(flags[i]){
                        break;
                    }
                }
            }
        }
        return flags[s.length()];
    }

    /**
     * 300. 最长递增子序列
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     *
     * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     *
     *
     * 示例 1：
     *
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 示例 2：
     *
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     * 示例 3：
     *
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 2500
     * -104 <= nums[i] <= 104
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        if(nums.length <= 1){
            return nums.length;
        }
        dp[0] = 1;
        int len = 0;
        for(int i = 1; i < nums.length;i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            len = Math.max(len, dp[i]);
        }
        return len;
    }

    /**
     * 53. 最大子数组和
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组是数组中的一个连续部分。
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                dp[i] = nums[0];
            }else{
                dp[i] = Math.max(nums[i], dp[i-1]+ nums[i]);
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    /**
     * 152. 乘积最大子数组
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     *
     * 测试用例的答案是一个 32-位 整数。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     *
     * 输入: nums = [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     *
     *
     * 提示:
     *
     * 1 <= nums.length <= 2 * 104
     * -10 <= nums[i] <= 10
     * nums 的任何子数组的乘积都 保证 是一个 32-位 整数
     */
    public int maxProduct(int[] nums) {
        // 当前元素有多种情况时, 需要考虑增加 动态规划数组的数量
        int[] maxProd = new int[nums.length];
        int[] minProd = new int[nums.length];
        if(nums.length == 0){
            return 0;
        }
        maxProd[0] = nums[0];minProd[0] = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            int t = Math.max(nums[i] * minProd[i-1], nums[i] * maxProd[i-1]);
            t = Math.max(t, nums[i]);
            maxProd[i] = t;
            res = Math.max(t, res);
            t = Math.min(nums[i] * minProd[i-1], nums[i] * maxProd[i-1]);
            t = Math.min(t, nums[i]);
            minProd[i] = t;
            res = Math.max(t, res);
        }
        return res;
    }

    /**
     * 647. 回文子串
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
     *
     * 回文字符串 是正着读和倒过来读一样的字符串。
     *
     * 子字符串 是字符串中的由连续字符组成的一个序列。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     * 示例 2：
     *
     * 输入：s = "aaa"
     * 输出：6
     * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 由小写英文字母组成
     */

    public int countSubstrings(String s) {
        return 0;
    }

}

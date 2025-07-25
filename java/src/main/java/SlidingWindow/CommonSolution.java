package SlidingWindow;

import java.util.*;
import java.util.stream.Collectors;

public class CommonSolution {

    /**
     * 219. Contains Duplicate II
     * Easy
     * Topics
     * Companies
     * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,1], k = 3
     * Output: true
     * Example 2:
     *
     * Input: nums = [1,0,1,1], k = 1
     * Output: true
     * Example 3:
     *
     * Input: nums = [1,2,3,1,2,3], k = 2
     * Output: false
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        Map<Integer, Integer> numCnt = new HashMap<>();
        int left = 0,right = 0;
        while(right <= k && right < length){
            numCnt.put(nums[right], numCnt.getOrDefault(nums[right], 0) + 1);
            if(numCnt.get(nums[right]) > 1){
                return true;
            }
            right++;
        }


        for(right = k+1; right < length; right++){
            numCnt.put(nums[right], 1 + numCnt.getOrDefault(nums[right], 0));
            numCnt.put(nums[left], numCnt.get(nums[left]) - 1);
            if(numCnt.get(nums[right]) > 1){
                return true;
            }
            left++;
        }
        return false;
    }

    /**
     * 220. Contains Duplicate III
     * Hard
     * Topics
     * Companies
     * Hint
     * You are given an integer array nums and two integers indexDiff and valueDiff.
     *
     * Find a pair of indices (i, j) such that:
     *
     * i != j,
     * abs(i - j) <= indexDiff.
     * abs(nums[i] - nums[j]) <= valueDiff, and
     * Return true if such pair exists or false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
     * Output: true
     * Explanation: We can choose (i, j) = (0, 3).
     * We satisfy the three conditions:
     * i != j --> 0 != 3
     * abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
     * abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0
     * Example 2:
     *
     * Input: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
     * Output: false
     * Explanation: After trying all the possible pairs (i, j), we cannot satisfy the three conditions, so we return false.
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if(nums == null || nums.length == 0){
            return false;
        }
        TreeSet<Integer> windowNums = new TreeSet<>();
        Map<Integer, Integer> windowNumCnt = new HashMap(); // 记录滑动窗口中， 每个数字出现的次数，当窗口右移， 需要从窗口中移除最左边的元素， 由于 treeset中不能包含重复元素， 所以不能直接移除
        // 初始化，将 前 indexDiff 个元素 插入 treeset
        for(int i = 0; i<= indexDiff && i < nums.length;i++){
            windowNums.add(nums[i]);
            windowNumCnt.put(nums[i], windowNumCnt.getOrDefault(nums[i], 0) + 1);
        }

        // 遍历nums 同时窗口右移, 注意在遍历时， 窗口中应该同时包含  i-indexdiff : i+indexDiff  中除了位置i的所有元素
        for(int i = 0; i< nums.length; i++){
            // 从窗口中移除 位于i位置的元素
            windowNumCnt.put(nums[i], windowNumCnt.getOrDefault(nums[i], 0) - 1);
            if(windowNumCnt.get(nums[i]) == 0){
                windowNums.remove(nums[i]);
            }
            Integer floor = windowNums.floor(nums[i]); // 小于等于nums[i]
            if(floor != null){
                if(Math.abs(nums[i] - floor) <= valueDiff){
                    return true;
                }
            }
            Integer ceil = windowNums.ceiling(nums[i]); // 大于等于 nums[i] 的最小元素
            if(ceil != null){
                if(Math.abs(ceil - nums[i]) <= valueDiff){
                    return true;
                }
            }
            // 移动窗口,为下个位置判断做准备 i - indexDiff, i+indexDiff
            int pivot = i + 1 + indexDiff;
            if(pivot < nums.length){

                windowNums.add(nums[pivot]);
                windowNumCnt.put(nums[pivot], windowNumCnt.getOrDefault(nums[pivot], 0) + 1);
            }
            pivot = i+1-indexDiff;
            if(pivot >= 0 && pivot != i){
                windowNumCnt.put(nums[pivot], windowNumCnt.getOrDefault(nums[pivot], 0) - 1);
                if(windowNumCnt.get(nums[pivot]) == 0){
                    windowNums.remove(nums[pivot]);
                }
            }
        }
        return false;
    }

    /**
     * Divide and Conquer
     *
     * 395. Longest Substring with At Least K Repeating Characters
     * Medium
     * Topics
     * Companies
     * Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.
     *
     * if no such substring exists, return 0.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "aaabb", k = 3
     * Output: 3
     * Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
     * Example 2:
     *
     * Input: s = "ababbc", k = 2
     * Output: 5
     * Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
     */
    public int longestSubstring(String s, int k) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        Map<Character, Integer> chCnt = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            chCnt.put(s.charAt(i), chCnt.getOrDefault(s.charAt(i), 0) + 1);
        }
        Set<Character> invalid = chCnt.entrySet().stream()
                .filter(characterIntegerEntry -> characterIntegerEntry.getValue() < k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        if(invalid.isEmpty()){
            return s.length();
        }
        int start = 0;
        int res = 0;
        for(int end = 0; end < s.length() && start < s.length(); end++){
            if(invalid.contains(s.charAt(end))){
                String item = s.substring(start, end);
                res = Math.max(res, longestSubstring(item, k));
                start = end+1;
            }
        }
        String suffix = s.substring(start);
        res = Math.max(res, longestSubstring(suffix, k));
        return res;
    }

    /**
     * 187. Repeated DNA Sequences
     * Medium
     * Topics
     * Companies
     * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
     *
     * For example, "ACGAATTCCG" is a DNA sequence.
     * When studying DNA, it is useful to identify repeated sequences within the DNA.
     *
     * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
     * Output: ["AAAAACCCCC","CCCCCAAAAA"]
     * Example 2:
     *
     * Input: s = "AAAAAAAAAAAAA"
     * Output: ["AAAAAAAAAA"]
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        // 暴力,找到所有长度为10 的子串, 出现超过2次即满足要求
        if(s == null || s.length() <= 10){
            return res;
        }
        Map<String, Integer> occurTimes = new HashMap<>();
        for(int i = 0; i< s.length(); i++){
            if(i + 10 <= s.length()){
                String item = s.substring(i, i + 10);
                occurTimes.put(item, occurTimes.getOrDefault(item, 0) + 1);
            }
        }
        return occurTimes.entrySet().stream()
                .filter(stringIntegerEntry -> stringIntegerEntry.getValue() >= 2)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    /**
     * 413. Arithmetic Slices
     * Medium
     * Topics
     * Companies
     * An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
     *
     * For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
     * Given an integer array nums, return the number of arithmetic subarrays of nums.
     *
     * A subarray is a contiguous subsequence of the array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,4]
     * Output: 3
     * Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
     *
     * Example 2:
     *
     * Input: nums = [1]
     * Output: 0
     *
     * 长度为n 的等差数列, 找长度至少为 3 的子数组的个数
     * 长度为3的子数组  n - 2 , 长度为4 的子数组 n-3, 长度为n 的子数组 1
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length < 3){
            return 0;
        }
        int left = 0,res=0;
        int pivot = nums[1] - nums[0];
        for(int right = 2; right < nums.length; right++){
            if(nums[right] - nums[right-1] != pivot){
                if(right - left >= 3){
                    int length = right - left;
                    int cnt = (length - 2 + 1)*(length - 2) / 2;
                    res += cnt;
                }
                pivot = nums[right] - nums[right-1];
                left = right - 1;
            }
        }
        if(left <= nums.length - 3){
            int length = nums.length - left;
            int cnt = (length - 2 + 1)*(length - 2) / 2;
            res += cnt;
        }
        return res;
    }
}

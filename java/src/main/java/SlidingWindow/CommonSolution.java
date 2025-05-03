package SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

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
}

package tpointer;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，
 * 请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 *
 * 如果不存在满足条件的子数组，则返回 0 。
 *
 */
public class LongestSubArray_1438 {
    public int longestSubarray(int[] nums, int limit) {
        if(nums.length == 0){
            return 0;
        }
        int left= 0,right = 1;
        TreeSet<Integer> window = new TreeSet<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        window.add(nums[0]);
        count.put(nums[0], 1);
        int ret = 1;
        while(right < nums.length){
            window.add(nums[right]);
            count.put(nums[right], 1 + count.getOrDefault(nums[right], 0));
            while(left<= right && window.last() -  window.first() > limit){
                count.put(nums[left], count.get(nums[left]) - 1);
                if(count.get(nums[left]) == 0)
                    window.remove(nums[left]);
                left++;
            }
            right++;
            ret = Math.max(right-left, ret);
        }
        return ret;
    }
}

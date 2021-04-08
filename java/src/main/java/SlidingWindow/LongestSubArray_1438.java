package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，
 * 该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * <p>
 * 如果不存在满足条件的子数组，则返回 0 。
 */
public class LongestSubArray_1438 {
    // 滑动窗口+有序集合
    public int longestSubArray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0, right = 0;
        int ret = 0;
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left += 1;
            }
            ret = Math.max(ret, right - left + 1);
            right += 1;
        }
        return ret;
    }

    // 滑动窗口+单调队列
    public int longestSubArray2(int[] nums, int limit) {
        if (nums == null)
            return 0;
        if (nums.length <= 1)
            return nums.length;
        int l=0,r=1,ret=0;
        Deque<Integer> maxQueue = new LinkedList<>();
        Deque<Integer> minQueue = new LinkedList<>();
        maxQueue.offerLast(nums[l]);
        minQueue.offerLast(nums[l]);
        while(r < nums.length){
            while(!maxQueue.isEmpty() && maxQueue.peekLast() < nums[r]){
                maxQueue.pollLast();
            }
            while(!minQueue.isEmpty() && minQueue.peekLast() > nums[r]){
                minQueue.pollLast();
            }
            maxQueue.offerLast(nums[r]);
            minQueue.offerLast(nums[r]);
            while(!minQueue.isEmpty() && !maxQueue.isEmpty() && maxQueue.peekFirst() - minQueue.peekFirst() > limit){
                if(minQueue.peekFirst() == nums[l]){
                    minQueue.pollFirst();
                }
                if(maxQueue.peekFirst() == nums[l]){
                    maxQueue.pollFirst();
                }
                l++;
            }
            ret = Math.max(ret, r-l+1);
            r++;
        }
        return ret;
    }
}

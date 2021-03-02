package SlidingWindow;

import java.util.TreeMap;

public class LongestSubArray {
    public int longestSubArray(int[] nums, int limit){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0, right = 0;
        int ret = 0;
        while(right < nums.length){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.lastKey() - map.firstKey() > limit){
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left += 1;
            }

            ret = Math.max(ret, right-left+1);
            right += 1;
        }
        return ret;
    }
}

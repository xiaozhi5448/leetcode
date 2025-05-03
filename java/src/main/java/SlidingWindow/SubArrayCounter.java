package SlidingWindow;

import java.util.Arrays;

/**
 * 2962. Count Subarrays Where Max Element Appears at Least K Times
 * Medium
 * Topics
 * Companies
 * You are given an integer array nums and a positive integer k.
 * <p>
 * Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
 * <p>
 * A subarray is a contiguous sequence of elements within an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,2,3,3], k = 2
 * Output: 6
 * Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
 * Example 2:
 * <p>
 * Input: nums = [1,4,2,1], k = 3
 * Output: 0
 * Explanation: No subarray contains the element 4 at least 3 times.
 */
public class SubArrayCounter {

    private long doCountByDp(int[] nums, int k){
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int m = nums[0];
        for (int num : nums) {
            m = Math.max(m, num);
        }
        int prev_cnt = 0;
        int curr_cnt = 0;
        int cnt = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (j == i) {
                    prev_cnt = ((nums[i] == m) ? 1 : 0);
                    curr_cnt = prev_cnt;
                } else {
                    curr_cnt = prev_cnt + ((nums[j] == m) ? 1 : 0);
                }
                if (curr_cnt >= k) {
                    cnt++;
                }
                prev_cnt = curr_cnt;
            }
        }
        return cnt;
    }
    public long countSubarrays(int[] nums, int k) {
        return doCountBySlidingWindow(nums, k);
    }

    public long doCountBySlidingWindow(int[] nums, int k) {
        if(nums.length == 0){
            return 0;
        }
        int maxElement = nums[0];
        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }
        int length = nums.length;
        int left = 0;
        long cnt = 0;
        long windowMaxCnt = 0;
        for(int right = 0; right < length; right++){
            if(nums[right] == maxElement){
                windowMaxCnt += 1;
            }
            // 移动left指针

            while (windowMaxCnt == k) {
                if (nums[left] == maxElement) {
                    windowMaxCnt--;
                }
                left++;
            }
            cnt += left;
        }
        return cnt;
    }

    public long solution(int[] nums, int k) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        long ans = 0, start = 0;
        int maxElementsInWindow = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == maxElement) {
                maxElementsInWindow++;
            }
            while (maxElementsInWindow == k) {
                if (nums[(int) start] == maxElement) {
                    maxElementsInWindow--;
                }
                start++;
            }
            ans += start;
        }
        return ans;
    }
}

package SlidingWindow;

import org.junit.Test;

public class LongestSubArray1438Test {

    @Test
    public void testLongestSubArray() {
        LongestSubArray_1438 util = new LongestSubArray_1438();
        int[] nums1 = {8,2,4,7};
        int ret = util.longestSubArray(nums1, 4);
        System.out.println(ret);
    }
}
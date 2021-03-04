package SlidingWindow;

import junit.framework.TestCase;
import org.junit.Test;

public class LongestSubArrayTest {

    @Test
    public void testLongestSubArray() {
        LongestSubArray util = new LongestSubArray();
        int[] nums1 = {8,2,4,7};
        int ret = util.longestSubArray(nums1, 4);
        System.out.println(ret);
    }
}
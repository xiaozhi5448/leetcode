package SlidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubArray1438Test {

    @Test
    public void testLongestSubArray() {
        LongestSubArray_1438 util = new LongestSubArray_1438();
        int[] nums1 = {8,2,4,7};
        int ret = util.longestSubArray2(nums1, 4);
        Assert.assertEquals(ret, 2);
        System.out.println(ret);
    }
}
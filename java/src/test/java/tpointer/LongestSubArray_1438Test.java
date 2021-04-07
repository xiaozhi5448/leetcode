package tpointer;
import org.junit.Assert;
import org.junit.Test;

public class LongestSubArray_1438Test{
    @Test
    public void testLongestSubarray() {
        LongestSubArray_1438 util = new LongestSubArray_1438();
        int len = util.longestSubarray(new int[]{10,1,2,4,7,2}, 5);
        System.out.println(len);
        Assert.assertEquals(len, 4);
        len = util.longestSubarray(new int[]{4,2,2,2,4,4,2,2}, 0);
        System.out.println(len);
        Assert.assertEquals(3, len);

        len = util.longestSubarray(new int[]{2,2,2,4,4,2,5,5,5,5,5,2}, 2);
        System.out.println(len);
    }
}
import junit.framework.TestCase;
import org.junit.Assert;

public class MinMax3ElementTest extends TestCase {

    /**
     * 正常case
     * min3 element: 0 1 3
     * max3 element: 9345 934 98
     */
    public void testMinMax3ElementNormal() {
        MinMax3Element minMax3Element = new MinMax3Element();
        int[] nums1 = new int[]{0,93,9,9345,934,934,8};
        int[] nums2 = new int[]{1,3,89,98,22};
        // min3Element  0 1 3
        // max3Element  9345, 934, 98
        int[][] min3ElementResult = minMax3Element.minMax3Element(nums1, nums2);
        Assert.assertEquals(2, min3ElementResult.length);
        int[] min3 = min3ElementResult[0];
        Assert.assertEquals(3, min3.length);
        Assert.assertEquals(0, min3[0]);
        Assert.assertEquals(3, min3[2]);
        int[] max3 = min3ElementResult[1];
        Assert.assertEquals(9345, max3[0]);
        Assert.assertEquals(98, max3[2]);
    }

    /**
     * 异常case, 入参为null
     */
    public void testMinMax3ElementNullInput() {
        MinMax3Element minMax3Element = new MinMax3Element();
        int[] nums1 = new int[]{0,93,9,9345,934,934,8};
        int[] nums2 = new int[]{1,3,89,98,22};

        int[][] min3ElementResult = minMax3Element.minMax3Element(nums1, null);
        Assert.assertEquals(2, min3ElementResult.length);
        int[] min3 = min3ElementResult[0];
        Assert.assertEquals(3, min3.length);
        Assert.assertEquals(0, min3[0]);
        Assert.assertEquals(9, min3[2]);
        int[] max3 = min3ElementResult[1];
        Assert.assertEquals(9345, max3[0]);
        Assert.assertEquals(93, max3[2]);

        min3ElementResult = minMax3Element.minMax3Element(null, nums2);
        Assert.assertEquals(2, min3ElementResult.length);
        min3 = min3ElementResult[0];
        Assert.assertEquals(3, min3.length);
        Assert.assertEquals(1, min3[0]);
        Assert.assertEquals(22, min3[2]);
        max3 = min3ElementResult[1];
        Assert.assertEquals(98, max3[0]);
        Assert.assertEquals(22, max3[2]);

        Assert.assertNull(minMax3Element.minMax3Element(null, null));
    }

    /**
     * 正常case, 入参长度小于3
     */
    public void testMin3ElementLessMax3() {
        MinMax3Element minMax3Element = new MinMax3Element();
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};

        int[][] min3ElementResult = minMax3Element.minMax3Element(nums1, nums2);
        Assert.assertEquals(2, min3ElementResult.length);
        int[] min3 = min3ElementResult[0];
        Assert.assertEquals(2, min3.length);
        Assert.assertEquals(0, min3[0]);
        Assert.assertEquals(1, min3[1]);
        int[] max3 = min3ElementResult[1];
        Assert.assertEquals(1, max3[0]);
        Assert.assertEquals(0, max3[1]);
    }
}
package SlidingWindow;

import junit.framework.TestCase;
import org.junit.Assert;

public class CommonSolutionTest extends TestCase {

    /**
     * * Example 1:
     *      *
     *      * Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
     *      * Output: true
     *      * Explanation: We can choose (i, j) = (0, 3).
     *      * We satisfy the three conditions:
     *      * i != j --> 0 != 3
     *      * abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
     *      * abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0
     *
     *  * Example 2:
     *      *
     *      * Input: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
     *      * Output: false
     *      * Explanation: After trying all the possible pairs (i, j), we cannot satisfy the three conditions, so we return false.
     */
    public void testContainsNearbyAlmostDuplicate1() {
        CommonSolution commonSolution = new CommonSolution();
        int[] nums = new int[]{1,2,3,1};
        boolean b = commonSolution.containsNearbyAlmostDuplicate(nums, 3, 0);
        Assert.assertTrue(b);
        
        nums = new int[]{1,5,9,1,5,9};
        Assert.assertFalse(commonSolution.containsNearbyAlmostDuplicate(nums, 2, 3));


        nums = new int[]{1,2,1,1};
        Assert.assertTrue(commonSolution.containsNearbyAlmostDuplicate(nums, 1, 0));


    }

    public void testLongestSubstring() {
        CommonSolution commonSolution = new CommonSolution();
        String s = "aaabb";
        Assert.assertEquals(3, commonSolution.longestSubstring(s, 3));
        s = "ababbc";
        Assert.assertEquals(5, commonSolution.longestSubstring(s, 2));
        s = "bbaaacbd";
        Assert.assertEquals(3, commonSolution.longestSubstring(s, 3));
    }

    public void testNumberOfArithmeticSlices() {
        CommonSolution commonSolution = new CommonSolution();
        int[] nums = new int[]{1,2,3,4};
        Assert.assertEquals(3, commonSolution.numberOfArithmeticSlices(nums));
        nums = new int[]{1,2,3,8,9,10};
        Assert.assertEquals(2, commonSolution.numberOfArithmeticSlices(nums));
    }
}
package dp;

import SlidingWindow.SubArrayCounter;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class SubArrayCounterTest extends TestCase {

    @Test
    public void testArrCnt1(){
        SubArrayCounter subArrayCounter = new SubArrayCounter();
        int[] nums = new int[]{1,3,2,3,3};
        long counted = subArrayCounter.countSubarrays(nums, 2);
        Assert.assertEquals(6, counted);
    }
    @Test
    public void testArrCnt2(){
        SubArrayCounter subArrayCounter = new SubArrayCounter();
        int[] nums = new int[]{1,4,2,1};
        long counted = subArrayCounter.countSubarrays(nums, 3);
        Assert.assertEquals(0, counted);
    }

}
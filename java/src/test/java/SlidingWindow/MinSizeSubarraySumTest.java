package SlidingWindow;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinSizeSubarraySumTest {

    @Test
    public void minSubArrayLen() {
        MinSizeSubarraySum obj = new MinSizeSubarraySum();
        int[] nums = {2,3,1,2,4,3};
        System.out.println(Integer.toString(obj.minSubArrayLen(7, nums)));
    }
}
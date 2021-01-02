package heap;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MaxSlidingWindow_239Test {

    @Test
    public void maxSlidingWindow() {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        MaxSlidingWindow_239 obj = new MaxSlidingWindow_239();
        int[] res = obj.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(res));
    }
}
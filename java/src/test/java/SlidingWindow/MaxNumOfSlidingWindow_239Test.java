package SlidingWindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MaxNumOfSlidingWindow_239Test {

    @Test
    public void maxSlidingWindow() {
        MaxNumOfSlidingWindow_239 util = new MaxNumOfSlidingWindow_239();
        int[] res = util.maxSlidingWindow2(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        System.out.println(Arrays.toString(res));
        Assert.assertArrayEquals(new int[]{3,3,5,5,6,7}, res);


    }
}
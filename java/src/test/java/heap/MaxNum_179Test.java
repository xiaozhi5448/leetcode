package heap;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxNum_179Test {

    @Test
    public void largestNumber() {
        MaxNum_179 util = new MaxNum_179();
        int[] nums = new int[]{3,30,34,5,9};
        String res = util.largestNumber2(nums);
        System.out.println(res);
        Assert.assertEquals(res, "9534330");


    }
}
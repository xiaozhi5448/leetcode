package dp;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LargestDivisibleSubset_368Test {

    @Test
    public void largestDivisibleSubset() {
        int[] nums = new int[]{1,2,4,8};
        LargestDivisibleSubset_368 util = new LargestDivisibleSubset_368();
        List<Integer> res = util.largestDivisibleSubset(nums);
        System.out.println(res.toString());

        nums = new int[]{1,2,3};
        res = util.largestDivisibleSubset(nums);
        System.out.println(res.toString());
    }
}
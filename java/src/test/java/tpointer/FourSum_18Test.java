package tpointer;

import junit.framework.TestCase;

import java.util.Collections;
import java.util.List;

public class FourSum_18Test extends TestCase {

    public void testFourSum() {
        FourSum_18 util = new FourSum_18();
        int[] nums = {1,0,-1,0,-2,2};
        List<List<Integer>> res = util.fourSum(nums, 0);
        System.out.println(res.toString());
    }
}
package sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class Duplicated3_220Test {

    @Test
    public void containsNearbyAlmostDuplicate() {
        Duplicated3_220 util = new Duplicated3_220();
        int[] nums = new int[]{1,5,9,1,5,9};
        boolean res = util.containsNearbyAlmostDuplicate(nums, 2, 3);
        System.out.println(res);

        nums = new int[]{-3,3,-6};
        res = util.containsNearbyAlmostDuplicate(nums, 2, 3);
        System.out.println(res);
    }
}
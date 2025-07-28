package sort;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearch_35Test {

    @Test
    public void searchInsert() {
        BinarySearch_35 util = new BinarySearch_35();
        int[] nums = new int[]{1,3};
        int res = util.searchInsert(nums, 3);
        System.out.println(res);
        Assert.assertEquals(1, res);

        nums  = new int[]{1,3,5,6};
        int index = util.searchInsert(nums, 2);
        Assert.assertEquals(1, index);
    }
}
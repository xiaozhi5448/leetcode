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
        Assert.assertEquals(res, 1);
    }
}
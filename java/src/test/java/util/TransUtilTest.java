package util;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TransUtilTest {

    @Test
    public void transStrToList() {
        TransUtil util = new TransUtil();
        List<Integer> nums = util.convertStrToList("[1,2,3]");
        System.out.println(nums.toString());
        Assert.assertEquals(nums instanceof List, true);
        List<List<Integer>> nums2 = util.convertStrToList2("[[1,2,3] , [4,5,6]]");
        System.out.println(nums2.toString());
    }
}
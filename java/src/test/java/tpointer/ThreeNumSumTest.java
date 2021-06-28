package tpointer;

import org.junit.Test;
import util.TransUtil;

import java.util.List;

import static org.junit.Assert.*;

public class ThreeNumSumTest {

    @Test
    public void threeSum() {
        ThreeNumSum util = new ThreeNumSum();
        List<List<Integer>> res = util.threeSum(TransUtil.convertStrToArr("[-1,0,1,2,-1,-4]"));
        System.out.println(res.toString());
    }
}
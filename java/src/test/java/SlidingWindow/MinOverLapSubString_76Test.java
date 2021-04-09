package SlidingWindow;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinOverLapSubString_76Test {

    @Test
    public void test(){
        MinOverLapSubString_76 util = new MinOverLapSubString_76();
        String res1 = util.minWindow( "ADOBECODEBANC", "ABC");
        System.out.println(res1);
        Assert.assertEquals(res1, "BANC");
        String res2 = util.minWindow("a", "a");
        System.out.println(res2);
        Assert.assertEquals(res2, "a");
        Assert.assertEquals(util.minWindow("a", "b"), "");
    }

}
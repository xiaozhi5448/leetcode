package dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeSplitII_132Test {

    @Test
    public void minCut() {
        PalindromeSplitII_132 util = new PalindromeSplitII_132();
        int res = util.minCut("aab");
        System.out.println(res);
    }
}
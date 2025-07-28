package dp;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;

public class CommonSolutionTest extends TestCase {

    public void testWordBreak() {
        CommonSolution commonSolution = new CommonSolution();
        boolean b = commonSolution.wordBreak("dogs", Arrays.asList("dog","s","gs"));
        Assert.assertTrue(b);
    }

    public void testLTS(){
        CommonSolution commonSolution = new CommonSolution();
        int len = commonSolution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
        Assert.assertEquals(4, len);
    }
}
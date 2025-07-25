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
}
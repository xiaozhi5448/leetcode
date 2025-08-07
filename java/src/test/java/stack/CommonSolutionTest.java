package stack;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;

public class CommonSolutionTest extends TestCase {

    public void testDailyTemperatures() {
        CommonSolution commonSolution = new CommonSolution();
        int[] temperatures = commonSolution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        Assert.assertArrayEquals(temperatures, new int[]{1, 1, 4, 2, 1, 1, 0, 0});
    }
}
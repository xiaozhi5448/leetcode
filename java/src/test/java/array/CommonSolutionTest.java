package array;

import junit.framework.TestCase;
import org.junit.Assert;

public class CommonSolutionTest extends TestCase {

    public void testCountHillValley() {
        CommonSolution commonSolution = new CommonSolution();
        int res = commonSolution.countHillValley(new int[]{6, 6, 5, 5, 4, 1});
        Assert.assertEquals(3, res);
    }
}
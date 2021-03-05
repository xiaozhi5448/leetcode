package UnionSet;

import dp.MinCostClimb_746;
import junit.framework.TestCase;

public class MinCost_1631Test extends TestCase {

    public void testMinimumEffortPath() {
        MinCost_1631 util = new MinCost_1631();
        int[][] heights = {{4,3,4,10,5,5,9,2},{10,8,2,10,9,7,5,6},{5,8,10,10,10,7,4,2},{5,1,3,1,1,3,1,9},{6,4,10,6,10,9,4,6}};
        int res = util.minimumEffortPath(heights);
        System.out.println(res);
    }
}
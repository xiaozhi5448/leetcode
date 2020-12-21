package dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinCostClimb_746Test {

    @Test
    public void minCostClimbingStairs() {
        MinCostClimb_746 obj = new MinCostClimb_746();
        int[] cost1 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int res = obj.minCostClimbingStairs(cost1);
        int[] cost2 = {0,1,1,0};

        System.out.println(res);
        System.out.println(obj.minCostClimbingStairs(cost2));
    }
}
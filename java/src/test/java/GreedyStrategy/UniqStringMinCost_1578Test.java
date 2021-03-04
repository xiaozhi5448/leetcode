package GreedyStrategy;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniqStringMinCost_1578Test {

    @Test
    public void minCost() {
        int[] costs = new int[]{1,2,3,4,1};
        UniqStringMinCost_1578 obj = new UniqStringMinCost_1578();
        int res = obj.minCost("aabaa", costs);
        System.out.println(res);
    }
}
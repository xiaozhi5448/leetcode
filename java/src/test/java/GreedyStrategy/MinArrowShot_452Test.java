package GreedyStrategy;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinArrowShot_452Test {

    @Test
    public void findMinArrowShots() {
        MinArrowShot_452 obj = new MinArrowShot_452();
        int[][]tests = new int[2][2];
        tests[0] = new int[]{-2147483646,-2147483645};
        tests[1] = new int[]{2147483646,2147483647};
        int res = obj.findMinArrowShots(tests);
        System.out.println(res);

    }
}
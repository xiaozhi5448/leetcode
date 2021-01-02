package GreedyStrategy;

import org.junit.Test;

import static org.junit.Assert.*;

public class OverlapInterval_435Test {

    @Test
    public void eraseOverlapIntervals() {
        OverlapInterval_435 obj = new OverlapInterval_435();
        int[][] tests = new int[][]{{1,2},{2,3},{3,4},{-100,-2},{5,7}};
        int res = obj.eraseOverlapIntervals(tests);
        System.out.println(res);
    }
}
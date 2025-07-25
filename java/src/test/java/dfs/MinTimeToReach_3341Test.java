package dfs;

import junit.framework.TestCase;
import org.junit.Assert;

public class MinTimeToReach_3341Test extends TestCase {

    public void testMinTimeToReach() {
        MinTimeToReach_3341 minTimeToReach3341 = new MinTimeToReach_3341();
        int[][] grid = new int[][]{{0,4}, {4, 4}};
        int reach = minTimeToReach3341.minTimeToReach(grid);
        Assert.assertEquals(6, reach);
        grid = new int[][]{{0,0,0}, {0,0,0}};
        reach = minTimeToReach3341.minTimeToReach(grid);
        Assert.assertEquals(3, reach);
        grid = new int[][]{{0, 1}, {1, 2}};
        reach = minTimeToReach3341.minTimeToReach(grid);
        Assert.assertEquals(3, reach);
    }
    public void testMinTimeToReachWithLength() {
        MinTimeToReach_3341 minTimeToReach3341 = new MinTimeToReach_3341();
        int[][] grid = new int[][]{{0,4}, {4, 4}};
        int reach = minTimeToReach3341.minTimeToReach2(grid);
        Assert.assertEquals(7, reach);
        grid = new int[][]{{0,0,0}, {0,0,0}};
        reach = minTimeToReach3341.minTimeToReach2(grid);
        Assert.assertEquals(4, reach);
        grid = new int[][]{{0, 1}, {1, 2}};
        reach = minTimeToReach3341.minTimeToReach2(grid);
        Assert.assertEquals(4, reach);
        grid = new int[][]{{0, 58}, {27, 69}};
        Assert.assertEquals(71, minTimeToReach3341.minTimeToReach2(grid));
    }
}
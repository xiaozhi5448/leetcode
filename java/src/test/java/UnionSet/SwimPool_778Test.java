package UnionSet;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwimPool_778Test {

    @Test
    public void swimInWater() {
        SwimPool_778 util = new SwimPool_778();
        int[][] grid = new int[][]{{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        int res = util.swimInWater(grid);
        System.out.println(res);

        grid = new int[][]{{0,2}, {1,3}};
        res = util.swimInWater(grid);
        System.out.println(res);
    }
}
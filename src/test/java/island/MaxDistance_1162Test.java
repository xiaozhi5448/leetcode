package island;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxDistance_1162Test {

    @Test
    public void maxDistance() {
        int[][] grid = {
                {1,0,1},
                {0,0,0},
                {1,0,1}
        };
        MaxDistance_1162 obj = new MaxDistance_1162();
        int res = obj.maxDistance(grid);
        System.out.println(res);
    }
}
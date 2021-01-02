package island;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxPerimeter_463Test {

    @Test
    public void islandPerimeter() {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        MaxPerimeter_463 obj = new MaxPerimeter_463();
        int res = obj.islandPerimeter(grid);
        System.out.println(res);
    }
}
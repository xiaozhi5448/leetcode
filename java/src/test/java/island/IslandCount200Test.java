package island;

import org.junit.Test;

public class IslandCount200Test {

    @Test
    public void numIslands() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1',  '0', '0'},
                {'0', '0', '0',  '1',  '1'}
        };
        IslandCount_200 obj = new IslandCount_200();
        int res = obj.numIslands(grid);
        System.out.println(res);
    }
}
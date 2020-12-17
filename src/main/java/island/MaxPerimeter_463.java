package island;

public class MaxPerimeter_463 {
    int perimeter = 0;
    private void mark(int[][] grid, boolean[][] visited, int row, int col){
        if(row <0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return;
        }else if(visited[row][col]){
            return;
        }else {
            if(!visited[row][col] && grid[row][col] == 1){
                if(col - 1 < 0){
                    perimeter ++;
                }else{
                    if(grid[row][col - 1] == 0){
                        perimeter++;
                    }
                }
                if(col + 1 >= grid[0].length){
                    perimeter++;
                }else{
                    if(grid[row][col + 1] == 0){
                        perimeter++;
                    }
                }
                if(row - 1 < 0){
                    perimeter++;
                }else{
                    if(grid[row-1][col] ==0){
                        perimeter++;
                    }
                }
                if(row + 1 >= grid.length){
                    perimeter++;
                }else{
                    if(grid[row+1][col] == 0){
                        perimeter++;
                    }
                }

            }

        }
        visited[row][col] = true;
        mark(grid, visited, row, col-1);
        mark(grid, visited, row, col+1);
        mark(grid, visited, row-1, col);
        mark(grid, visited, row+1, col);
    }
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        perimeter = 0;
        mark(grid, visited, 0, 0);
        return perimeter;
    }
}

package island;

public class MaxArea_605 {
    private int area;
    private int max_area;
    private void mark(int i, int j, int[][] grid, boolean[][] visited){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        }
        if(visited[i][j]){
            return;
        }
        if(grid[i][j] == 1){
            area+=1;
        }else{
            return;
        }
        visited[i][j] = true;
        mark(i, j+1, grid, visited);
        mark(i, j-1, grid, visited);
        mark(i+1, j, grid, visited);
        mark(i-1, j, grid, visited);
    }
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    this.area = 0;
                    mark(i, j, grid, visited);
                    this.max_area = this.max_area > this.area? this.max_area: this.area;
                }
            }
        }
        return this.max_area;
    }
}

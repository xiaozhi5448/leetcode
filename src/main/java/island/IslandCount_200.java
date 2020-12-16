package island;

public class IslandCount_200 {
    public void mark(int i, int j, boolean[][] visited, char[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        if(visited[i][j]){
            return;
        }
        if(grid[i][j] == '1'){
            visited[i][j] = true;
        }else{
            return;
        }
        mark(i, j+1, visited, grid);
        mark(i + 1, j, visited, grid);
        mark(i - 1, j, visited, grid);
        mark(i, j - 1, visited, grid);
    }
    public int numIslands(char[][] grid) {
        int res = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0;i<grid.length ; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    mark(i, j, visited, grid);
                    res++;
                }
            }
        }
        return res;
    }
}

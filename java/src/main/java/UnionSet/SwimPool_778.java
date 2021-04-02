package UnionSet;

/**
 * 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
 *
 * 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。
 * 你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。
 * 假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
 *
 * 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？
 *
 */

public class SwimPool_778 {

    public int swimInWater(int[][] grid) {
        int N = grid.length;
        if(N == 0){
            return -1;
        }
        UnionFind uf = new UnionFind(N*N);
        boolean[][] visited = new boolean[N][N];
        int t = Math.max(grid[0][0], grid[N-1][N-1]);
        while(true){
            for(int row = 0; row < N; row++){
                for(int col = 0; col <N; col++){
                    if(visited[row][col] || grid[row][col] > t)
                        continue;
                    visited[row][col] = true;
                    if(row-1 > 0 && grid[row-1][col] <= t){
                        uf.union(row*N + col, (row-1)*N + col);
                    }
                    if(row+1 < N && grid[row+1][col] <= t){
                        uf.union(row*N+col, (row+1)*N + col);
                    }
                    if(col-1 > 0 && grid[row][col-1] <= t){
                        uf.union(row*N+col, row*N+col-1);
                    }
                    if(col+1 < N && grid[row][col+1] <= t){
                        uf.union(row*N+col, row*N + col+1);
                    }
                }
            }
            int p1 = uf.find(0);
            int p2 = uf.find(N*N-1);
            if(p1 == p2){
                break;
            }
            t++;
        }
        return t;

    }
}

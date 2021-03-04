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
    private int parent(int[] nodes, int node){
        int node_ptr = node;
        while(nodes[node_ptr]!= node_ptr){
            node_ptr = nodes[node_ptr];
        }
        int root = node_ptr;
        node_ptr = node;
        while(node_ptr != root){
            int parent = nodes[node_ptr];
            nodes[node_ptr] = root;
            node_ptr = parent;
        }
        return root;
    }

    private boolean merge(int[] parents, int node1, int node2){
        int p1 = parent(parents, node1);
        int p2 = parent(parents, node2);
        if(p1 == p2){
            return false;
        }else{
            parents[p1] = p2;
            return true;
        }
    }

    public int swimInWater(int[][] grid) {
        int rowCount = grid.length;
        if(rowCount>0){
            int colCount = grid[0].length;
            int[] nodes = new int[rowCount*colCount];
            boolean[] visited = new boolean[nodes.length];
            for(int i = 0; i < nodes.length; i++){
                nodes[i] = i;
                visited[i] = false;
            }
            int t = Math.max(grid[0][0], grid[rowCount-1][colCount-1]);
            while(true){
                for(int row = 0; row < rowCount; row++){
                    for(int col =0 ; col <colCount; col++){
                        if(visited[row*rowCount+col]){
                            continue;
                        }
                        if(grid[row][col] <= t){
                            visited[row*rowCount+col] = true;
                            if(row-1>= 0 && grid[row-1][col] <= t)
                                merge(nodes, row*rowCount+col, (row-1)*rowCount+col);
                            if(row+1 < rowCount && grid[row+1][col] <= t){
                                merge(nodes, (row+1)*rowCount + col, row*rowCount+col);
                            }
                            if(col-1 >= 0 && grid[row][col-1] <= t){
                                merge(nodes, row*rowCount+col, row*rowCount + col-1);
                            }
                            if(col+1<colCount&&grid[row][col+1] <= t){
                                merge(nodes, row*rowCount+col, row*rowCount+col+1);
                            }
                        }
                    }
                }
                int p1 = parent(nodes, 0);
                int p2 = parent(nodes, rowCount*colCount-1);
                if(p1 == p2){
                    break;
                }
                t++;
            }
            return t;
        }
        return -1;
    }
}

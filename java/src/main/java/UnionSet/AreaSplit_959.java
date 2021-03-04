package UnionSet;

import java.util.HashSet;
import java.util.Set;

/**
 * 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
 *
 * （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
 *
 * 并查集：将每个方格看做上下左右四个三角
 */
public class AreaSplit_959 {
    private int parent(int[] parents, int node){
        int nodePtr = node;
        while(parents[nodePtr]!= nodePtr){
            nodePtr = parents[nodePtr];
        }
        int root = nodePtr;
        nodePtr = node;
        while(nodePtr != root){
            int parent = parents[nodePtr];
            parents[nodePtr] = root;
            nodePtr = parent;
        }
        return root;
    }

    private boolean merge(int[] parents, int n1, int n2){
        int p1 = parent(parents, n1);
        int p2 = parent(parents, n2);
        if(p1 == p2){
            return false;
        }else{
            parents[p1] = p2;
            return true;
        }
    }

    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        int[] parents = new int[N*N*4];
        for(int i = 0; i<parents.length;i++){
            parents[i] = i;
        }
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < N; col++){
                char ch = grid[row].charAt(col);
                int base = (row*N + col)*4;
                if(ch == '/'){
                    // merge 0,3 and 1,2
                    merge(parents, base, base + 3);
                    merge(parents, base+1, base+2);
                }else if(ch == '\\'){
                    // merge 0,1 and 2,3
                    merge(parents, base, base+1);
                    merge(parents, base+2, base+3);
                }else{
                    merge(parents, base, base+1);
                    merge(parents, base+1, base+2);
                    merge(parents, base+2, base+3);
                }
            }
        }
        for(int row=0; row < grid.length; row++){
            for(int col = 0; col < N; col++){
                int base = (row*N+col)*4;
                if(col+1<N){
                    merge(parents, base+1, (row*N+col+1)*4 + 3);
                }
                if(row+1 < N){
                    merge(parents, base + 2, ((row+1)*N+col)*4);
                }
            }
        }
        int count=0;
        for(int i = 0; i < parents.length; i++){
            if(parents[i] == i){
                count++;
            }
        }
        return count;
    }
}

package island;
import java.util.*;

/**
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。
 * 若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。
 * 编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 *
 */
public class AreaSize_19 {
    private int dfs(int[][] land, boolean[][] visited,  int row, int col){

        if(row < 0 || col < 0 ||row >= land.length || col >= land[0].length ||  visited[row][col] || land[row][col] != 0){
            return 0;
        }
        int res = 1;
        visited[row][col] = true;
        for(int i = row-1; i <= row+1; i++){
            for(int j = col - 1; j <= col+1; j ++){
                if(i >= land.length || j >= land[0].length){
                    continue;
                }
                res += dfs(land, visited, i,j);
            }
        }
        return res;
    }
    public int[] pondSizes(int[][] land) {
        if (land.length == 0) {
            return new int[0];
        }
        List<Integer> res = new LinkedList<>();
        boolean[][] visited = new boolean[land.length][land[0].length];
        for (int i = 0; i < land.length; i++)
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0 && !visited[i][j]) {
                    res.add(dfs(land, visited, i, j));
                }
            }
        return res.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}

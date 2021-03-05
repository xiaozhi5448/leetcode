package UnionSet;

import java.util.*;

/**
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，
 * 其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，
 * 且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。
 * 你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 *
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 *
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 *
 */
public class MinCost_1631 {
    private int parent(int[] parents, int node) {
        int nodePtr = node;
        while (parents[nodePtr] != nodePtr) {
            nodePtr = parents[nodePtr];
        }
        int root = nodePtr;
        nodePtr = node;
        while (nodePtr != root) {
            int parent = parents[nodePtr];
            parents[nodePtr] = root;
            nodePtr = parent;
        }
        return root;
    }

    private boolean merge(int[] parents, int n1, int n2) {
        int p1 = parent(parents, n1);
        int p2 = parent(parents, n2);
        if (p1 == p2) {
            return false;
        } else {
            parents[p1] = p2;
            return true;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int rowCount = heights.length;
        if (rowCount > 0) {
            int colCount = heights[0].length;
            int[] parents = new int[rowCount * colCount];
            if(parents.length<=1){
                return 0;
            }
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    if (j + 1 < colCount) {
                        edges.add(new int[]{i * colCount + j, i * colCount + j + 1, Math.abs(heights[i][j] - heights[i][j + 1])});
                    }
                    if (i + 1 < rowCount) {
                        edges.add(new int[]{i * colCount + j, (i + 1) * colCount + j, Math.abs(heights[i][j] - heights[i + 1][j])});
                    }
                }
            }
            Collections.sort(edges, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2];
                }
            });
            for (int[] edge : edges) {
                if (merge(parents, edge[0], edge[1])) {
                    int p1 = parent(parents, 0);
                    int p2 = parent(parents, parents.length - 1);
                    if (p1 == p2) {
                        return edge[2];
                    }
                }
            }
            return Integer.MAX_VALUE;
        }
        return 0;

    }
}

package UnionSet;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 *
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 *
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 *
 * 使用并查集检查集合连通性
 * 使用kruskal算法得到最小生成树
 */
public class Mst_1584 {
    private int distance(int[] p1, int[] p2){
        return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
    }

    private int parent(int[] parents, int point){
        int p = point;
        while(parents[p] != p){
            p = parents[p];
        }
        int root = p;
        p = point;
        while(p != root){
            int tmp = parents[p];
            parents[p] = root;
            p = tmp;
        }
        return root;
    }

    private boolean merge(int[] parents, int point1, int point2){
        int p1 = parent(parents, point1);
        int p2 = parent(parents, point2);
        if(p1 == p2){
            return false;
        }else{
            parents[p1] = p2;
            return true;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int count = points.length;
        int[][] edges = new int[count*(count-1)/2][2];
        int index = 0;
        for(int i = 0; i < count; i++){
            for(int j = i+1; j < count; j++){
                edges[index][0] = i;
                edges[index][1] = j;
                index++;
            }
        }
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return distance(points[o1[0]], points[o1[1]]) - distance(points[o2[0]],
                        points[o2[1]]);
            }
        });
        int[] parents = new int[points.length];
        for(int i = 0; i < points.length; i++){
            parents[i] = i;
        }
        int edgeCount = 0;
        int cost = 0;
        for(int[] edge: edges){
            if(merge(parents, edge[0], edge[1])){
                edgeCount++;
                cost += distance(points[edge[0]], points[edge[1]]);
                if(edgeCount == count-1){
                    break;
                }
            }
        }
        return cost;

    }
}

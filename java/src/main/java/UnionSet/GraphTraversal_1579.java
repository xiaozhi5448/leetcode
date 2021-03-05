package UnionSet;

import java.util.Arrays;

/**
 * Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3  种类型的边：
 *
 *     类型 1：只能由 Alice 遍历。
 *     类型 2：只能由 Bob 遍历。
 *     类型 3：Alice 和 Bob 都可以遍历。
 *
 * 给你一个数组 edges ，其中 edges[i] = [typei, ui, vi] 表示节点 ui 和 vi 之间存在类型为 typei 的双向边。
 * 请你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。
 * 如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，
 * 则认为图是可以完全遍历的。
 *
 * 返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。
 *
 * 先处理公共边，再分别处理alice和bob的图
 */
public class GraphTraversal_1579 {
    private int parent(int[] parents, int node){
        int nodePtr = node;
        while(parents[nodePtr] != nodePtr){
            nodePtr = parents[nodePtr];
        }
        int root = nodePtr;
        nodePtr = node;
        while(nodePtr!= root){
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

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] parents = new int[n];
        for(int i = 0; i< parents.length; i++)
            parents[i] = i;
        int removal = 0;
        for(int i = 0; i < edges.length; i++){
            if(edges[i][0] == 3){
                if(!merge(parents, edges[i][1]-1, edges[i][2]-1)){
                    removal++;
                }
            }
        }
        int[] aliceParents = Arrays.copyOf(parents, parents.length);
        for(int i = 0; i < edges.length; i++){
            if(edges[i][0] == 1){
                if(!merge(aliceParents, edges[i][1]-1, edges[i][2]-1)){
                    removal++;
                }
            }
        }
        int rootCount = 0;
        for(int i = 0; i< aliceParents.length; i++){
            if(aliceParents[i] == i)
                rootCount++;
        }
        if(rootCount>1){
            return -1;
        }

        for(int i = 0; i< edges.length; i++){
            if(edges[i][0] == 2){
                if(!merge(parents, edges[i][1]-1, edges[i][2]-1)){
                    removal++;
                }
            }
        }
        rootCount=0;
        for(int i = 0; i< parents.length;i++){
            if(parents[i] == i){
                rootCount++;
            }
        }
        if(rootCount>1){
            return -1;
        }
        return removal;
    }
}

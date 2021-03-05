package UnionSet;

/**
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，
 * 其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 *
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 *
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。
 * 请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1
 *
 */
public class JoinNetwork_1319 {
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
    public int makeConnected(int n, int[][] connections) {
        int[] parents = new int[n];
        for(int i = 0; i< parents.length; i++){
            parents[i] = i;
        }
        int duplicated = 0;
        for(int i = 0; i< connections.length; i++){
            if(!merge(parents, connections[i][0], connections[i][1])){
                duplicated++;
            }
        }
        int rootCount = 0;
        for(int i = 0; i< parents.length; i++)
            if(parents[i]==i)
                rootCount++;
        if(rootCount -1 > duplicated){
            return -1;
        }else{
            return rootCount-1;
        }
    }
}

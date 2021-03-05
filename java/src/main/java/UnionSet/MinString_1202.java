package UnionSet;
import java.util.*;

/**
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 *
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 *
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 *
 *
 * 各个连通分量分别排序，使用堆排序
 */
public class MinString_1202 {
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

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int length = s.length();
        char[] original = s.toCharArray();
        int[] parents = new int[length];
        for(int i = 0; i<parents.length; i++){
            parents[i] = i;
        }
        if(length <= 1){
            return s;
        }
        HashMap<Integer, PriorityQueue<Character>> roots = new HashMap<>();
        for(List<Integer> pair: pairs){
            merge(parents, pair.get(0), pair.get(1));
        }
        for(int i = 0; i < parents.length ; i++){
            int p = parent(parents, i);
            roots.computeIfAbsent(p, key -> new PriorityQueue<>()).offer(original[i]);
        }
        char[] res = new char[original.length];
        for(int i = 0; i < original.length; i++){
            int p = parent(parents, i);
            res[i] = roots.get(p).poll();
        }
        return new String(res);
    }
}

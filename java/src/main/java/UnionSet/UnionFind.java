package UnionSet;

import java.util.LinkedList;
import java.util.List;

public class UnionFind {
    int[] parent;
    public UnionFind(int n){
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    public int find(int n){
        int parentPtr = n;
        while(parentPtr != parent[parentPtr]){
            parentPtr = parent[parentPtr];
        }
        int root = parentPtr;
        parentPtr = n;
        while(parent[parentPtr] != root){
            int tmp = parent[parentPtr];
            parent[parentPtr] = root;
            parentPtr = tmp;
        }
        return root;
    }

    public boolean union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 == p2){
            return false;
        }else{
            parent[p1] = p2;
            return true;
        }
    }

    public List<Integer> parents(){
        List<Integer> res = new LinkedList<>();
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == i){
                res.add(i);
            }
        }
        return res;
    }

    public int setCount(){
        int res = 0;
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == i)
                res++;
        }
        return res;
    }
}

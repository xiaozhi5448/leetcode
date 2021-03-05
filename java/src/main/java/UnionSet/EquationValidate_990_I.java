package UnionSet;

class UnionSet{
    int[] parents;
    public UnionSet(int size){
        parents = new int[size];
        for(int i = 0; i< size; i++){
            parents[i] = i;
        }
    }

    int parent(int node){
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

    boolean union(int n1, int n2){
        int p1 = parent(n1);
        int p2 = parent(n2);
        if(p1 == p2){
            return false;
        }else{
            parents[p1] = p2;
            return true;
        }
    }
    int disjointCount(){
        int ret = 0;
        for(int i = 0; i < parents.length; i++){
            if(i == parents[i]){
                ret++;
            }
        }
        return ret;
    }
}

public class EquationValidate_990_I {

    public boolean equationsPossible(String[] equations) {
        UnionSet unionSet = new UnionSet(26);
        for(String eq: equations){

            if(eq.charAt(1) == '='){
                char ch1 = eq.charAt(0);
                char ch2 = eq.charAt(3);
                unionSet.union(ch1-'a', ch2-'a');
            }
        }
        for(String eq: equations){
            if(eq.charAt(1) == '!'){
                if(unionSet.parent(eq.charAt(0)-'a') == unionSet.parent(eq.charAt(3)-'a')){
                    return false;
                }
            }
        }
        return true;
    }
}

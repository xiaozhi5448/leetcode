package UnionSet;

/**
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，
 * 并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），
 * 表示单字母变量名。
 *
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
 *
 */
class EquationValidator {

    private int parent(int[] parents, int index){
        int index_ptr = index;
        while(parents[index_ptr] != index_ptr){
            index_ptr = parents[index_ptr];
        }
        int root_index = index_ptr;
        index_ptr = index;
        int parent_index = -1;
        while(index_ptr != root_index){
            parent_index = parents[index_ptr];
            parents[index_ptr] = root_index;
            index_ptr = parent_index;
        }
        return root_index;
    }

    private boolean merge(int[] parents, int index1, int index2){
        int p1 = parent(parents, index1);
        int p2 = parent(parents, index2);
        if(p1 == p2){
            return false;
        }else{
            parents[p1] = p2;
            return true;
        }
    }

    public boolean equationsPossible(String[] equations) {
        int[] parents = new int[26];
        for(int i =0; i< 26;i++){
            parents[i] = i;
        }
        for(String equation:equations){
            if(equation.charAt(1) == '='){
                merge(parents, equation.charAt(0)-'a', equation.charAt(3)-'a');
            }
        }
        for(String equation:equations){
            if(equation.charAt(1) == '!'){
                int p1 = parent(parents, equation.charAt(0)-'a');
                int p2 = parent(parents, equation.charAt(3)-'a');
                if(p1 == p2){
                    return false;
                }
            }
        }
        return true;
    }
}

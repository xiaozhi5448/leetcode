package dfs;

import java.util.LinkedList;
import java.util.List;

public class GenerateBrackets_22 {

    private void dfs(List<String> res, String current, int leftRemainder, int rightRemainder){
        if(leftRemainder == 0 && rightRemainder == 0){
            res.add(current);
        }
        if(leftRemainder < rightRemainder){
            if(leftRemainder>0)
                dfs(res, current+"(", leftRemainder-1, rightRemainder);
            if(rightRemainder > 0){
                dfs(res, current+")", leftRemainder, rightRemainder-1);
            }
        }else{
            if(leftRemainder > 0){
                dfs(res, current + "(", leftRemainder-1, rightRemainder);
            }
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        dfs(res, "", n, n);
        return res;
    }
}

package dfs.combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 当前元素可以选择，可以不选择，如果不选择，index直接加一，如果选择，index不变
 *
 */
public class CombCount_39 {

    private void dfs(int[] candidates, int index, int remainder, List<List<Integer>> res, List<Integer> comb){
        if(index >= candidates.length || remainder < 0){
            return;
        }else if(remainder == 0){
            res.add(new ArrayList<>(comb));
        }else{
            dfs(candidates, index+1, remainder, res, comb);
            comb.add(candidates[index]);
            dfs(candidates, index, remainder- candidates[index], res, comb);
            comb.remove(comb.size()-1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new LinkedList<>();
        dfs(candidates, 0, target, res, comb);
        return res;
    }
}

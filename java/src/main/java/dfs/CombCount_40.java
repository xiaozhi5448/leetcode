package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 */
public class CombCount_40 {
    private void dfs(int[] nums, int index, int remainder, List<List<Integer>> res, List<Integer> comb){
        if(remainder == 0){
            res.add(new ArrayList<Integer>(comb));
        }else if(index >= nums.length || remainder < 0){
            return;
        }else{
            for(int i = index; i < nums.length; i++){
                if(i > index && nums[i] == nums[i-1])
                    continue;
                comb.add(nums[i]);
                dfs(nums, i+1, remainder - nums[i], res, comb);
                comb.remove(comb.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        dfs(candidates, 0, target, res, new LinkedList<Integer>());
        return res;
    }
}

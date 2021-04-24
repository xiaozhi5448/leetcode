package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字
 */
public class CombCount_216 {
    private void dfs(int[] nums, int index, int remainder, List<Integer> comb, List<List<Integer>> res, int k){
        if(remainder == 0 && comb.size() == k){
            res.add(new ArrayList<>(comb));
        }else if(remainder < 0 || comb.size() >= k){
            return;
        }else{
            for(int i = index; i < nums.length; i++){
                comb.add(nums[i]);
                dfs(nums, i+1, remainder - nums[i], comb, res, k);
                comb.remove(comb.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(new int[]{1,2,3,4,5,6,7,8,9}, 0, n, new LinkedList<>(), res, k);
        return res;
    }
}

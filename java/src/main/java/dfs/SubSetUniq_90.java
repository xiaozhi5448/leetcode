package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 找到所有不重复的子集
 */
public class SubSetUniq_90 {
    private void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> subset){
        if(index <= nums.length){
            res.add(new ArrayList<>(subset));
        }
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            subset.add(nums[i]);
            dfs(nums, i+1, res, subset);
            subset.remove(subset.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> subset = new LinkedList<>();
        dfs(nums, 0, res, subset);
        return res;
    }
}

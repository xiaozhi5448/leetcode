package dfs;
import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class SubSet_78 {
    private void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> subset){
        if(index == nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }else{
            // 不选择当前元素
            dfs(nums, index+1, res, subset);
            // 选择当前元素
            subset.add(nums[index]);
            dfs(nums, index+1, res, subset);
            subset.remove(subset.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> set = new LinkedList<>();
        dfs(nums, 0, res, set);
        return res;
    }
}

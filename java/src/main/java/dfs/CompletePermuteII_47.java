package dfs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 排序之后dfs，注意每轮选择的时候相同元素只能选择一次
 */
public class CompletePermuteII_47 {

    private void dfs(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> rank){
        if(rank.size() == nums.length){
            res.add(new ArrayList<>(rank));
        }else{
            for(int i = 0; i< nums.length; i++){
                if(!visited[i]){
                    if( i>0 &&!visited[i-1] && nums[i] == nums[i-1]){
                        continue;
                    }
                    visited[i] = true;
                    rank.add(nums[i]);
                    dfs(nums, visited, res, rank);
                    visited[i] = false;
                    rank.remove(rank.size()-1);
                }
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> rank = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, res, rank);
        return res;
    }
}

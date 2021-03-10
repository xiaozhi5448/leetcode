package dfs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class CompletePermute_46 {
    private void dfs(int[] nums, List<List<Integer>> res, boolean[] visited, List<Integer> rank){
        // 选择完成 rank.size() == nums.size()
        if(rank.size() == nums.length){
            res.add(new ArrayList<>(rank));
        }else{
            for(int i = 0; i < nums.length; i++){
                // 如果nums[i]没有选择过
                if(!visited[i]){
                    visited[i] = true;
                    rank.add(nums[i]);
                    dfs(nums, res, visited, rank);
                    visited[i] = false;
                    rank.remove(rank.size()-1);
                }
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> rank = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, res, visited, rank);
        return res;
    }
}

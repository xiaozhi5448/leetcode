package dfs;

public class CombCount_377 {
    int res = 0;
    private void dfs(int[] nums, int index, int remainder){
        if(remainder == 0){
            res++;
        }else if(remainder < 0 || index >= nums.length){
            return;
        }else{
            for(int i = 0; i < nums.length; i++){
                dfs(nums, i, remainder - nums[i]);
            }
        }
    }
    public int combinationSum4(int[] nums, int target) {
        res = 0;
        dfs(nums, 0, target);
        return res;
    }
}

package dfs.combination;

import java.util.*;
import java.util.stream.Collectors;

public class CommonSolution {

    /**
     * 78. 子集
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     *
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     *
     * 输入：nums = [0]
     * 输出：[[],[0]]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * nums 中的所有元素 互不相同
     * @param nums
     * @param index
     * @param subset
     * @param result
     */
    private void permute(int[] nums, int index, List<Integer> subset, List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        permute(nums, index+1, subset, result);
        subset.add(nums[index]);
        permute(nums, index+1, subset, result);
        subset.remove(subset.size()-1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        permute(nums, 0, new ArrayList<>(), results);
        return results;
    }


    /**
     * 17. 电话号码的字母组合
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     *
     *
     *
     *
     * 示例 1：
     *
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * 示例 2：
     *
     * 输入：digits = ""
     * 输出：[]
     * 示例 3：
     *
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     * @param digits
     * @return
     */
    static Map<Integer, String> numAlpha = new HashMap<>();
    {
        numAlpha.put(2, "abc");
        numAlpha.put(3, "def");
        numAlpha.put(4, "ghi");
        numAlpha.put(5, "jkl");
        numAlpha.put(6, "mno");
        numAlpha.put(7, "pqrs");
        numAlpha.put(8, "tuv");
        numAlpha.put(9, "wxyz");
    }
    
    private void permute(String digits, int index, List<String> comb, List<String> results){
        if(index == digits.length()){
            String collect = String.join("", comb);
            results.add(collect);
            return;
        }
        String item = numAlpha.get(index);
        for(int i = 0; i < item.length(); i++){
            comb.add(String.valueOf(item.charAt(i)));
            permute(digits, index + 1, comb, results);
            comb.remove(comb.size() - 1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        permute(digits, 0, new ArrayList<>(), results);
        return results;
    }

    /**
     * 39. 组合总和
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     *
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     *
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     *
     *
     *
     * 示例 1：
     *
     * 输入：candidates = [2,3,6,7], target = 7
     * 输出：[[2,2,3],[7]]
     * 解释：
     * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
     * 7 也是一个候选， 7 = 7 。
     * 仅有这两种组合。
     * 示例 2：
     *
     * 输入: candidates = [2,3,5], target = 8
     * 输出: [[2,2,2,2],[2,3,3],[3,5]]
     * 示例 3：
     *
     * 输入: candidates = [2], target = 1
     * 输出: []
     *
     *
     * 提示：
     *
     * 1 <= candidates.length <= 30
     * 2 <= candidates[i] <= 40
     * candidates 的所有元素 互不相同
     * 1 <= target <= 40
     */
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

    /**
     * 22. 括号生成
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     *
     * 输入：n = 1
     * 输出：["()"]
     *
     *
     * 提示：
     *
     * 1 <= n <= 8
     */
    public static class PairCount{
        List<String> items = new ArrayList<>();
        int leftCount;
        int rightCount;
        void dropLast(){
            if(items != null && !items.isEmpty()){
                String last = items.remove(items.size() - 1);
                if(last.equals("(")){
                    leftCount--;
                }
                if(last.equals(")")){
                    rightCount--;
                }
            }
        }
        void addPair(String p){
            if("(".equals(p)){
                leftCount++;
            }
            if(")".equals(p)){
                rightCount++;
            }
            items.add(p);
        }
        public int getLeftCount(){
            return leftCount;
        }

        public int getRightCount() {
            return rightCount;
        }

        public String toString(){
            if(items == null || items.size() == 0){
                return null;
            }
            return String.join("", items);
        }
    }

    private void combDfs(PairCount pCount, int total, int index, List<String> results){
        if(index == total * 2){
            results.add(pCount.toString());
            return;
        }
        if(pCount.getLeftCount() > pCount.getRightCount()){
            pCount.addPair(")");
            combDfs(pCount, total, index + 1, results);
            pCount.dropLast();
        }
        if(pCount.getLeftCount() < total){
            pCount.addPair("(");
            combDfs(pCount, total, index+1, results);
            pCount.dropLast();
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        if(n == 0){
            return results;
        }
        combDfs(new PairCount(), n, 0, results);
        return results;
    }
}

package array;

import java.util.*;
import java.util.stream.Collectors;

public class CommonSolution {
    /**
     *3355. 零数组变换 I
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给定一个长度为 n 的整数数组 nums 和一个二维数组 queries，其中 queries[i] = [li, ri]。
     *
     * 对于每个查询 queries[i]：
     *
     * 在 nums 的下标范围 [li, ri] 内选择一个下标 子集。
     * 将选中的每个下标对应的元素值减 1。
     * 零数组 是指所有元素都等于 0 的数组。
     *
     * 如果在按顺序处理所有查询后，可以将 nums 转换为 零数组 ，则返回 true，否则返回 false。
     *
     *
     *
     * 示例 1：
     *
     * 输入： nums = [1,0,1], queries = [[0,2]]
     *
     * 输出： true
     *
     * 解释：
     *
     * 对于 i = 0：
     * 选择下标子集 [0, 2] 并将这些下标处的值减 1。
     * 数组将变为 [0, 0, 0]，这是一个零数组。
     * 示例 2：
     *
     * 输入： nums = [4,3,2,1], queries = [[1,3],[0,2]]
     *
     * 输出： false
     *
     * 解释：
     *
     * 对于 i = 0：
     * 选择下标子集 [1, 2, 3] 并将这些下标处的值减 1。
     * 数组将变为 [4, 2, 1, 0]。
     * 对于 i = 1：
     * 选择下标子集 [0, 1, 2] 并将这些下标处的值减 1。
     * 数组将变为 [3, 1, 0, 0]，这不是一个零数组。
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * 0 <= nums[i] <= 105
     * 1 <= queries.length <= 105
     * queries[i].length == 2
     * 0 <= li <= ri < nums.length
     */
    public boolean isZeroArray(int[] nums, int[][] queries) { // 差分数组

        int length = nums.length;
        int[] deltaArr = new int[length + 1];
        Arrays.fill(deltaArr, 0);
        for(int[] query: queries){
            deltaArr[query[0]]++;
            deltaArr[query[1] + 1]--;
        }
        int operationCnt = 0;
        for(int i = 0; i < deltaArr.length; i++){
            operationCnt += deltaArr[i];
            deltaArr[i] = operationCnt;
        }

        for (int i = 0; i < nums.length; i++) {
            if (deltaArr[i] < nums[i]) {
                return false;
            }
        }
        return true;
    }

    public static class Pair{
        int start;
        int end;
        public Pair(int i, int j){
            this.start = i;
            this.end = j;
        }

        public boolean fallInRange(int item){
            return item >= start && item <= end;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null){
                return false;
            }
            if(obj instanceof Pair){
                Pair p = (Pair) obj;
                return (p.start == this.start) && p.end == this.end;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

    /**
     * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
     *
     * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
     * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
     *
     * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
     * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
     * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
     * 给你一个整数数组 nums ，找出 nums 的下一个排列。
     *
     * 必须 原地 修改，只允许使用额外常数空间。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     *
     * 输入：nums = [3,2,1]
     * 输出：[1,2,3]
     * 示例 3：
     *
     * 输入：nums = [1,1,5]
     * 输出：[1,5,1]
     */
    public void swap(int[] nums, int i , int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public void reverse(int[] nums, int start, int end){
        int left = start, right = end;
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2){
            return;
        }
        int lowerPtr = nums.length-2;
        while(lowerPtr >= 0 && nums[lowerPtr] >= nums[lowerPtr+1]){
            lowerPtr--;
        }
        if(lowerPtr < 0){
            reverse(nums, 0, nums.length-1);
            return;
        }
        int upperPtr = nums.length-1;
        while(nums[upperPtr] <= nums[lowerPtr]){
            upperPtr--;
        }
        swap(nums, lowerPtr, upperPtr);
        reverse(nums,lowerPtr+1, nums.length-1);
    }

    public int countHillValley(int[] nums) {
        if(nums.length <= 2){
            return 0;
        }
        int res = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                continue;
            }
            int left = i-1;
            while(left >= 0 && nums[left] == nums[i]){
                left--;
            }
            if(left < 0){
                continue;
            }
            int right = i+1;
            while(right < nums.length && nums[right] == nums[i]){
                right++;
            }
            if(right >= nums.length){
                break;
            }
            if(nums[left] > nums[i] && nums[right] > nums[i]){
                res++;
            }
            if(nums[left] < nums[i] && nums[right] < nums[i]){
                res++;
            }
        }
        return res;
    }

    /**
     * 49. 字母异位词分组
     * 已解答
     * 中等
     * 相关标签
     * premium lock icon
     * 相关企业
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     *
     *
     *
     * 示例 1:
     *
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     *
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     *
     * 解释：
     *
     * 在 strs 中没有字符串可以通过重新排列来形成 "bat"。
     * 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
     * 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。
     */
    private String sortString(String item){
        char[] charArray = item.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> data = new HashMap<>();
        for(String str: strs){
            String key = sortString(str);
            if(!data.containsKey(key)){
                data.put(key, new ArrayList<>());
            }
            data.get(key).add(str);
        }
        return new ArrayList<>(data.values());
    }
}

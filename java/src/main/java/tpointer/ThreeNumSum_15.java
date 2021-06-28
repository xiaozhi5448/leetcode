package tpointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ThreeNumSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        int left,right;
        for(int i = 0; i < nums.length; i++){
            if(i!= 0 && nums[i] == nums[i-1]){
                continue;
            }
            left = i+1;
            right = nums.length-1;
            while(left < right){
                if(left > i+1 && nums[left] == nums[left-1]){
                    left++;continue;
                }
                if(right < nums.length-1 && nums[right] == nums[right+1]){
                    right--;continue;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }
}

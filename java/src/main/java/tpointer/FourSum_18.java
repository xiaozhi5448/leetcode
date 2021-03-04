package tpointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 */
public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        int left,right;
        for(int first = 0; first < nums.length-3; first++){
            if(first > 0 && nums[first] == nums[first-1])
                continue;
            for(int second = first+1;second < nums.length-2; second++){
                if(second > first+1 && nums[second] == nums[second-1])
                    continue;
                left = second+1;
                right = nums.length-1;
                while(left < right){
                    int sum = nums[first]+nums[second]+nums[left] + nums[right];
                    if(sum<target){
                        left++;
                        while(left<right && nums[left]==nums[left-1])
                            left++;
                    }else if(sum > target){
                        right--;
                        while(left<right && nums[right] == nums[right+1])
                            right--;
                    }else{
                        res.add(Arrays.asList(nums[first], nums[second], nums[left], nums[right]));
                        left++;
                        while(left<right && nums[left]==nums[left-1])
                            left++;
                        right--;
                        while(left<right && nums[right] == nums[right+1])
                            right--;
                    }
                }

            }
        }
        return res;
    }
}

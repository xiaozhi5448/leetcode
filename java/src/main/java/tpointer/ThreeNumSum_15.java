package tpointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    right--;
                    while(left < right && nums[right] == nums[right+1]){
                        right--;
                    }
                }else if(sum < 0){
                    left++;
                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                }else{
                    right--;
                    while(left < right && nums[right] == nums[right+1]){
                        right--;
                    }
                }
            }
        }
        return res;
    }
}

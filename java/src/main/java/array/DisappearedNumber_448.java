package array;

import java.util.LinkedList;
import java.util.List;

public class DisappearedNumber_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int index = 0;
        for(int num:nums){
            index = (num-1)%nums.length;
            nums[index] += nums.length;
        }
        LinkedList<Integer> res = new LinkedList<>();
        for(index = 0; index <nums.length; ++index){
            if(nums[index] >= 1 && nums[index] <= nums.length){
                res.addLast(index+1);
            }
        }
        return res;
    }
}

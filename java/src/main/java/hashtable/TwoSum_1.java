package hashtable;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 */
public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table  = new HashMap<>();
        int[] res = new int[2];
        res[0] = res[1] = -1;
        for(int i = 0; i< nums.length;i++){
            if(table.containsKey(target-nums[i])){
                res[0] = i;
                res[1] = table.get(target-nums[i]);
            }else{
                table.put(nums[i], i);
            }
        }
        return res;
    }
}
/*
将数字及其索引放入hash表中，对每个num，判断target-num是否存在
 */

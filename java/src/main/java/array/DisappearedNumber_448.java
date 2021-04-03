package array;

import java.util.LinkedList;
import java.util.List;

/**
 * 定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 */
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

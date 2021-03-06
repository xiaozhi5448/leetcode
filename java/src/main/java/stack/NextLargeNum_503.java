package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），
 * 输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，
 * 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1
 *
 */
public class NextLargeNum_503 {
    // 补环成链
    public int[] nextGreaterElements(int[] items) {
        if(items.length == 0){
            return items;
        }
        int[] nums = Arrays.copyOf(items, 2*items.length-1);
        System.arraycopy(items, 0, nums, items.length, items.length-1);

        int[] res = new int[items.length];
        Arrays.fill(res, -1);
        for(int i = 0; i < res.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] > nums[i]){
                    res[i] = nums[j];
                    break;
                }
            }
        }
        return res;
    }

    // 单调栈
    public int[] nextGreaterElements2(int[] items){
        int[] ret = new int[items.length];
        Arrays.fill(ret, -1);
        Stack<Integer> monotoneStack = new Stack<>();
        for(int i = 0; i< 2*items.length-1; i++){
            while(!monotoneStack.isEmpty() && items[monotoneStack.peek()] < items[i%items.length]){
                ret[monotoneStack.pop()] = items[i%items.length];
            }
            monotoneStack.push(i%items.length);
        }
        return ret;
    }
}

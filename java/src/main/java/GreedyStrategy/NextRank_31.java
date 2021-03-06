package GreedyStrategy;

import java.util.Arrays;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 贪心算法
 */
public class NextRank_31 {
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private void reverse(int[] nums, int start, int end){
        int left = start, right=end;
        while(left<right){
            swap(nums, left++, right--);
        }
    }
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        int pivot = nums.length-1;
        while(pivot > 0 && nums[pivot-1] >= nums[pivot] ){
            pivot--;
        }
        if(pivot == 0){
            reverse(nums, 0, nums.length-1);
        }else{
            for(int i = nums.length-1; i > pivot-1; i--){
                if(nums[i] > nums[pivot-1]){
                    swap(nums, pivot-1, i);
                    reverse(nums, pivot, nums.length-1);
                    break;
                }
            }
        }
    }
}

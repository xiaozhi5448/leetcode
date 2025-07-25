package hashtable;

import java.util.HashSet;
import java.util.Set;

public class CommonSolution {

    /**
     * 给你一个整数数组 nums 。
     *
     * 你可以从数组 nums 中删除任意数量的元素，但不能将其变为 空 数组。执行删除操作后，选出 nums 中满足下述条件的一个子数组：
     *
     * 子数组中的所有元素 互不相同 。
     * 最大化 子数组的元素和。
     * 返回子数组的 最大元素和 。
     *
     * 子数组 是数组的一个连续、非空 的元素序列。
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3,4,5]
     *
     * 输出：15
     *
     * 解释：
     *
     * 不删除任何元素，选中整个数组得到最大元素和。
     *
     * 示例 2：
     *
     * 输入：nums = [1,1,0,1,1]
     *
     * 输出：1
     *
     * 解释：
     *
     * 删除元素 nums[0] == 1、nums[1] == 1、nums[2] == 0 和 nums[3] == 1 。选中整个数组 [1] 得到最大元素和。
     *
     * 示例 3：
     *
     * 输入：nums = [1,2,-1,-2,1,0,-1]
     *
     * 输出：3
     *
     * 解释：
     *
     * 删除元素 nums[2] == -1 和 nums[3] == -2 ，从 [1, 2, 1, 0, -1] 中选中子数组 [2, 1] 以获得最大元素和。
     */
    public int maxSum(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        int minElement = nums[0];
        int sum = 0;
        for(int num: nums){
            minElement = Math.max(minElement, num);
            if(elements.contains(num)){
                continue;
            }
            if(num >= 0){
                sum += num;
                elements.add(num);
            }
        }
        if(minElement < 0){
            return minElement;
        }
        return sum;
    }

    /**
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     *
     * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     * 示例 2：
     *
     * 输入：nums = [2,0,1]
     * 输出：[0,1,2]
     *
     *
     * 提示：
     *
     * n == nums.length
     * 1 <= n <= 300
     * nums[i] 为 0、1 或 2
     */
    public void sortColors(int[] nums) {
        if(nums.length == 0){
            return;
        }
        int ptr0 = 0;
        int ptr2 = nums.length-1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                int tmp = nums[ptr0];
                nums[ptr0] = 0;
                nums[i] = tmp;
                ptr0++;
            }
        }
        ptr2 = ptr0;
        for(int i = ptr2; i < nums.length; i++){
            if(nums[i] == 1){
                int tmp = nums[ptr2];
                nums[ptr2] = 1;
                nums[i] = tmp;
                ptr2++;
            }
        }
    }
}

package binarysearch;

public class CommonSolution {
    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * <p>
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     */
    public int[] searchRange(int[] nums, int target) {
        // 方法1 使用二分查找找到 任意 target, 向两侧扩展 得到左右边界
        int[] invalid = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return invalid;
        }
        int left = 0, right = nums.length - 1, mid;
        int targetIndex = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                targetIndex = mid;
                break;
            }
        }
        if (left > right) {
            return invalid;
        }
        left = targetIndex;
        right = targetIndex;
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        while (right < nums.length && nums[right] == target) {
            right++;
        }
        return new int[]{left + 1, right - 1};
    }

    /**
     * 33. 搜索旋转排序数组
     * 已解答
     * 中等
     * 相关标签
     * premium lock icon
     * 相关企业
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     * <p>
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     * <p>
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     */
    private boolean order(int[] nums, int left, int right) {
        if (left == right) {
            return true;
        }
        return nums[right] > nums[left];
    }

    public int search(int[] nums, int target) {
        // 核心思想: 这种构造的数组从某个位置拆分成左右两个子数组, 其中一定一个有序的, 一个无序的, 判断有序无序可以比较数组 开始与结尾数字大小关系
        int left = 0, right = nums.length -1, mid = (left + right) / 2;
        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(target > nums[mid]){
                if(order(nums, mid, right) &&  target > nums[right]){ // 如果右边有序
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else if(target < nums[mid]){

                if(order(nums, left, mid) && target < nums[left]){
                    left = mid + 1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }


    /**
     * 153. 寻找旋转排序数组中的最小值
     * 已解答
     * 中等
     * 相关标签
     * premium lock icon
     * 相关企业
     * 提示
     * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
     * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
     * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     *
     * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
     *
     * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     * @return
     */
    private int realIndex(int length, int index){
        if(index < 0){
            return length + (index % length);
        }else{
            return (index % length);
        }
    }
    public int findMin(int[] nums) {
        if(nums.length <= 1){
            return nums[0];
        }
        if(nums[0] < nums[nums.length-1]){
            return nums[0];
        }
        int left = 0, right = nums.length-1;
        int mid = (left + right) / 2;
        while(left <= right){
            if(nums[left] < nums[right]){
                return nums[left];
            }
            mid = (left + right) /2;
            if(nums[mid] < nums[realIndex(nums.length, mid+1)] && nums[mid] < nums[realIndex(nums.length, mid-1)]){
                return nums[mid];
            }
            if(order(nums, left, mid)){
                left = mid + 1;
            }
            if(order(nums, mid,right)){
                right = mid-1;
            }
        }
        return 0;
    }
}

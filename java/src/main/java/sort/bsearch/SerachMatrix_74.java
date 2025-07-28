package sort.bsearch;

public class SerachMatrix_74 {
    /**
     * 给你一个满足下述两条属性的 m x n 整数矩阵：
     *
     * 每行中的整数从左到右按非严格递增顺序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0, right = row-1, mid = 0;
        while(left <= right){ // 如果没有找到目标元素, 那么循环结束时, left = right + 1 且 nums[right] < target && nums[left] > target
            mid = (left + right) / 2;
            if(target < matrix[mid][0]){
                right = mid - 1;
            }else if(target > matrix[mid][0]){
                left = mid + 1;
            }else{
                return true;
            }
        }

        if(right < 0){
            return false;
        }

        int pivot = right;
        int[] nums = matrix[pivot];
        left = 0; right = col -1;
        while(left <= right){
            mid = (left + right) / 2;
            if(target < nums[mid]){
                right = mid - 1;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}

import java.util.*;

public class MinMax3Element {

    private void swap(int[] nums, int left, int right){
        if(left == right){
            return;
        }
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    /**
     * 查找两个数组中最小和最大的三个元素
     * @param nums1
     * @param nums2
     * @return
     */
    public int[][] minMax3Element(int[] nums1, int[] nums2){
        // 考虑 nums1 或 nums2 为null 的情况
        if(nums1 == null && nums2 == null){
            return null;
        }
        Set<Integer> elements = new HashSet<>();
        if(nums1 != null){
            Arrays.stream(nums1).forEach(elements::add);
        }
        if(nums2 != null){
            Arrays.stream(nums2).forEach(elements::add);
        }
        int[] nums = new int[elements.size()];
        int i = 0;
        for(Integer num: elements){
            nums[i++] = num;
        }

        int sortEpoch = Math.min(3, elements.size());
        for(int j = 0; j < sortEpoch; j++){
            for(int k = j+1; k < elements.size(); k++){
                if(nums[j] > nums[k]){
                    swap(nums, j, k);
                }
            }
        }
        for(int j = 0; j < sortEpoch; j++){
            int pos = nums.length - j - 1;
            for(int k = pos-1; k >= 0; k--){
                if(nums[k] > nums[pos]){
                    swap(nums, pos, k);
                }
            }
        }

        int bound = Math.min(3, nums.length);
        int[] min3Ele = new int[bound];
        int[] max3Ele = new int[bound];
        for(int index = 0; index < bound; index++){
            min3Ele[index] = nums[index];
            max3Ele[index] = nums[nums.length - index - 1];
        }
        return new int[][]{min3Ele, max3Ele};
    }
}

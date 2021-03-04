package sort;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class KthLargestItem_215 {

    // 方法一：快速排序
    private int partition(int[] nums, int start, int end) {
        if (start >= end) {
            return start;
        }
        int index = start - 1, med = 0;
        int pivot = nums[end];
        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                index += 1;
                med = nums[index];
                nums[index] = nums[i];
                nums[i] = med;
            }
        }
        med = nums[end];
        nums[end] = nums[index + 1];
        nums[index + 1] = med;
        return index + 1;
    }

    private void quicksort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = partition(nums, start, end);
        quicksort(nums, start, mid - 1);
        quicksort(nums, mid + 1, end);
    }

    public int findKthLargest(int[] nums, int k) {
        quicksort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    // heap sort
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void maxHeapify(int[] nums, int index, int heapSize) {
        int l = 2 * index + 1, r = 2 * index + 2;
        int largest = index;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if(largest != index){
            swap(nums, index, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    public void buildMaxHeap(int[] nums, int heapSize){
        for(int i = heapSize/2; i >= 0; i--){
            maxHeapify(nums, i, heapSize);
        }
    }

    public int findKthLargest2(int[] nums, int k) {
        buildMaxHeap(nums, nums.length);
        int heapSize = nums.length;
        for(int i = nums.length-1; i > nums.length-k;i--){
            swap(nums, 0, i);
            maxHeapify(nums, 0, --heapSize);
        }
        return nums[0];
    }

}

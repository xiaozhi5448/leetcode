package sort;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

public class SortUtil {

    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private static int partition(int[] nums, int start, int end){
        if(start >= end){
            return start;
        }
        int index = start - 1;
        int pivot = nums[end];
        for(int i = start; i< end;i++){
            if(nums[i] < pivot){
                index += 1;
                swap(nums, index, i);
            }
        }
        index += 1;
        swap(nums, index, end);
        return index;
    }
    public static void quickSort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int mid = partition(nums, start, end);
        quickSort(nums, start, mid-1);
        quickSort(nums, mid+1, end);
    }

    public static void bubbleSort(int[] nums){
        int tmp;
        for(int bound=nums.length-1; bound>0;bound--){
            for(int index = 0; index < bound; index++){
                if(nums[index] > nums[index+1]){
                    swap(nums, index, index+1);
                }
            }
        }
    }

    public static void selectSort(int[] nums){
        int tmp;
        for(int left = 0; left < nums.length; left++){
            for(int right = left+1; right< nums.length;right++){
                if(nums[right] < nums[left]){
                    swap(nums, left, right);
                }
            }
        }
    }

    public static void insertionSort(int[] nums){
        int pivot;
        for(int bound = 1; bound < nums.length; bound++){
            pivot = nums[bound];
            int index = bound-1;
            while( index >= 0&&nums[index] > pivot){
                nums[index+1] = nums[index];
                index--;
            }
            nums[index+1] = pivot;
        }
    }

    private static void merge(int[] nums, int left, int right, int mid, int[] temp){
        if(left >= right){
            return;
        }
        int i = left, j = mid+1;
        int tmp_ptr = 0;
        while(i <= mid && j <= right ){
            if(nums[i] >= nums[j]){
                temp[tmp_ptr++] = nums[j++];
            }else{
                temp[tmp_ptr++] = nums[i++];
            }
        }
        while(i <= mid){
            temp[tmp_ptr++] = nums[i++];
        }
        while(j <= right){
            temp[tmp_ptr++] = nums[j++];
        }
//        tmp_ptr = 0;
//        int copy_ptr = left;
//        while(copy_ptr <= right){
//            nums[copy_ptr++] = temp[tmp_ptr++];
//        }
        System.arraycopy(temp,0, nums, left, right-left+1);

    }
    private static void mergeSort(int[] nums, int start, int end, int[] tmp){
        if(start >= end){
            return;
        }
        int mid = (start+end)/2;
        mergeSort(nums, start, mid, tmp);
        mergeSort(nums, mid+1, end, tmp);
        merge(nums, start, end, mid, tmp);
    }
    public static void mergeSort(int[] nums){
        int[] tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length-1, tmp);
    }

    // heap sort

    private void minHeapify(int[] nums, int index, int heapSize){
        int l = 2*index+1, r = 2*index+2, smallest = index;
        if(l < heapSize && nums[l] < nums[smallest]){
            smallest = l;
        }
        if(r < heapSize && nums[r] < nums[smallest]){
            smallest = r;
        }
        if(smallest != index){
            swap(nums, index, smallest);
            minHeapify(nums, smallest, heapSize);
        }
    }
    private void buildMinHeap(int[] nums, int heapSize){
        for(int i = heapSize/2;i>=0;i--){
            minHeapify(nums, i, heapSize);
        }
    }
    public void heapSort(int[] nums){
        int heapSize = nums.length;
        buildMinHeap(nums, heapSize);
        for(int i = nums.length-1; i > 0; i--){
            swap(nums, 0, i);
            minHeapify(nums, 0, --heapSize);
        }

    }

    @FunctionalInterface
    public interface SortOperation{
        void sort(int[] nums);
    }

    public static void costCalProcess(SortOperation operation, int[] params, String tag){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        operation.sort(params);
        stopWatch.stop();
        System.out.println("method: " + tag + ", cost: " + stopWatch.getTime(TimeUnit.MILLISECONDS) + " mills");
    }
}

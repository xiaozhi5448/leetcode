package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class CommonSolution {
    /**
     * 215. 数组中的第K个最大元素
     * 已解答
     * 中等
     * 相关标签
     * premium lock icon
     * 相关企业
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     *
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
     */
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void maxHeapify(int[] nums, int index, int heapSize){
        int left = index * 2 + 1, right = index * 2 + 2;
        int largest = index;
        if(left < heapSize){
            largest = nums[left] > nums[largest]? left: largest;
        }
        if(right < heapSize){
            largest = nums[right] > nums[largest]? right: largest;
        }
        if(largest != index){
            swap(nums, largest, index);
            maxHeapify(nums, largest, heapSize);
        }
    }

    private void buildMaxHeap(int[] nums){
        int heapSize = nums.length;
        for(int i = (heapSize / 2); i >= 0; i--){
            maxHeapify(nums, i, heapSize);
        }
    }


    public int findKthLargest(int[] nums, int k) {
        buildMaxHeap(nums);
        int heapSize = nums.length;
        for(int i = 1; i < k; i++){
            swap(nums, 0, heapSize-1);
            maxHeapify(nums, 0, heapSize-1);
            heapSize--;
        }
        return nums[0];
    }
    /**
     * 347. 前 K 个高频元素
     * 已解答
     * 中等
     * 相关标签
     * premium lock icon
     * 相关企业
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     */
    class Pair implements Comparable<Pair>{
        Integer num;
        Integer freq;
        public Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Pair)){
                return false;
            }
            return Objects.equals(this, (Pair)obj);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.num);
        }

        @Override
        public int compareTo(Pair o) {
            return o.freq - this.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        for(Integer key: freqMap.keySet()){
            queue.offer(new Pair(key, freqMap.get(key)));
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = queue.poll().num;
        }
        return res;
    }
}

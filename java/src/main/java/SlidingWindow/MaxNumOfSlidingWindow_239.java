package SlidingWindow;

import java.util.*;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 */
public class MaxNumOfSlidingWindow_239 {

    // 优先队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1){
            return nums;
        }
        if(k > nums.length || k == 0){
            return null;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));
        for(int i=0; i < k; i++){
            maxHeap.offer(nums[i]);
        }
        Map<Integer, Integer> removed = new HashMap<>();
        int[] res = new int[nums.length-k+1];
        res[0] = maxHeap.peek();
        for(int i = 1; i <= nums.length-k; i++){
            removed.put(nums[i-1], removed.getOrDefault(nums[i-1],0)+1);
            while(removed.containsKey(maxHeap.peek()) && removed.get(maxHeap.peek()) > 0){
                removed.put(maxHeap.peek(), removed.get(maxHeap.peek()) - 1);
                maxHeap.poll();
            }
            maxHeap.offer(nums[i+k-1]);
            res[i] = maxHeap.peek();
        }
        return res;
    }

    // 单调队列
    public int[] maxSlidingWindow2(int[] nums, int k){
        if(k == 1){
            return nums;
        }
        if(k > nums.length || k == 0){
            return null;
        }
        Deque<Integer> sorted = new LinkedList<>();
        for(int i = 0; i< k; i++){
            if(sorted.isEmpty()){
                sorted.offerLast(nums[i]);
            }else{
                while(!sorted.isEmpty() && nums[i] > sorted.peekLast()){
                    sorted.pollLast();
                }
                sorted.offerLast(nums[i]);
            }
        }
        int[] res = new int[nums.length-k+1];
        res[0] = sorted.peekFirst();
        for(int i = 1; i < nums.length-k+1; i++){
            if(!sorted.isEmpty() && sorted.peekFirst() == nums[i-1]){
                sorted.pollFirst();
            }
            while(!sorted.isEmpty() && nums[i+k-1] > sorted.peekLast()){
                sorted.pollLast();
            }
            sorted.addLast(nums[i+k-1]);
            res[i] = sorted.peekFirst();
        }
        return res;
    }
}

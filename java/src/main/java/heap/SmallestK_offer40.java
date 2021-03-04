package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 找到数组中最小的k个数
 *
 * 先排序，找前k个元素
 *
 * 使用大小为k的最大堆
 */
class MaxHeap{
    int[] data;
    int index = 0;
    public MaxHeap(int size){
        if(size > 0)
        data = new int[size];
        else{
            data = new int[256];
        }
        index = size;
    }
    private void swap(int[] data, int i, int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
    public void maxHeapify(int index, int size){
        int left = index*2+1, right = 2*index+2;
        int largest = index;
        if(left < size){
            largest = data[largest] > data[left]? largest: left;
        }
        if(right < size){
            largest = data[largest] > data[right]? largest: right;
        }
        if(index != largest){
            swap(data, largest, index);
            maxHeapify(largest, size);
        }
    }

    public boolean add(int num){
        if(index > 0){
            index--;
            data[index] = num;
            maxHeapify(index, data.length);
        }else{
            if(data[index] <= num){
                return false;
            }
            data[index] = num;
            maxHeapify(index, data.length);
        }
        return true;
    }
}

public class SmallestK_offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> h1 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int num:arr){
            if(h1.size() < k){
                h1.offer(num);
            }else{
                if(h1.peek() > num){
                    h1.poll();
                    h1.offer(num);
                }
            }
        }
        int[] res = new int[k];
        for(int i = 0; i<k; i++){
            res[i] = h1.poll();
        }
        return res;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        if(k==0) return new int[0];
        MaxHeap h = new MaxHeap(k);
        for(int num:arr){
            h.add(num);
        }
        return Arrays.copyOf(h.data, k);
    }
}

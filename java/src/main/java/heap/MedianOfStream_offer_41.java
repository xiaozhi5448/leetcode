package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfStream_offer_41 {
    // 大根堆
    PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    // 小根堆
    PriorityQueue<Integer> right = new PriorityQueue<>();
    /** initialize your data structure here. */
    public MedianOfStream_offer_41() {

    }

    public void addNum(int num) {
        if(left.isEmpty() || num < left.peek())
            left.offer(num);
        else if(num >= left.peek()){
            right.offer(num);
        }
        while(left.size() > right.size()+1){
            right.offer(left.poll());
        }
        while(left.size() < right.size()){
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        if(left.size() == 0 && right.size() == 0){
            return 0;
        }
        else if(left.size() > right.size()){
            return left.peek();
        }else{
            return (left.peek()+right.peek())/2.0;
        }
    }

}

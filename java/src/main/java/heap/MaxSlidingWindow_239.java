package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSlidingWindow_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0]? o2[1] - o1[1]: o2[0]-o1[0];
            }
        });
        for(int i = 0; i< k; i++){
            pq.offer(new int[]{nums[i], i});
        }
        int[] res = new int[nums.length - k +1];
        res[0] = pq.peek()[0];
        for(int i = 0; i+k < nums.length;i++){
            pq.offer(new int[]{nums[i+k], i+k});
            while(pq.peek()[1] < i+1){
                pq.poll();
            }
            int[] hill = pq.peek();
            res[i+1] = hill[0];
        }
        return res;
    }
}

package heap;

import java.util.PriorityQueue;

public class FinalWeight_1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int num:stones){
            pq.offer(num);
        }
        int a,b=0;
        while(pq.size() >1){
            a = pq.poll();
            b = pq.poll();
            if(a>b){
                pq.offer(a-b);
            }
        }
        return pq.isEmpty()? 0:pq.poll();
    }
}

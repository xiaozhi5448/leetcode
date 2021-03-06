package list;

import lombok.val;

import java.util.*;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeKList_23 {

    // 分治
    private ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode res = new ListNode(-1, null);
        ListNode tail = res;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                tail.next = l2;
                l2 = l2.next;
            }else{
                tail.next = l1;
                l1 = l1.next;
            }
            tail = tail.next;
            tail.next = null;
        }
        ListNode remainder = l1 == null? l2:l1;
        tail.next = remainder;
        return res.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        Deque<ListNode> medLists = new LinkedList<ListNode>();
        for(ListNode l : lists){
            if(l!= null){
                medLists.addLast(l);
            }
        }
        if(medLists.size() < 1){
            return null;
        }
        medLists.addLast(null);
        while(medLists.size()>1){
            ListNode l1 = medLists.pollFirst();
            ListNode l2 = medLists.pollFirst();
            if(l1 != null && l2 != null){
                medLists.addLast(merge2Lists(l1, l2));
            }else{
                if(!medLists.isEmpty()){
                    medLists.addLast( l1 != null ? l1:l2);
                    medLists.addLast(null);
                }else{
                    medLists.addLast(l1 != null? l1:l2);
                }
            }
        }
        return medLists.getFirst();
    }

    // 优先队列-堆
    public ListNode mergeKLists2(ListNode[] lists){
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(ListNode l:lists){
            if(l!= null){
                heap.add(l);
            }
        }
        ListNode res = new ListNode(-1, null);
        ListNode tail = res;

        if(heap.size()<1){
            return null;
        }else if(heap.size() == 1){
            return heap.poll();
        }else{
            while(!heap.isEmpty()){
                ListNode next = heap.poll();
                if(next != null){
                    tail.next = next;
                    next = next.next;
                    tail = tail.next;
                    tail.next = null;
                    if(next != null)
                    heap.offer(next);
                }
            }

        }
        return res.next;
    }
}

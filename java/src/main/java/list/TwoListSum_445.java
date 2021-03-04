package list;

import java.util.LinkedList;

/**
 * 链表形式的两数之和
 */
public class TwoListSum_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        while(l1!= null || l2!= null){
            if(l1 != null){
                stack1.addLast(l1.val);
                l1 = l1.next;
            }else{
                stack1.addFirst(0);
            }
            if(l2 != null){
                stack2.addLast(l2.val);
                l2 = l2.next;
            }else{
                stack2.addFirst(0);
            }
        }
        ListNode res = new ListNode(-1,null);
        ListNode tail = res;
        int carrier = 0;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            int a = stack1.pollLast();
            int b = stack2.pollLast();
            int sum = (a+b+carrier);
            carrier = sum/10;
            ListNode node = new ListNode((sum)%10, null);
            node.next = res.next;
            res.next = node;
        }
        if(carrier!= 0){
            ListNode node = new ListNode(carrier, res.next);
            res.next = node;
        }
        return res.next;
    }
}

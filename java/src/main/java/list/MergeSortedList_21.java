package list;

/**
 * 合并排序链表
 */
public class MergeSortedList_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1, null);
        ListNode tail = res;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
                tail = tail.next;
                tail.next = null;
            }else{
                tail.next = l2;
                l2 = l2.next;
                tail = tail.next;
                tail.next = null;
            }
        }
        ListNode remainder = l1 == null? l2 : l1;
        while(remainder != null){
            tail.next = remainder;
            remainder = remainder.next;
            tail = tail.next;
            tail.next = null;
        }
        return res.next;
    }
}

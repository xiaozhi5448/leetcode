package list;


/**
 * 链表排序
 */
public class SortList_148 {

    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null){
            return l1==null ? l2:l1;
        }else{
            ListNode head = new ListNode(-1, null);
            ListNode tail = head;
            ListNode n1 = l1, n2 = l2;
            while(n1 != null && n2 != null){
                if(n1.val < n2.val){
                    tail.next = n1;
                    n1 = n1.next;
                }else{
                    tail.next = n2;
                    n2 = n2.next;
                }
                tail = tail.next;
                tail.next = null;
            }
            tail.next = n1 == null ? n2:n1;
            return head.next;
        }
    }

    private ListNode getMid(ListNode head, ListNode end){
        if(head == null)
            return null;
        else if(head.next == end){
            return head;
        }
        ListNode preSlow = head;
        ListNode slow = head, fast = slow.next;
        while(fast != end){
            if(slow != head){
                preSlow = preSlow.next;
            }
            slow = slow.next;
            fast = fast.next;
            if(fast != end){
                fast = fast.next;
            }else{
                break;
            }
        }
        preSlow.next = null;
        return slow;
    }

    private ListNode sortRecursion(ListNode start, ListNode end){
        if(start == null)
            return null;
        if(start.next == end)
            return start;
        ListNode mid = getMid(start, end);
        ListNode left = sortRecursion(start, null);
        ListNode right = sortRecursion(mid, end);
        return merge(left, right);
    }

    public ListNode sortList(ListNode head) {
        return sortRecursion(head, null);
    }
}

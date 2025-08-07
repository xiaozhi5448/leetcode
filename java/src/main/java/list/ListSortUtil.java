package list;

public class ListSortUtil {

    public static ListNode buildListNode(int[] nums){
        ListNode header = new ListNode();
        ListNode tail = header;
        for (int num : nums) {
            ListNode node = new ListNode(num, null);
            tail.next = node;
            tail = node;
        }
        return header.next;
    }

    /**
     * 148. 排序链表
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     * @return
     */
    public ListNode mergeSortedList(ListNode head1, ListNode head2){
        if(head2 == null){
            return head1;
        }
        if(head1 == null){
            return head2;
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        ListNode ptr1 = head1;
        ListNode ptr2 = head2;
        while(ptr1 != null && ptr2 != null){
            if(ptr1.val < ptr2.val){
                tail.next = ptr1;
                tail = ptr1;
                ptr1 = ptr1.next;
            }else{
                tail.next = ptr2;
                tail = ptr2;
                ptr2 = ptr2.next;
            }
        }
        if(ptr1 != null){
            tail.next = ptr1;
        }else{
            tail.next = ptr2;
        }
        return head.next;
    }

    public ListNode findMiddle(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
            if(fastPtr == null){
                break;
            }
            fastPtr = fastPtr.next;
        }
        ListNode ptr = head;
        while(true){
            if(ptr.next == slowPtr){
                ptr.next = null;
                break;
            }
            ptr = ptr.next;
        }
        return slowPtr;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode leftHead = sortList(head);
        ListNode rightHead = sortList(middle);
        return mergeSortedList(leftHead, rightHead);
    }
}

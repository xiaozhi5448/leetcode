package list;

import java.util.Map;
import java.util.HashMap;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 */
public class RingList_II_142 {

    // 使用哈希表
    public ListNode detectCycle1(ListNode head) {
        if(head==null){
            return null;
        }
        Map<ListNode,Integer> nodes = new HashMap<>();
        int index = 0;
        ListNode ptr = head;
        while(ptr != null){
            if(nodes.containsKey(ptr)){
                return ptr;
            }else{
                nodes.put(ptr, index++);
                ptr = ptr.next;
            }
        }
        return null;
    }
    // 使用快慢指针
    public ListNode detectCycle(ListNode head){
        ListNode fast=head,slow=head;
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }else{
                return null;
            }
            if(fast == slow){
                ListNode ptr = head;
                while(slow != ptr){
                    slow = slow.next;
                    ptr = ptr.next;
                }
                return ptr;
            }
        }
        return null;
    }
}

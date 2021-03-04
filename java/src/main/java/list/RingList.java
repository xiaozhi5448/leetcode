package list;

import java.util.HashSet;

/**
 * 141
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，
 * 则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 */
public class RingList {
    public boolean hasCycle(ListNode head) {
        // 使用哈希表
        HashSet<ListNode> nodes = new HashSet<>();
        while(head!= null){
            if(nodes.contains(head)){
                return true;
            }else{
                nodes.add(head);
                head = head.next;
            }
        }
        return false;
    }
    // 使用快慢指针
    public boolean hasCycle2(ListNode head){
        ListNode slow = head, fast = head.next;
        while(slow != fast){
            if(fast==null || fast.next==null){
                return false;
            }else{
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return true;
    }
}

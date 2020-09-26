package simple;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode index = head, tmp = null;
        ListNode newList = null;
        while(index != null){
            tmp = index.next;
            index.next = newList;
            newList = index;
            index = tmp;
        }
        return newList;

    }
}

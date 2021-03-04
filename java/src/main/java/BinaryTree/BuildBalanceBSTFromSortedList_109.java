package BinaryTree;





 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class BuildBalanceBSTFromSortedList_109 {

     /*
     快慢指针寻找有序链表的中点
      */
     public ListNode getMiddemNode(ListNode start, ListNode end){
         ListNode fast = start;
         ListNode slow = start;
         while(fast != end && fast.next != end){
             slow = slow.next;
             fast = fast.next;
             if(fast != null){
                 fast = fast.next;
             }else{
                 break;
             }
         }
         return slow;
     }

     private TreeNode buildBSTRecursionUtil(ListNode start, ListNode end){
         if(start!= null && start.next == end){
             return new TreeNode(start.val);
         }else if(start == end){
             return null;
         }else{
             ListNode mid = getMiddemNode(start, end);
             TreeNode node = new TreeNode(mid.val);
             node.left = buildBSTRecursionUtil(start, mid);
             node.right = buildBSTRecursionUtil(mid.next, end);
             return node;
         }
     }
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = buildBSTRecursionUtil(head, null);
        return root;
    }
}

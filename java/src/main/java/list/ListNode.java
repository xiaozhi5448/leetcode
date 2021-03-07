package list;

/*
*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
*/

import lombok.*;

import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@ToString
public class ListNode{
    int val;
    ListNode next;

    public static ListNode buildFormList(int[] arr){
        ListNode head = new ListNode();
        ListNode tail = head;
        for(int i = 0; i < arr.length; i++){
            tail.next = new ListNode(arr[i], null);
            tail = tail.next;
        }
        return head.next;
    }
    public static String str(ListNode node){
        List<String> nums = new LinkedList<>();
        while(node != null){
            nums.add(String.valueOf(node.val));
            node = node.next;
        }
        return String.join("->", nums);
    }
}


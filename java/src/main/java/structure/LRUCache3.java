package structure;

import java.util.HashMap;

class ListNode{
    int val;
    ListNode prev = null;
    ListNode next = null;
    public ListNode(int val){
        this.val = val;
    }
}

public class LRUCache3 {
    int capacity;
    HashMap<Integer, ListNode> map = new HashMap<>();
    ListNode head = new ListNode(-1);
    ListNode tail = new ListNode(-1);

    public LRUCache3(int size){
        capacity = size;
        head.next = tail;
        tail.prev =head;
    }
    private void moveToEnd(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        ListNode node = map.get(key);
        moveToEnd(node);
        return node.val;
    }
    public void put(int key, int val){
        if(get(key) == -1){

        }
    }

}

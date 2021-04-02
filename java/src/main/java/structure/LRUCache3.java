package structure;

import java.util.HashMap;

class ListNode{
    int val;
    int key;
    ListNode prev = null;
    ListNode next = null;
    public ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

public class LRUCache3 {
    int capacity;
    HashMap<Integer, ListNode> map = new HashMap<>();
    ListNode head = new ListNode(-1,-1);
    ListNode tail = new ListNode(-1,-1);

    public LRUCache3(int size){
        capacity = size;
        head.next = tail;
        tail.prev =head;
    }
    private void addToEnd(ListNode node){
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        ListNode node = map.get(key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
        addToEnd(node);
        return node.val;
    }
    public void put(int key, int val){
        if(get(key) != -1){
            ListNode node = map.get(key);
            node.val = val;
        }else{
            ListNode node = new ListNode(key, val);
            addToEnd(node);
            map.put(key, node);
            if(map.size() > capacity){
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.prev = head;
            }
        }
    }

}

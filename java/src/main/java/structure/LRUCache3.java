package structure;

import java.util.HashMap;

class ListNode<K, V>{
    V val;
    K key;
    ListNode<K, V> prev = null;
    ListNode<K, V> next = null;
    public ListNode(K key, V val){
        this.key = key;
        this.val = val;
    }
}

public class LRUCache3 <K, V>{
    int capacity;
    HashMap<K, ListNode<K, V>> map = new HashMap<>();
    ListNode<K, V> head = new ListNode<>(null,null);
    ListNode<K, V> tail = new ListNode<>(null,null);

    public LRUCache3(int size){
        capacity = size;
        head.next = tail;
        tail.prev =head;
    }

    private void addToEnd(ListNode<K, V> node){
        node.prev = tail.prev;
        node.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }

    private void moveToEnd(ListNode<K, V> node){
        delete(node);
        addToEnd(node);
    }

    private void delete(ListNode<K, V> node){
        ListNode<K, V> prev = node.prev;
        ListNode<K, V> next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public V get(K key){
        if(!map.containsKey(key)){
            return null;
        }
        ListNode<K, V> node = map.get(key);
        moveToEnd(node);
        return node.val;
    }

    public void put(K key, V val){
        ListNode<K, V> node;
        if(map.containsKey(key)){
            node = map.get(key);
            node.val = val;
            moveToEnd(node);
        }else{
            node = new ListNode<>(key, val);
            addToEnd(node);
            map.put(key, node);
            if(map.size() > capacity){
                ListNode<K, V> header = head.next;
                delete(header);
                map.remove(header.key);
            }
        }
    }
}

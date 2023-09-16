package design;

import base.BiLinkedList;
import base.BiLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2<T> {

    Map<String, BiLinkedListNode<T>> nodeMap = new HashMap<>();

    BiLinkedList<T> linkedList = new BiLinkedList<>();

    int capacity;

    public LRUCache2(int capacity){
        this.capacity = capacity;
    }

    public T get(String key){
        BiLinkedListNode<T> node = nodeMap.get(key);
        linkedList.moveToHeader(node);
        return node.getVal();
    }

    public void put(String key, T val){
        if(nodeMap.containsKey(key)){
            BiLinkedListNode<T> node = nodeMap.get(key);
            node.setVal(val);
            linkedList.moveToHeader(node);
            return;
        }
        BiLinkedListNode<T> node = linkedList.addHeader(val);
        nodeMap.put(key, node);
        if(linkedList.getSize() > capacity){
            linkedList.removeTail();
        }
    }

    @Override
    public String toString() {
        return "list: " + linkedList + "\n";
    }
}

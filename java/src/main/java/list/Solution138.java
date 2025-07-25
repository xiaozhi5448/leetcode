package list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution138 {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        Map<Node, Integer> nodeIndex = new HashMap<>();
        int index = 0;
        Node resHead = new Node(-1);
        Node ptr = resHead;
        Node tail = ptr;
        List<Node> resNodes = new ArrayList<>();
        while(ptr != null){
            nodeIndex.put(ptr, index);
            tail.next = new Node(ptr.val);
            resNodes.add(tail.next);
            tail = tail.next;
            index++;
        }

        index = 0;
        ptr = head;
        while(ptr != null){
            if(nodeIndex.containsKey(ptr.random)){
                int i = nodeIndex.get(ptr.random);
                resNodes.get(index).random = resNodes.get(i);
            }
            ptr = ptr.next;
            index++;
        }
        return resHead.next;
    }
}

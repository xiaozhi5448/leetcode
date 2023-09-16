package base;

import java.util.Objects;

public class BiLinkedList<T> {
    BiLinkedListNode<T> header;
    BiLinkedListNode<T> tail;

    int size;

    public BiLinkedList(){
        header = new BiLinkedListNode<>();
        tail = new BiLinkedListNode<>();
        header.setNext(tail);
        header.setPrev(null);
        tail.setPrev(header);
        tail.setNext(null);
    }

    public void removeNode(BiLinkedListNode<T> node){
        if(node == null){
            return;
        }
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        size--;
    }

    public BiLinkedListNode<T> append(T val){
        if(val == null){
            return null;
        }
        BiLinkedListNode<T> node = new BiLinkedListNode<>();
        node.setVal(val);
        node.setNext(tail);
        node.setPrev(tail.prev);
        tail.setPrev(node);
        node.getPrev().setNext(node);
        size++;
        return node;
    }

    public BiLinkedListNode<T> addHeader(T val){
        if (val == null){
            return null;
        }
        BiLinkedListNode<T> node = new BiLinkedListNode<>();
        node.setVal(val);
        node.setNext(header.next);
        node.setPrev(header);
        header.setNext(node);
        node.getNext().setPrev(node);
        size++;
        return node;
    }

    public void addHeader(BiLinkedListNode<T> node){
        if (node == null){
            return;
        }
        node.setNext(header.next);
        node.setPrev(header);
        header.setNext(node);
        node.getNext().setPrev(node);
        size++;
    }


    public void moveToHeader(BiLinkedListNode<T> node){
        removeNode(node);
        addHeader(node);
    }

    public BiLinkedListNode<T> getByVal(T val){
        BiLinkedListNode<T> ptr = header.next;
        while(ptr != tail){
            if(Objects.equals(ptr.val, val)){
                return ptr;
            }
            ptr = ptr.next;
        }
        return null;
    }

    @Override
    public String toString() {
        if(size == 0){
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        builder.append(header.next.val);
        BiLinkedListNode<T> ptr = header.next.next;
        while(ptr != tail){
            builder.append("->");
            builder.append(ptr.val);
            ptr = ptr.next;
        }
        builder.append(']');
        return builder.toString();
    }

    public int getSize() {
        return size;
    }

    public void removeTail() {
        BiLinkedListNode<T> prev = tail.getPrev();
        if(prev != header){
            removeNode(prev);
        }
    }
}

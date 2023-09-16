package base;

public class BiLinkedListNode<T> {
    BiLinkedListNode<T> next;
    BiLinkedListNode<T> prev;

    T val;

    public BiLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(BiLinkedListNode<T> next) {
        this.next = next;
    }

    public BiLinkedListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(BiLinkedListNode<T> prev) {
        this.prev = prev;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }
}

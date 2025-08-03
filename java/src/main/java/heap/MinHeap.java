package heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 指定大小的堆
 * @param <T>
 */
public class MinHeap<T extends Comparable<T>> {
    int size = 0;
    List<T> elements;
    int index;

    public MinHeap(int size){
        elements = new ArrayList<>(size);
        this.size = size;
        this.index = size;
    }

    public void add(T ele){

    }
}

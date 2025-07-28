package structure.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxHeap<T> {

    int heapSize = 0;
    List<T> heap;
    Comparator<T> comparator;

    public MaxHeap(int size, Comparator<T> comparator){
        this.heap = new ArrayList<>(size);
        this.comparator = comparator;
    }

    

}

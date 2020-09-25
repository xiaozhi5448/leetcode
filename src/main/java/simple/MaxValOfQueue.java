package simple;

import java.util.LinkedList;
import java.util.Queue;

class MaxQueue {
    LinkedList<Integer> elements;
    LinkedList<Integer> max_vals;

    public MaxQueue() {
        elements = new LinkedList<Integer>();
        max_vals = new LinkedList<Integer>();
    }

    public int max_value() {
        if (!max_vals.isEmpty()) {
            return max_vals.getFirst();
        } else {
            return -1;
        }
    }

    public void push_back(int value) {
        elements.addLast(value);

        while (!max_vals.isEmpty() && max_vals.getFirst() <= value) {
            max_vals.removeLast();
        }
        max_vals.addLast(value);
    }

    public int pop_front() {
        if (elements.isEmpty()) {
            return -1;
        }
        int val = elements.poll();
        if (val == max_vals.peek()) {
            max_vals.removeFirst();
        }
        return val;
    }
}

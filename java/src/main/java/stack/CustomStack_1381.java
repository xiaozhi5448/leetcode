package stack;

import java.util.ArrayList;
import java.util.LinkedList;

public class CustomStack_1381 {
    int maxSize = 0;
    int[] stack;
    int top = -1;
    public CustomStack_1381(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public void push(int x) {
        if(top < maxSize-1){
            stack[++top] = x;
        }
    }

    public int pop() {
        if(top == -1){
            return -1;
        }else{
            return stack[top--];
        }
    }

    public void increment(int k, int val) {
        int count = Math.min(k, maxSize);
        for(int i = 0; i<count;i++){
            stack[i] = stack[i] + val;
        }
    }
}

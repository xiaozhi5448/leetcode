package data;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if(minStack.empty()){
            minStack.push(x);
        }else{
            minStack.push(x < minStack.peek()? x: minStack.peek());
        }

        stack.push(x);
    }

    public void pop() {
        if(!stack.empty()){
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if(!stack.empty()){
            return stack.peek();
        }
        return Integer.MAX_VALUE;
    }

    public int getMin() {
        return minStack.peek();
    }
}

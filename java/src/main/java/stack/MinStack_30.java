package stack;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class MinStack_30 {
    /** initialize your data structure here. */
    Stack<Integer> data = new Stack<>();
    Stack<Integer> helper = new Stack<>();
    public MinStack_30() {

    }

    public void push(int x) {
        data.push(x);
        if(helper.isEmpty() || x <= helper.peek()){
            helper.push(x);
        }
    }

    public void pop() {
        if(data.isEmpty()){
            return;
        }
        if(data.pop() == helper.peek()){
            helper.pop();
        }
    }

    public int top() {
        if(data.isEmpty()){
            return -1;
        }
        return data.peek();
    }

    public int min() {
        if(data.isEmpty()){
            return -1;
        }
        return helper.peek();
    }
}

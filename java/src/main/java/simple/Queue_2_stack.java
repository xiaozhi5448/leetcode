package simple;
import java.util.Stack;
// 1521用两个队列实现一个栈
public class Queue_2_stack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public Queue_2_stack(){

    }
    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack1.empty() && stack2.empty()){
            return -1;
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else{
            return stack2.pop();
        }
    }
}

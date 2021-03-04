package stack;

import java.util.Stack;

public class StackSequence_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num:pushed){
            stack.push(num);
            if(i < popped.length){
                while(!stack.isEmpty() && popped[i] == stack.peek()){
                    i++;
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}

package stack;

import java.util.LinkedList;
import java.util.Stack;

public class ValidateStack_946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length == 0){
            return true;
        }
        Stack<Integer> pushedStack = new Stack<>();
        int poppedIndex = 0;
        int pushedIndex = 0;
        pushedStack.push(pushed[pushedIndex++]);
        while(poppedIndex < popped.length && pushedIndex < pushed.length){
            while(pushedStack.empty()|| pushedStack.peek() != popped[poppedIndex]){
                pushedStack.push(pushed[pushedIndex++]);
                if(pushedIndex >= pushed.length){
                    break;
                }
            }
            if(pushedIndex >= pushed.length){
                break;
            }
            poppedIndex++;
            pushedStack.pop();
        }
        while(poppedIndex < popped.length && !pushedStack.empty()){
            if(pushedStack.pop() != popped[poppedIndex++]){
                return false;
            }
        }
        return true;
    }
}

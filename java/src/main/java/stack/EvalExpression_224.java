package stack;
import java.util.*;
public class EvalExpression_224 {
    int index;
    private boolean isDigit(char ch){
        return ch >= '0' && ch <= '9';
    }
    private Integer parseInt(String s){
        int startIndex = index;
        if(startIndex >= s.length()){
            return 0;
        }else{
            int left = startIndex;
            int right = left;
            while(right < s.length() && isDigit(s.charAt(right))){
                right++;
            }
            if(left == right){
                return 0;
            }else{
                index = right;
                return Integer.valueOf(s.substring(left, right));
            }
        }
    }
    public int calculate(String s) {
        LinkedList<String> suffixExp = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        index = 0;
        while(index < s.length()){
            if(s.charAt(index) == ' '){
                index++;continue;
            }else if(s.charAt(index) == '('){
                stack.push('(');index++;
            }else if(s.charAt(index) == ')'){
                char ch = stack.pop();
                while(!stack.isEmpty() && ch != '('){
                    suffixExp.addLast(""+ch);
                    ch = stack.pop();
                }
                index++;

            }else if(s.charAt(index) == '+' || s.charAt(index) == '-'){
                while(!stack.isEmpty() && !stack.peek().equals('(')){
                    suffixExp.add("" + stack.pop());
                }
                stack.push(s.charAt(index++));

            }
            else{
                Integer val = parseInt(s);
                suffixExp.add("" + val);

            }
        }
        while(!stack.isEmpty()){
            suffixExp.add("" + stack.pop());
        }
        stack.clear();
        int res = 0;
        Stack<Integer> tmp = new Stack<>();
        while(!suffixExp.isEmpty()){
            String item = suffixExp.pollFirst();
            if(item.equals("+")|| item.equals("-")){
                int a = tmp.pop();
                int b = 0;
                if(!tmp.isEmpty()){
                    b = tmp.pop();
                }
                tmp.push(item.equals("+")? a+b:b-a);
            }else{
                tmp.push(Integer.valueOf(item));
            }
        }
        return tmp.pop();
    }
}

package stack;

import java.util.LinkedList;

public class DecodeString_394 {
    public String decodeString(String s) {
        int index = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        while(index < s.length()){
            if(Character.isAlphabetic(s.charAt(index)) || s.charAt(index) == '['){
                stack.add((int)s.charAt(index));
                index++;
            }else if(Character.isDigit(s.charAt(index))){
                int start = index;
                while(Character.isDigit(s.charAt(index))){
                    index++;
                }
                String num_str = s.substring(start, index);
                stack.add(Integer.parseInt(num_str));
            }else{
                LinkedList<Integer> items = new LinkedList<>();
                int popRes = -1;
                while((popRes = stack.pollLast()) != '['){
                    items.addFirst(popRes);
                }
                int count = stack.pollLast();
                for(int i = 0; i< count;i++){
                    for(Integer num: items){
                        stack.addLast(num);
                    }
                }
                index++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Integer num: stack){
            sb.append((char)num.intValue());
        }
        return sb.toString();
    }
}

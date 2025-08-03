package stack;

import java.util.*;

public class ValidatePair {
    /**
     * 20. 有效的括号
     * 已解答
     * 简单
     * 相关标签
     * premium lock icon
     * 相关企业
     * 提示
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        Map<Character, Character> pair = new HashMap<>();
        pair.put('}', '{');
        pair.put(']', '[');
        pair.put(')', '(');

        List<Character> leftPairs = Arrays.asList('(', '[', '{');
        for(Character ch: s.toCharArray()){
            if(leftPairs.contains(ch)){
                stack.offerLast(ch);
            }else{
                if((!stack.isEmpty()) && Objects.equals(pair.get(ch), stack.peekLast())){
                    stack.pollLast();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

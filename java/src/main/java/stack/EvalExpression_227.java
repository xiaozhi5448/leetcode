package stack;

import java.util.*;
import java.util.regex.Pattern;

public class EvalExpression_227 {

    static Map<Character, Integer> operatorPriority = new HashMap<>();

    {
        operatorPriority.put('-', 1);
        operatorPriority.put('+', 1);
        operatorPriority.put('*', 2);
        operatorPriority.put('/', 2);
        operatorPriority.put('^', 3);
    }


    public String[] parseItem(String s) {
        Pattern pattern = Pattern.compile("(?=\\d+)|(?<=\\d)|(?=[\\+\\-\\*/\\^\\(\\)])|(?<=[\\+\\-\\*/\\^\\(\\)])");
        String exp = s.replaceAll("\\s+", "");
        return pattern.split(exp);
    }


    public LinkedList<String> inToSuffix(String[] items) {
        LinkedList<String> suffix = new LinkedList<>();
        Stack<Character> operatorStack = new Stack<>();
        for (String item : items) {
            if (Pattern.matches("\\d+", item)) {
                suffix.addLast(item);
            } else {
                char operator = item.charAt(0);
                if (operator == ')') {
                    while (!operatorStack.isEmpty()) {
                        char opt = operatorStack.pop();
                        if (opt == '(') {
                            break;
                        } else {
                            suffix.addLast("" + opt);
                        }
                    }
                } else if (operator == '(') {
                    operatorStack.push('(');
                } else {
                    while (!operatorStack.isEmpty() && operatorStack.peek() != '(' && operatorPriority.get(operatorStack.peek()) >= operatorPriority.get(operator)) {
                        suffix.addLast(operatorStack.pop() + "");
                    }
                    operatorStack.push(operator);
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            suffix.addLast(operatorStack.pop() + "");
        }
        return suffix;
    }

    public Integer calculate(String s) {
        String[] items = parseItem(s);
        LinkedList<String> suffix = inToSuffix(items);
        Stack<Integer> numStack = new Stack<>();
        for (String item : suffix) {
            if (operatorPriority.containsKey(item.charAt(0))) {
                char opt = item.charAt(0);
                int b = numStack.pop();
                int a;
                if (numStack.size() == 0) {
                    if (opt == '-') {
                        a = 0;
                    }else{
                        return Integer.MAX_VALUE;
                    }
                } else {
                    a = numStack.pop();
                }
                if (opt == '-') {
                    numStack.push(a - b);
                } else if (opt == '+') {
                    numStack.push(a + b);
                } else if (opt == '*') {
                    numStack.push(a * b);
                } else if (opt == '/') {
                    numStack.push(a / b);
                } else if (opt == '^') {
                    numStack.push((int) Math.pow(a, b));
                } else {
                    System.err.println("unknow operator!");
                    return Integer.MAX_VALUE;
                }
            } else {
                numStack.push(Integer.valueOf(item));
            }
        }
        return numStack.pop();
    }
}

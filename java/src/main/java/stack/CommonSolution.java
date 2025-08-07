package stack;

import java.util.Stack;

public class CommonSolution {
    /**
     * 739. 每日温度
     * 已解答
     * 中等
     * 相关标签
     * premium lock icon
     * 相关企业
     * 提示
     * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> minStack = new Stack<>();
        for(int i = 0; i < temperatures.length; i++){
            if(minStack.empty() || temperatures[minStack.peek()] >= temperatures[i]){
                minStack.push(i);
                continue;
            }
            while(!minStack.empty() && temperatures[minStack.peek()] < temperatures[i]){
                Integer prev = minStack.pop();
                res[prev] = i - prev;
            }
            minStack.push(i);
        }
        return res;
    }

    /**
     * 394. 字符串解码
     * 已解答
     * 中等
     * 相关标签
     * premium lock icon
     * 相关企业
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     *
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     *
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     *
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入
     */
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        int muti = 0;
        for(int i = 0; i < s.length(); i++){
            StringBuilder currWord = new StringBuilder();
            if(Character.isDigit(s.charAt(i))){
                muti = muti * 10 + s.charAt(i) - '0';
            }
            if(Character.isAlphabetic(s.charAt(i))){
                currWord.append(s.charAt(i));
            }
        }
        return "";
    }

}

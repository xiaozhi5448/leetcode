package GreedyStrategy;

import java.util.Arrays;

/**
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 */
public class MonotoneIncreasingDigit_738 {
    public int monotoneIncreasingDigits(int N) {
        String strN = Integer.toString(N);
        int index0 = 0;
        for(; index0 < strN.length(); index0++){
            if(index0 + 1 < strN.length() && strN.charAt(index0) > strN.charAt(index0+ 1)){
                break;
            }
        }
        if(index0 == strN.length()){
            return N;
        }else{
            while(index0 > 0){
                if(strN.charAt(index0) == strN.charAt(index0 - 1)){
                    index0--;
                }else{
                    break;
                }
            }

        }
        String finalstr = strN.substring(0, index0);
        int cur = strN.charAt(index0) - '1';
        StringBuilder sb = new StringBuilder(finalstr);
        sb.append(cur);
        for(int i = 0; i < strN.length() - index0 -1; i ++){
            sb.append('9');
        }

        return Integer.parseInt(sb.toString());

    }

    public int monotoneIncreasingDigitsTemplate(int N){
        // translate to char array
        char[] chs = Integer.toString(N).toCharArray();
        int index = 1;
        while(index < chs.length && chs[index-1] <= chs[index]){
            index++;
        }
        if(index == chs.length){
            return N;
        }
        while(index > 0 && chs[index] < chs[index-1]){
            index--;
            chs[index] -= 1;
        }
        index+=1;
        while(index < chs.length){
            chs[index++] = '9';
        }
        return Integer.parseInt(new String(chs));
    }
}

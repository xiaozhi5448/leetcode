package dp;

import java.util.Arrays;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class LongestParenthese_32 {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        if(dp.length == 0){
            return 0;
        }
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '('){
                dp[i] = 0;
            }else{
                if(s.charAt(i-1) == '('){
                    dp[i] = i-2 > -1? dp[i-2]+ 2:2;
                }else{
                    if(i-dp[i-1]-1 < 0){
                        dp[i] = 0;
                    }else if(s.charAt(i-dp[i-1]-1)=='('){
                        if(i-dp[i-1]-2>=0)
                        dp[i] = dp[i-1] +  dp[i-dp[i-1]-2] + 2;
                        else
                            dp[i] = dp[i-1] + 2;
                    }
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}

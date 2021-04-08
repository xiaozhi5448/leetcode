package dp;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 中心扩散
 * 动态规划
 */
public class LongestPalindrome_5 {
    public String longestPalindrome(String s) {
        char[] chs = s.toCharArray();
        if(chs.length <= 1){
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);
        int center = 1;
        int left,right;
        while(center < chs.length*2-1){
            if(center % 2==0){
                int base = center/ 2;
                right = base;
                left = base;
            }else{
                left = center /2;
                right = left+1;
            }
            while(left >= 0 && right <= chs.length-1){
                if(chs[left] == chs[right]){
                    left--;
                    right++;
                }else{
                    break;
                }
            }
            if(right-left-1 > maxLen){
                maxLen = right-left-1;
                res = s.substring(left+1, right);
            }
            center++;

        }
        return res;
    }
    // 动态规划
    public String longestPalindrome2(String s){
        if(s.length()<= 1){
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0,1);
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int length = 0; length < dp.length; length++){
            for(int i = 0; i + length < dp.length; i++){
                int j = i+length;
                if(length == 0){
                    dp[i][i] = true;
                }else if(length==1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
                }
                if(dp[i][j] && length+1 > maxLen){
                    maxLen = length+1;
                    res = s.substring(i, j+1);
                }
            }
        }
        return res;
    }
}

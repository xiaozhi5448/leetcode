package dp;

import java.util.LinkedList;
import java.util.List;

public class PalindromeSplitII_132 {
    // dfs 超时
    int minCount = Integer.MAX_VALUE;

    private void dfs(String s, int index, boolean[][] isPalindrome, int count){
        if(index == s.length()){
            minCount = Math.min(minCount, count-1);
        }else{
            for(int j = index; j < s.length(); j++){
                if(isPalindrome[index][j]){
                    dfs(s, j+1, isPalindrome, count+1);
                }
            }
        }
    }

    public int minCut(String s){
        if(s.length() <= 1){
            return 0;
        }else{
            int count = s.length();
            boolean[][] isPalindrome = new boolean[count][count];
            findAllPalindrome(s, isPalindrome);
            dfs(s, 0, isPalindrome, 0);
            return minCount;
        }
    }

    /**
     * 两次dp
     * @param s
     * @param isPalindrome
     */

    private void findAllPalindrome(String s, boolean[][] isPalindrome){
        int count = s.length();
        for(int length = 0; length < count; length++){
            for(int i = 0; i + length < count; i++){
                int j = i+length;
                if(length == 0){
                    isPalindrome[i][j] = true;
                }else if(length == 1){
                    isPalindrome[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i+1][j-1];
                }
            }
        }
    }

    public  int minCut2(String s){
        if(s.length() <= 1){
            return 0;
        }else{
            boolean[][] isPalindrome = new boolean[s.length()][s.length()];
            findAllPalindrome(s, isPalindrome);
            int[] dp = new int[s.length()];
            dp[0] = 0;
            for(int i = 1; i < s.length(); i++){
                if(isPalindrome[0][i]){
                    dp[i] = 0;
                }else{
                    dp[i] = Integer.MAX_VALUE;
                    for(int ptr = 1; ptr <= i; ptr++){
                        if(isPalindrome[ptr][i]){
                            dp[i] = Math.min(dp[i], dp[ptr-1]+1);
                        }
                    }
                }

            }
            return dp[dp.length-1];
        }
    }
}

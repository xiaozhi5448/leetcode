package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 */
public class PalindromeSplit_131 {
    private boolean isPalindromeBF(String  str, int start, int end) {
        char[] arr = str.toCharArray();
        if (start == end) {
            return true;
        } else {
            int left = start, right = end;
            while (left < right) {
                if (arr[left] == arr[right]) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    private void dfs(List<List<String>> res, List<String> comb,
                     boolean [][] isPalindrome, String str, int index) {
        if (index == str.length()) {
            res.add(new ArrayList<>(comb));
        } else {
            for (int right = index; right < str.length(); right++) {
                if (isPalindrome[index][right]){
                    comb.add(str.substring(index, right+1));
                    dfs(res, comb, isPalindrome, str, right+1);
                    comb.remove(comb.size()-1);
                }
            }
        }
    }
    public List<List<String>> partition(String s) {
        int count = s.length();
        boolean[][] dp = new boolean[count][count];
        for(int length = 0; length < count; length++){
            for(int i = 0; i + length < count; i++){
                int j = i+length;
                if(length == 0){
                    dp[i][i] = true;
                }else if(length == 1){
                    dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
                }else{
                    dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                }
            }
        }
        List<List<String>> res = new LinkedList<>();
        if(s == null || s.length() == 0){
            return res;
        }
        dfs(res, new LinkedList<>(), dp, s, 0);
        return res;
    }
}

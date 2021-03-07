package dp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * 动态规划
 *
 * 回溯+dfs
 */
public class WordSplit_139 {
    int minLen = Integer.MAX_VALUE;
    int maxLen = Integer.MIN_VALUE;

    /**
     * 动态规划
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> strs = new HashSet<>();
        for(String str: wordDict){
            if(str.length() < minLen)
                minLen = str.length();
            if(str.length() > maxLen)
                maxLen = str.length();
            strs.add(str);
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            if(i < minLen){
                dp[i] = false;
                continue;
            }else{
                for(int j = Math.max(i-maxLen, 0); j+minLen <= i; j++){
                    if(strs.contains(s.substring(j, i)) && dp[j]){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[dp.length-1];
    }

    /**
     * dfs + 回溯 超时
     * @param s
     * @param index
     * @param strs
     * @return
     */
    private boolean dfs(String s, int index, Set<String> strs){
        if(index == s.length())
            return true;
        List<Boolean> flags = new LinkedList<>();
        for(int i = index+minLen; i <= Math.min(s.length(), index+maxLen); i++){
            if(strs.contains(s.substring(index, i))){
                flags.add(dfs(s, i, strs));
            }
        }
        if(flags.size() == 0)
            return false;
        return flags.stream().anyMatch((item)-> item);

    }

    public boolean wordBreak2(String s, List<String> wordDict){
        Set<String> strs = new HashSet<>();
        for(String str: wordDict){
            if(str.length() < minLen)
                minLen = str.length();
            if(str.length() > maxLen)
                maxLen = str.length();
            strs.add(str);
        }
        boolean res = dfs(s, 0, strs);
        return res;
    }
}

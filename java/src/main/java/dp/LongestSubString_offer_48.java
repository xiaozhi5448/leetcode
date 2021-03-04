package dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class LongestSubString_offer_48 {
    /**
     * hash表+ dp
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();
        int[] dp = new int[chs.length];
        dp[0] = 1;
        map.put(chs[0], 0);
        for(int j = 1; j < chs.length; j++){
            int i = map.getOrDefault(chs[j], -1);
            map.put(chs[j], j);
            dp[j] = j-i > dp[j-1]? dp[j-1]+1: j-i;
        }
        return  Arrays.stream(dp).max().getAsInt();
    }
    /**
     * hash table + two pointer
     */
    public int lengthOfLongestSubstring2(String s){
        if(s==null || s.length() == 0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0,right = 1, ret = 1;
        char chs[] = s.toCharArray();
        map.put(chs[0], 1);
        while(right < chs.length){
            while(right < chs.length && map.getOrDefault(chs[right], 0) ==0){
                map.put(chs[right++], 1);
            }
            ret = Math.max(ret, right-left);
            if(right == chs.length){
                break;
            }
            while(chs[left] != chs[right]){
                map.put(chs[left++], 0);
            }
            map.put(chs[left++], 0);
        }
        return ret;
    }
}

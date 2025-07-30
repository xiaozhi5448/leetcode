package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class MaxSubString_03 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0,left=0;
        Set<Character> chs = new HashSet<>();
        for(int right = 0; right < s.length(); right++){
            while(left < right && chs.contains(s.charAt(right))){
                chs.remove(s.charAt(left));
                left++;
            }
            chs.add(s.charAt(right));
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}

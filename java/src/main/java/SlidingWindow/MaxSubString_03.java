package SlidingWindow;
import java.util.HashSet;
/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class MaxSubString_03 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left= 0, right=0;
        HashSet<Character> chSet = new HashSet<Character>();
        while(left < s.length()){
            if(right < s.length() && !chSet.contains(s.charAt(right))){
                chSet.add(s.charAt(right));
                right++;
            }else{
                res = Math.max(res, right - left);
                chSet.remove(s.charAt(left));
                left++;
            }
        }
        return res;
    }
}

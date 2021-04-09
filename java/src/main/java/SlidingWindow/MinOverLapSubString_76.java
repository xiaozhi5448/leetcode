package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 */
public class MinOverLapSubString_76 {
    public String minWindow(String s, String t) {
        if(t.length() == 0 || s.length() - t.length() < 0)
            return "";
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> original = new HashMap<>();
        for(int i = 0; i < t.length(); i++)
            original.put(t.charAt(i), original.getOrDefault(t.charAt(i), 0) + 1);
        int left=0;
        while(left < s.length() && !original.containsKey(s.charAt(left)))
            left++;
        if(left == s.length()) return "";
        window.put(s.charAt(left), 1);
        int right = left+1;
        boolean flag = false;
        int resLen = s.length(),resLeft = 0, resRight = 0;
        while(left < s.length()){
            flag = original.keySet().stream().allMatch((ch)->{
                return window.containsKey(ch) && window.get(ch) >= original.get(ch);
            });
            if(flag){
                if(right-left <= resLen){
                    resRight = right;
                    resLeft = left;
                    resLen = right-left;
                }
                window.put(s.charAt(left), window.getOrDefault(s.charAt(left), 0)-1);
                left++;
            }else if(right < s.length()){
                window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0)+1);
                right++;
            }else{
                break;
            }
        }
        return s.substring(resLeft, resRight);
    }
}

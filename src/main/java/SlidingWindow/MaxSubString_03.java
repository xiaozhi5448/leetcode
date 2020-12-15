package SlidingWindow;

import java.util.HashSet;

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
                res = res > right - left? res: right - left;
                chSet.remove(s.charAt(left));
                left++;
            }
        }
        return res;
    }

}

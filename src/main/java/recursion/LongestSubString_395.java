package recursion;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LongestSubString_395 {
    int res = 0;

    public void longestSubstringRecursionUtil(String s, int k) {
        HashMap<Character, Integer> chs = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (chs.containsKey(s.charAt(i))) {
                chs.put(s.charAt(i), chs.get(s.charAt(i)) + 1);
            } else {
                chs.put(s.charAt(i), 1);
            }
        }
        LinkedList<Integer> seperators = new LinkedList<>();
        int index = -1;
        for (Map.Entry<Character, Integer> entry : chs.entrySet()) {
            if (entry.getValue() < k) {
                while (true) {
                    index = s.indexOf(entry.getKey(), index + 1);
                    if (index == -1) {
                        break;
                    }
                    seperators.add(index);
                }
            }
        }
        if (seperators.isEmpty()) {
            if (s.length() > res) {
                res = s.length();
            }
        } else {
            seperators.add(0, -1);
            seperators.addLast(s.length());
            Collections.sort(seperators);
            for (int i = 1; i < seperators.size(); i++) {
                if (seperators.get(i) >= seperators.get(i - 1)+k && seperators.get(i) - seperators.get(i-1) > res)
                    longestSubstringRecursionUtil(s.substring(seperators.get(i - 1) + 1, seperators.get(i)), k);
            }
        }
    }

    public int longestSubstring(String s, int k) {
        res = 0;
        longestSubstringRecursionUtil(s, k);
        return res;
    }

}

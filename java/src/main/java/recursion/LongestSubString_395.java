package recursion;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LongestSubString_395 {

    private int dfs(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {
            return r - l + 1;
        }
        int index = l, ret = 0;
        while (index <= r) {
            while (index <= r && s.charAt(index) == split) {
                index++;
            }
            if (index > r) {
                break;
            }
            int start = index;
            while (index <= r && s.charAt(index) != split) {
                index += 1;
            }
            int length = dfs(s, start, index - 1, k);
            ret = Math.max(length, ret);
        }
        return ret;
    }

    public int longestSubstring(String s, int k) {
        int res = dfs(s, 0, s.length() - 1, k);
        return res;
    }
}

package hashtable;

import java.util.HashSet;

public class FindDifference_389 {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for(int i = 0; i < s.length(); i++){
            res ^= s.charAt(i);
        }
        for(int i = 0; i<t.length(); i++){
            res ^= t.charAt(i);
        }
        return res;
    }
}

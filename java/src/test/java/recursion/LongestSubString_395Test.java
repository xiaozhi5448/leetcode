package recursion;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString_395Test extends TestCase {

    public void testLongestSubstring() {
        LongestSubString_395 obj = new LongestSubString_395();
        HashMap<String, Integer> tests = new HashMap<>();
        tests.put("aaabb", 3);
        tests.put("ababbc", 2);
        tests.put("bbaaacbd", 3);
        for(Map.Entry<String, Integer> entry: tests.entrySet()){
            System.out.printf("%s,%d: %d\n", entry.getKey(), entry.getValue(),
                    obj.longestSubstring(entry.getKey(),entry.getValue()));
        }
    }
}
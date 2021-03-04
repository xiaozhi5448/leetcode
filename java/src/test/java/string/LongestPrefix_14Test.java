package string;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPrefix_14Test {

    @Test
    public void longestCommonPrefix() {
        String[] tests = new String[]{"flower", "flow", "flight"};
        LongestPrefix_14 obj = new LongestPrefix_14();
        System.out.println(obj.longestCommonPrefix(tests));
    }
}
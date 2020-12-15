package SlidingWindow;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinWindowSubString_76Test {

    @Test
    public void minWindow() {
        MinWindowSubString_76 obj = new MinWindowSubString_76();
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(obj.minWindow("aa", "aa"));
    }
}
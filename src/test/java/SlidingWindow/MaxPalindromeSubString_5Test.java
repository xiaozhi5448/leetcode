package SlidingWindow;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxPalindromeSubString_5Test {

    static MaxPalindromeSubString_5 obj;

    @BeforeClass
    public static void init(){
        obj = new MaxPalindromeSubString_5();
    }


    @Test
    public void isPalindrome() {
        System.out.println(obj.isPalindrome("bba"));
    }

    @Test
    public void longestPalindrome() {
        System.out.println(obj.longestPalindrome("aa"));
    }
}
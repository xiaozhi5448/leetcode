package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FindSubStr_28Test {

    @Test
    public void strStr() {
        FindSubStr_28 util = new FindSubStr_28();
        int res = util.strStr("today is sunday", "day");
        System.out.println(res);
        res = util.strStrWithKmp("mississippi", "sippi");
        System.out.println(res);
        res = util.strStrWithKmp("adcadcaddcadde", "adcadde");
        System.out.println(res);
        System.out.println(util.hash("adcadde".toCharArray(), 0, 6));
        System.out.println(util.hash("ddcadde".toCharArray(), 0, 6));
        int[] next = util.calNext("aabaa");
        System.out.println(Arrays.toString(next));
        next = util.calNext("aaaaaaaaaaaa");
        System.out.println(Arrays.toString(next));
        assertEquals(util.strStrWithKmp("hello", "ll"), "hello".indexOf("ll"));
        String haystack = "ababcaababcaabc";
        String needle = "ababcaabc";
        assertEquals(util.strStrWithKmp(haystack, needle) ,haystack.indexOf(needle));
        System.out.println(haystack.indexOf(needle));
    }
}
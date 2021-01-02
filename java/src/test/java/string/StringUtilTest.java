package string;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {
    static StringUtil util;

    @BeforeClass
    public static void init(){
        System.out.printf("init:\n");
        util = new StringUtil();
    }

    @Test
    public void strStr_brute() {
        System.out.println(util.strStr_brute("test321jfslakjfd;", "akj"));
    }

    @Test
    public void strStr_kmp() {
        int index = util.strStr_kmp("aaaaaaaab", "aaaaaab");
        System.out.println(index);
        index = util.strStr_kmp("hello", "ll");
        System.out.println(index);
        index = util.strStr_kmp("mississippi", "issip");
        System.out.println(index);
        index = util.strStr_kmp("ababcaababcaabc", "ababcaabc");
        System.out.println(index);
    }
}
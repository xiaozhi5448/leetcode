package string;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FindSubStr_28Test {

    @Test
    public void strStr() {
        FindSubStr_28 util = new FindSubStr_28();
        int res = util.strStr("today is sunday", "day");
        System.out.println(res);
        res = util.strStr("mississippi", "sippi");
        System.out.println(res);
        res = util.strStr("adcadcaddcadde", "adcadde");
        System.out.println(res);
        System.out.println(util.hash("adcadde".toCharArray(), 0, 6));
        System.out.println(util.hash("ddcadde".toCharArray(), 0, 6));

        int[] next = util.calNext("aabaa");
        System.out.println(Arrays.toString(next));

    }
}
package string;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindSubStr_28Test {

    @Test
    public void strStr() {
        FindSubStr_28 util = new FindSubStr_28();
        int res = util.strStr("today is sunday", "day");
        System.out.println(res);
    }
}
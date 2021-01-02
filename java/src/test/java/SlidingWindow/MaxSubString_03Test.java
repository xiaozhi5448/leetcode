package SlidingWindow;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class MaxSubString_03Test {
    Logger logger = LoggerFactory.getLogger(MaxSubString_03Test.class);

    @Test
    public void lengthOfLongestSubstring() {
        MaxSubString_03 obj = new MaxSubString_03();
        int res = obj.lengthOfLongestSubstring("abcabcbb");
        logger.info(Integer.toString(res));
        logger.info(Integer.toString(obj.lengthOfLongestSubstring("pwwkew")));

    }
}
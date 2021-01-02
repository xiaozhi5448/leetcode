package stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class DecodeString_394Test {

    @Test
    public void decodeString() {
        DecodeString_394 decodeUtil = new DecodeString_394();
        String[] tests = {"3[a]2[bc]", "3[a2[c]]", "2[abc]3[cd]ef", "abc3[cd]xyz"};
        for(String testCase: tests){
            System.out.printf("%s: %s\n", testCase, decodeUtil.decodeString(testCase));
        }
    }
}
package dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LongestParenthese_32Test {

    @Test
    public void longestValidParentheses() {
        LongestParenthese_32 util = new LongestParenthese_32();

        List<String> tests = Arrays.asList("(()", ")()())", "(())(");
        for(String test:tests){
            System.out.println(String.format("%s: %d", test, util.longestValidParentheses(test)));
        }
    }
}
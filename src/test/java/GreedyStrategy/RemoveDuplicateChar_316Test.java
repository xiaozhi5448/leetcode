package GreedyStrategy;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicateChar_316Test {

    @Test

    public void removeDuplicateLetters() {
        RemoveDuplicateChar_316 obj = new RemoveDuplicateChar_316();
        String[] tests = {"cbacdcbc", "bcabc", "abacb"};
        for(int i =0; i< tests.length;i ++){
            String res = obj.removeDuplicateLetters(tests[i]);
            System.out.printf("test %d: (%s, %s)\n", i+1, tests[i], res);
        }
    }
}
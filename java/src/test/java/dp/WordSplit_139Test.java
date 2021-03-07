package dp;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class WordSplit_139Test {

    @Test
    public void wordBreak() {
        WordSplit_139 util = new WordSplit_139();
        boolean res = util.wordBreak2("applepenapple", Arrays.asList("apple", "pen"));
        System.out.println(res);
    }
}
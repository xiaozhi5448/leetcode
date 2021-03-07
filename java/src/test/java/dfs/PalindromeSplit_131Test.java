package dfs;

import junit.framework.TestCase;

import java.util.List;

public class PalindromeSplit_131Test extends TestCase {

    public void testPartition() {
        PalindromeSplit_131 util  = new PalindromeSplit_131();
        List<List<String>> res = util.partition("aab");
        System.out.println(res.toString());
        System.out.println(util.partition("abcbca").toString());
        System.out.println(util.partition(""));
    }
}
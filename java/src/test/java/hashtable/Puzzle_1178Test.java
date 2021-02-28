package hashtable;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Puzzle_1178Test extends TestCase {

    public void testFindNumOfValidWords() {
        Puzzle_1178 util = new Puzzle_1178();
        String[] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz",
                "gaswxyz"};
        String[] words ={"aaaa","asas","able","ability","actt","actor","access"};
        List<Integer> res = util.findNumOfValidWords(words, puzzles);
        System.out.println(res);
        List<String> line = Arrays.asList("aboveyz","abrodyz","abslute","absoryz","actresz",
                "gaswxyz");
    }
}
package recursion;

import junit.framework.TestCase;

import java.util.List;

public class StringCombine_17Test extends TestCase {

    public void testLetterCombinations() {
        StringCombine_17 obj = new StringCombine_17();
        List<String> res = obj.letterCombinations("23");
        System.out.println(res);
    }
}
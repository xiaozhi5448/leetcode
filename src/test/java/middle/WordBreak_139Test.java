package middle;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class WordBreak_139Test extends TestCase {

    public void testWordBreak() {
        WordBreak_139 obj = new WordBreak_139();
        List<String> dicts = new ArrayList<String>();
        dicts.add("leet");
        dicts.add("code");
        obj.wordBreak("leetcode", dicts);
    }
}
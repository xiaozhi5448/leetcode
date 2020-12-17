package hashtable;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class StringClassify_49Test {

    @Test
    public void groupAnagrams() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        StringClassify_49 obj = new StringClassify_49();
        List<List<String>> res = obj.groupAnagrams(strs);
        System.out.println(res);
    }
}
package UnionSet;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest  {
    @Test
    public void testTrulyMostPopular() {
        Solution solution = new Solution();
        String[] names = new String[]{"John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"};
        String[] synonyms = {"(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"};
        String[] res = solution.trulyMostPopular(names, synonyms);
        System.out.println(Arrays.toString(res));
    }
}
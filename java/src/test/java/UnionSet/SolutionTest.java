package UnionSet;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class SolutionTest  {
    @Test
    public void testTrulyMostPopular() {
        BabyNames_17 solution = new BabyNames_17();
        String[] names = new String[]{"John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"};
        String[] synonyms = {"(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"};
        String[] res = solution.trulyMostPopular(names, synonyms);
        System.out.println(Arrays.toString(res));
        Random rand = new Random();
        for(int i = 0; i< 10 ;i++)
        System.out.println(rand.nextFloat());
    }
}
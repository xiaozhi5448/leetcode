package UnionSet;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BabyNames_17Test {

    @Test
    public void trulyMostPopular() {
        BabyNames_17 util = new BabyNames_17();
        String[] names = new String[]{"John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"};
        String[] synonyms = new String[]{"(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris," +
                "Christopher)"};
        String[] res = util.trulyMostPopular(names, synonyms);
        System.out.println(Arrays.toString(res));
    }
}
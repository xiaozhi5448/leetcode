package dp;

import junit.framework.TestCase;

import java.util.Arrays;

public class DiceProbability_offer_60Test extends TestCase {

    public void testDicesProbability() {
        DiceProbability_offer_60 util = new DiceProbability_offer_60();
        double[] res = util.dicesProbability(6);
        System.out.println(Arrays.toString(res));
    }
}
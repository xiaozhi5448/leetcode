package heap;

import junit.framework.TestCase;

import java.util.Arrays;

public class SmallestK_offer40Test extends TestCase {

    public void testGetLeastNumbers2() {
        SmallestK_offer40 util = new SmallestK_offer40();
        int[] arr = {0,1,2,1};
        int[] res = util.getLeastNumbers2(arr, 1);
        System.out.println(Arrays.toString(res));
    }
}
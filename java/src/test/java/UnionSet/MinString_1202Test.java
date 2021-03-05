package UnionSet;

import heap.SmallestK_offer40;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class MinString_1202Test {

    @Test
    public void smallestStringWithSwaps() {
        MinString_1202 util = new MinString_1202();
        List<List<Integer>> pairs = new LinkedList<>();
        pairs.add(Arrays.asList(0, 3));
        pairs.add(Arrays.asList(1, 2));
        String res = util.smallestStringWithSwaps("dcab", pairs);
        System.out.println(res);
    }
}
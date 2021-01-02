package simple;

import java.util.LinkedList;

public class HanMingDistance {
    private void convert_10_2(int val, LinkedList<Integer> l){

    }
    public int hammingDistance(int x, int y) {
        int res;
        res = x ^ y;
        return Integer.bitCount(res);
    }
}

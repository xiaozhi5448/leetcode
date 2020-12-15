package simple;

import SlidingWindow.MaxSubString_03;

import java.util.BitSet;

public class SingleNumber {
    // 也可以进行全员异或
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int item:nums){
            res ^= item;
        }
        return res;
    }
}

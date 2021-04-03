package dp;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LongestCommonSubSeq_1143Test{
    @Test
    public void testLongestCommonSubsequence() {
        LongestCommonSubSeq_1143 util = new LongestCommonSubSeq_1143();
        int res = util.longestCommonSubsequence("abcde", "ace");
        System.out.println(res);

        List<Integer> nums = new LinkedList<>();
        nums.addAll(Arrays.asList(1,2,3,4,5));
        int sum = nums.stream().reduce((a,b)-> a+b).get();
        System.out.println(sum);
    }
}
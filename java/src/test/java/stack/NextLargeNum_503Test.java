package stack;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class NextLargeNum_503Test {

    @Test
    public void nextGreaterElements() {
        NextLargeNum_503 util = new NextLargeNum_503();
        int[] nums = {5,4,3,2,1};
        int[] res = util.nextGreaterElements2(nums);
        System.out.println(Arrays.toString(res));
    }
}
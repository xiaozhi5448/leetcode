package bit;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingleNumber_137Test {

    @Test
    public void singleNumber() {
        SingleNumber_137 obj = new SingleNumber_137();
        int[] nums = {2,2,3,2};
        int res = obj.singleNumber2(nums);
        System.out.println(res);

    }
}
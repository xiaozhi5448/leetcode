package didi;

import interview.didi.Solution;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest extends TestCase {

    @Test
    public void testConvert(){
        Solution solution = new Solution();
        int i = solution.numConvert("000010");
        Assert.assertEquals(10, i);
        i = solution.numConvert("900010");
        Assert.assertEquals(900010, i);
    }

    @Test
    public void testException(){
        Solution solution = new Solution();
        solution.numConvert("0x9874");
    }


    @Test
    public void testExceptionOverFlow(){
        Solution solution = new Solution();
        solution.numConvert("3897465829736479852634785");
    }

}
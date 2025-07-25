package transform;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Solution3335Test extends TestCase {

    @Test
    public void test1(){
        System.out.println(Integer.MAX_VALUE);
        Solution3335 solution3335 = new Solution3335();
        Assert.assertEquals(7, solution3335.lengthAfterTransformations("abcyy", 2));
        Assert.assertEquals(5, solution3335.lengthAfterTransformations("azbk", 1));
        Assert.assertEquals(2, solution3335.lengthAfterTransformations("cu", 5));
        Assert.assertEquals(79033769, solution3335.lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 7517));


        Assert.assertEquals(7, solution3335.lengthAfterTransformations("abcyy", 2, Arrays.asList(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2)));
        Assert.assertEquals(8, solution3335.lengthAfterTransformations("azbk", 1, Arrays.asList(2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2)));
    }

}
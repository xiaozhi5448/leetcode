package binarysearch;

import junit.framework.TestCase;
import org.junit.Assert;

public class CommonSolutionTest extends TestCase {

    public void testSearch(){
        CommonSolution commonSolution = new CommonSolution();
        int search = commonSolution.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8);
        Assert.assertEquals(4, search);

        int index = commonSolution.search(new int[]{5, 1, 2, 3, 4}, 1);
        Assert.assertEquals(1, index);
    }

    public void testMin(){
        CommonSolution commonSolution = new CommonSolution();
        int minval = commonSolution.findMin(new int[]{3, 4, 5, 1, 2});
        Assert.assertEquals(1, minval);
        minval = commonSolution.findMin(new int[]{4, 5, 6, 1, 2, 3});
        Assert.assertEquals(1, minval);
    }

}
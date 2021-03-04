package array;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DisappearedNumber_448Test  {
    static DisappearedNumber_448 util = new DisappearedNumber_448();
    static Logger logger = LoggerFactory.getLogger(DisappearedNumber_448Test.class);
    @BeforeClass
    public static void init(){
        logger.info("init!");
    }
    @Test
    public void testFindDisappearedNumbers() {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> res = util.findDisappearedNumbers(nums);
        System.out.println(res.toString());

    }
}
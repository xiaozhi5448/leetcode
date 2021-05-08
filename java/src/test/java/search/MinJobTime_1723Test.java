package search;

import org.junit.Test;
import util.TransUtil;

public class MinJobTime_1723Test {

    @Test
    public void minimumTimeRequired() {
        int[] jobs = TransUtil.convertStrToArr("[3,2,3]");
        MinJobTime_1723 util = new MinJobTime_1723();
        int res = util.minimumTimeRequired(jobs, 3);
        System.out.println(res);

        jobs = TransUtil.convertStrToArr("[1,2,4,7,8]");
        res = util.minimumTimeRequired(jobs, 2);
        System.out.println(res);
    }
}
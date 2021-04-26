package dfs;

import org.junit.Test;

import java.util.List;

public class CombCount_40Test {

    @Test
    public void combinationSum2() {
        CombCount_40 util = new CombCount_40();
        List<List<Integer>> res = util.combinationSum2(new int[]{2,5,2,1,2},5);
        System.out.println(res.toString());
    }
}
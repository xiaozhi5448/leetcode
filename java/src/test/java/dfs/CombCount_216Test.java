package dfs;

import dfs.combination.CombCount_216;
import org.junit.Test;

import java.util.List;

public class CombCount_216Test {

    @Test
    public void combinationSum3() {
        CombCount_216 util = new CombCount_216();
        List<List<Integer>> res = util.combinationSum3(3, 7);
        System.out.println(res.toString());
        res = util.combinationSum3(3, 9);
        System.out.println(res.toString());
        res = util.combinationSum3(3, 15);
        System.out.println(res.toString());
    }
}
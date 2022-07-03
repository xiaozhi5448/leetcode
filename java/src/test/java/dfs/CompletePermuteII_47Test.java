package dfs;

import dfs.permutation.CompletePermuteII_47;
import org.junit.Test;

import java.util.List;


public class CompletePermuteII_47Test {

    @Test
    public void permuteUnique() {
        CompletePermuteII_47 util = new CompletePermuteII_47();
        List<List<Integer>> res = util.permuteUnique(new int[]{1,1,2});
        System.out.println(res.toString());
    }
}
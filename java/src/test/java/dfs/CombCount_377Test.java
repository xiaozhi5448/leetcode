package dfs;

import dfs.combination.CombCount_377;
import org.junit.Test;

public class CombCount_377Test {

    @Test
    public void combinationSum4() {
        CombCount_377 util = new CombCount_377();
        int res = util.combinationSum4(new int[]{9}, 3);
        System.out.println(res);
    }
}
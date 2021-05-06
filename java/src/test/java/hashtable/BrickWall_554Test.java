package hashtable;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class BrickWall_554Test {

    public List<List<Integer>> trans(int[][] nums){
        List<List<Integer>> res = new LinkedList<>();
        for(int[] line: nums){
            List<Integer> l = new LinkedList<>();
            for(int num:line){
                l.add(num);
            }
            res.add(l);
        }
        return res;
    }
    @Test
    public void leastBricks() {
        int[][] bricks = new int[][]{{1,2,2,1},{3,1,2},{1,3,2},{2,4},{3,1,2},{1,3,1,1}};
        BrickWall_554 util = new BrickWall_554();
        int res = util.leastBricks(trans(bricks));
        System.out.println(res);
    }
}
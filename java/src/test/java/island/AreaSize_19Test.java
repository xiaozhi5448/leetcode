package island;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AreaSize_19Test {

    @Test
    public void pondSizes() {
        AreaSize_19 util = new AreaSize_19();
        int[][] land = new int[][]{{0,2,1,0},{0,1,0,1},{1,1,0,1},{0,1,0,1}};
        int[] area = util.pondSizes(land);
        System.out.println(Arrays.toString(area));
    }
}
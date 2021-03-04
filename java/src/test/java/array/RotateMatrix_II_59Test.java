package array;

import junit.framework.TestCase;

import java.util.Arrays;

public class RotateMatrix_II_59Test extends TestCase {

    public void testGenerateMatrix() {
        RotateMatrix_II_59 util = new RotateMatrix_II_59();
        int[][] res = util.generateMatrix(3);
        System.out.println(Arrays.deepToString(res));

    }
}
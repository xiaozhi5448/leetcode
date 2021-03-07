package array;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class RotateMatrix_II_59Test extends TestCase {

    public void testGenerateMatrix() {
        RotateMatrix_II_59 util = new RotateMatrix_II_59();
        int[][] res = util.generateMatrix(3);
        System.out.println(Arrays.deepToString(res));
        HashSet<String> set = new HashSet<>();
        set.addAll(Arrays.asList("*", "/"));
        System.out.println(Integer.valueOf(56));
        System.out.println(Integer.valueOf("56"));
    }
}
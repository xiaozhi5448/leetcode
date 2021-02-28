package GreedyStrategy;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class VideoStitchingTest extends TestCase {

    public void testVideoStitching2() {
        int[][] arr1 = {{0,2}, {4, 6}, {8, 10}, {1,9}, {1, 5}, {5, 9}};
        VideoStitching util = new VideoStitching();
        int res  = util.videoStitching2(arr1, 10);
        System.out.println(res);
        int[][] arr2 = {{0,2}};
        res = util.videoStitching2(arr2, 0);
        System.out.println(res);

        List<String> nums = new ArrayList<>();
        String res0 = String.join("->", Arrays.asList("hello", "world"));
        System.out.println(res0);
        nums.add("3");
        nums.add("4");
        String res1 = nums.stream().reduce((a, b)-> a + "->" + b).get();
        System.out.println();
        Optional<Integer> res3 = nums.stream().map(Integer::valueOf).reduce((a,b)-> a+b);
        System.out.println(res3.get());
        nums.add(res1);
        System.out.println(nums);



    }
}
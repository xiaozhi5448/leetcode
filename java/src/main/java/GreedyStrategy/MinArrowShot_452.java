package GreedyStrategy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 *
 */
public class MinArrowShot_452 {

    public int findMinArrowShots(int[][] points) {
        if(points.length <= 1){
            return points.length;
        }
        Arrays.sort(points, (int[] arr1, int[] arr2) -> {
            if(arr1[1] != arr2[1]){
                return arr1[1] < arr2[1]? -1:1;
            }else{
                return arr1[0] < arr2[0]? -1:1;
            }
        });
        int index = 0, shoot_pos = points[0][1];
        int count = 1;
        while(index < points.length){
            while(index < points.length && points[index][0] <= shoot_pos){
                index += 1;
            }
            if(index < points.length){
                shoot_pos = points[index][1];
                count += 1;
            }
        }
        return count;
    }
}

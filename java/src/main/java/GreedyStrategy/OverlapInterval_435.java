package GreedyStrategy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 * 贪心算法，每次选择右端点最小的一个区间
 */
public class OverlapInterval_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int bound = Integer.MIN_VALUE /2,leaves =0;

        for(int i = 0; i< intervals.length;i++){
            if(intervals[i][0] >= bound){
                leaves ++;
                bound = intervals[i][1];
            }
        }
        return intervals.length - leaves;
    }
}

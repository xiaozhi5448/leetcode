package array;

import java.util.*;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 排序：合并
 */
public class AreaMerge_56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] !=o2[0]?  o1[0]-o2[0]: o1[1]-o2[1];
            }
        });
        List<int[]> arrs = new ArrayList<>(intervals.length);
        arrs.add(intervals[0]);
        int index = 1;
        while(index < intervals.length){
            int[] prev = arrs.get(arrs.size()-1);
            while(index < intervals.length && intervals[index][0] <= prev[1]){
                prev[1] = Math.max(prev[1], intervals[index++][1]);
            }
            if(index != intervals.length){
                arrs.add(intervals[index++]);
            }
        }
        return arrs.toArray(new int[arrs.size()][]);
    }
}

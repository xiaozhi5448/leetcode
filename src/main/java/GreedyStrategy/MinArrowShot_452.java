package GreedyStrategy;

import java.util.Arrays;
import java.util.Comparator;

public class MinArrowShot_452 {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 1){
            return 1;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                long res =  (long)(o1[1]) - (long)(o2[1]);
                if(res <0){
                    return -1;
                }else if(res == 0){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
        int res = 0;
        int pos = 0;
        int next_pos=0;
        for(int i = next_pos; i< points.length;){
            pos = points[i][1];
            while( i<points.length && points[i][0] <= pos){
                i++;
            }
            res++;

        }
        return res;

    }
}

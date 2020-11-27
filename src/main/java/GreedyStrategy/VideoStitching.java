package GreedyStrategy;

public class VideoStitching {
    public int videoStitching(int[][] clips, int T){
        int count = 0, prev_end = 0, prev_start = -1;
        boolean update_index = false;
        int start = 0, end = 0;
        while(prev_end < T){
            update_index = false;
            end = prev_end;
            for(int[] segment: clips){
                if(segment[0] > prev_start && segment[0] <= prev_end){
                    if(segment[1] > end){
                        start = segment[0];
                        end = segment[1];
                        update_index = true;
                    }
                }
            }
            if(update_index == false){
                return -1;
            }
            prev_start = start;
            prev_end = end;
            count += 1;
        }
        return count;
    }
}

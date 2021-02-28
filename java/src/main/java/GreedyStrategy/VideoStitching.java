package GreedyStrategy;

import java.util.Arrays;

/**
 * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 *
 * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，
 * 例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 *
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。
 * 返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 *
 */
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

    public int videoStitching2(int[][] clips, int T) {
        if(T == 0){
            return 0;
        }
        Arrays.sort(clips, (int[] arr1, int[] arr2)->{
            if(arr1[0] != arr2[0])
                return arr1[0] - arr2[0];
            else
                return arr1[1] - arr2[1];
        });
        int index = 0, bound = 0,count = 0,next_bound=0;
        while(index < clips.length){
            next_bound = 0;
            while(index < clips.length && clips[index][0] <= bound){
                next_bound = Math.max(next_bound, clips[index][1]);
                index += 1;
            }
            count += 1;
            bound = next_bound;
            if(next_bound == 0){
                return -1;
            }else if(next_bound >= T){
                return count;
            }
        }
        if(bound >= T){
            return count;
        }
        return -1;
    }
}

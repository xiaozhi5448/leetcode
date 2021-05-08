package search;

import java.util.Arrays;

/**
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 *
 * 请你将这些工作分配给 k 位工人。
 * 所有工作都应该分配给工人，且每项工作只能分配给一位工人。
 * 工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。
 * 请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 *
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 *
 * 输入：jobs = [3,2,3], k = 3
 * 输出：3
 * 解释：给每位工人分配一项工作，最大工作时间是 3 。
 *
 *
 * continuing......
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs
 */
public class MinJobTime_1723 {
    private boolean success(int[] jobs, int k, int bound){
        int num = 0;
        int currentTime = 0;
        int i = 0;
        while(i < jobs.length){
            while(i < jobs.length && currentTime + jobs[i] <= bound){
                currentTime += jobs[i++];
            }
            num++;
            currentTime = 0;

        }
        return num <= k;
    }
    public int minimumTimeRequired(int[] jobs, int k) {
        int totalTime = Arrays.stream(jobs).sum();
        int low = Arrays.stream(jobs).max().getAsInt();
        if(success(jobs, k, low)){
            return low;
        }
        int high = totalTime;
        while(low < high){
            int mid = (low+high)/2;
            if(success(jobs, k, mid)){
                high = mid;
            }else{
                low = mid;
            }
        }
        if(success(jobs, k, low)){
            return low;
        }
        return totalTime;
    }
}

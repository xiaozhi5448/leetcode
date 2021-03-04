package dp;

import java.util.Arrays;

/**
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 *
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 *
 */
public class LongestTerbulanceArr_978 {
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length <= 1){
            return arr.length;
        }
        int dp[][] = new int[arr.length][2];
        Arrays.fill(dp[0], 1);
        int res = 1;
        for(int i = 1; i< arr.length; i++){
            dp[i][0] = arr[i] < arr[i-1]? dp[i-1][1] + 1: 1;
            dp[i][1] = arr[i] > arr[i-1]? dp[i-1][0] + 1: 1;
            res = Math.max(dp[i][0], res);
            res = Math.max(dp[i][1], res);
        }
        return res;
    }
}

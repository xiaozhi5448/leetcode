package dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 最长递增子序列问题的扩展，二维的情况，先根据第一维升序排列，根据第二维降序排列
 * 求第二维度上的最长递增子序列
 */
public class NestedEnvelop_354 {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length <= 1){
            return envelopes.length;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0]? o1[0] - o2[0]: o2[1]-o1[1];
            }
        });
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        int res = 1;
        for(int i = 1; i< envelopes.length; i++){
            int max = 1;
            for(int j = 0; j < i; j++){
                if(envelopes[i][1] > envelopes[j][1]){
                    max = Math.max(max, dp[j]+1);
                }
            }
            dp[i] = max;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

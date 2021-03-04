package dp;

import java.util.Arrays;

/**
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 */
public class MaxProfitIV_188 {

    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        k = Math.min(k, prices.length /2);
        int[][] buy = new int[prices.length][k+1];
        int[][] sell = new int[prices.length][k+1];
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for(int i = 1; i < k+1;i++){
            buy[0][i] = Integer.MIN_VALUE/2;
            sell[0][i] = Integer.MIN_VALUE/2;
        }

        for(int day=1;day<prices.length;day++){
            buy[day][0] = Math.max(sell[day-1][0] - prices[day], buy[day-1][0]);
            for(int j = 1;j<=k;j++){
                buy[day][j] = Math.max(sell[day-1][j] - prices[day], buy[day-1][j]);
                sell[day][j]  = Math.max(buy[day-1][j-1] + prices[day], sell[day-1][j]);
            }
        }
        int res = Arrays.stream(sell[prices.length-1]).max().getAsInt();
        return res;
    }
}

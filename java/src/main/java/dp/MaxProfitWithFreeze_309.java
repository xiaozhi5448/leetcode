package dp;

/**
 *
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 */
public class MaxProfitWithFreeze_309 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] profits = new int[prices.length][3];
        profits[0][0] = -prices[0];
        profits[0][1] = Integer.MIN_VALUE / 2;
        profits[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            profits[i][0] = Math.max(profits[i - 1][2] - prices[i],
                    profits[i - 1][0]);
            profits[i][1] = profits[i-1][0] + prices[i];
            profits[i][2] = Math.max( profits[i-1][2], profits[i-1][1]);
        }
        return Math.max(profits[prices.length-1][1], profits[prices.length-1][2]);

    }
}

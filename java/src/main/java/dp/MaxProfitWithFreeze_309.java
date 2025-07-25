package dp;

/**

 309. Best Time to Buy and Sell Stock with Cooldown
 Medium
 Topics
 Companies
 You are given an array prices where prices[i] is the price of a given stock on the ith day.

 Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

 After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).



 Example 1:

 Input: prices = [1,2,3,0,2]
 Output: 3
 Explanation: transactions = [buy, sell, cooldown, buy, sell]
 Example 2:

 Input: prices = [1]
 Output: 0


 Constraints:

 1 <= prices.length <= 5000
 0 <= prices[i] <= 1000
 */
public class MaxProfitWithFreeze_309 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] profits = new int[prices.length][3];
        profits[0][0] = -prices[0]; // 持有
        profits[0][1] = Integer.MIN_VALUE / 2; // 卖出
        profits[0][2] = 0; // 不持有股票(可能在冷静期也可能不在)
        for (int i = 1; i < prices.length; i++) {
            profits[i][0] = Math.max(profits[i - 1][2] - prices[i],
                    profits[i - 1][0]);
            profits[i][1] = profits[i-1][0] + prices[i];
            profits[i][2] = Math.max( profits[i-1][2], profits[i-1][1]);
        }
        return Math.max(profits[prices.length-1][1], profits[prices.length-1][2]);

    }
}

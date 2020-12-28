package dp;

public class MaxProfitII_122 {
    public int maxProfit(int[] prices) {
        int res = 0;
        if(prices.length == 0){
            return 0;
        }
        int[][] profits = new int[prices.length][2];
        profits[0][0] = 0;profits[0][1] = -prices[0];
        for(int i = 1; i< prices.length;i++){
            profits[i][0] = Math.max(profits[i-1][1] + prices[i], profits[i-1][0]);
            profits[i][1] = Math.max(profits[i-1][0] - prices[i], profits[i-1][1]);
        }
        res = profits[prices.length-1][0];
        return res;
    }
}

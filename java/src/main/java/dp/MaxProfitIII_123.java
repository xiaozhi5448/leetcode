package dp;

import java.util.Arrays;

public class MaxProfitIII_123 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int count = Math.min(2, prices.length/2);
        int[][] buy = new int[prices.length][3];
        int[][] sell = new int[prices.length][3];
        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        sell[0][1] = sell[0][2] = buy[0][1] = buy[0][2] = Integer.MIN_VALUE/2;

        for(int i = 1; i< prices.length;i++){
            buy[i][0] = Math.max(buy[i-1][0], sell[i-1][0] - prices[i]);
            for(int j = 1; j <= count;j++){
                buy[i][j] = Math.max(buy[i-1][j], sell[i-1][j] - prices[i]);
                sell[i][j] = Math.max(buy[i-1][j-1] + prices[i], sell[i-1][j]);
            }
        }
        return Arrays.stream(sell[prices.length-1]).max().getAsInt();
    }
}

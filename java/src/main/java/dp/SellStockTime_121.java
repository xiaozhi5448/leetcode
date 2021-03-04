package dp;

public class SellStockTime_121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int profit = 0;
        for(int i = 0; i< prices.length;i++){
            int latterMax = Integer.MIN_VALUE/2;
            for(int j = i+1; j < prices.length; j++){
                if(prices[j] > latterMax){
                    latterMax = prices[j];
                }
            }
            if(latterMax > prices[i]){
                profit = latterMax - prices[i];
                if(profit > res){
                    res = profit;
                }
            }

        }
        return res;
    }
    public int maxProfit2(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i = 1; i<prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
                continue;
            }
            if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}

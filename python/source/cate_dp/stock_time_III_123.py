class Solution:
    def maxProfit(self, prices) -> int:
        if not prices:
            return 0

        def maxProfitWithK(self, prices, k):
            trade_count = min(k, len(prices) // 2)
            buy = [[float('-inf')] * trade_count for _ in range(trade_count)]
            sell = [[float('-inf')] * trade_count for _ in range(trade_count)]
            buy[0][0] = -prices[0]
            sell[0][0] = 0

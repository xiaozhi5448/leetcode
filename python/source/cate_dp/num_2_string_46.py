class Solution:
    def translateNum(self, num: int) -> int:
        items = str(num)
        if len(items) <2:
            return 1
        dp = [None] * len(items)
        dp[0] = 1
        if items[0] != 0 and 0<= int(items[0:2]) < 26:
            dp[1] = dp[0] + 1
        else:
            dp[1] = dp[0]
        if len(items) > 2:
            for i in range(2, len(items)):
                if items[i-1] != '0' and 0 <= int(items[i-1:i+1]) < 26:
                    dp[i] = dp[i-2] + dp[i-1]
                else:
                    dp[i] = dp[i-1]
        return dp[-1]

if __name__ == '__main__':
    so = Solution()
    res = so.translateNum(0)
    print(res)
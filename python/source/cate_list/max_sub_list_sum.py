class Solution:

    # dp
    def solution2(self, nums):
        max_sum = float('-inf')
        dp = [None] * len(nums)
        dp[0] = nums[0]
        for i in range(1, len(nums)):
            dp[i] = max(dp[i-1] + nums[i], nums[i])
        return max(dp)

    def maxSubArray(self, nums: list) -> int:
        self.max_sum = float('-inf')
        dp = [[None] * len(nums) for _ in range(len(nums))]
        max_sum = float('-inf')
        length = len(nums)
        if length == 1:
            return nums[0]
        for i in range(length):
            dp[i][i] = nums[i]
        for i in range(length):
            for j in range(i+1, length):
                dp[i][j] = nums[j] + dp[i][j-1]
        for i in range(length):
            for j in range(i, length):
                if dp[i][j] > max_sum:
                    max_sum = dp[i][j]
        return max_sum

if __name__ == '__main__':
    so = Solution()
    nums = [1,2,-1,-2,2,1,-2,1,4,-5,4]
    res = so.solution2(nums)
    print(res)
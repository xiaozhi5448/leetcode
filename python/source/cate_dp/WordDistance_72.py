class Solution:
    """
    给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

    插入一个字符
    删除一个字符
    替换一个字符
    """
    def minDistance(self, word1: str, word2: str) -> int:
        length1 = len(word1)
        length2 = len(word2)
        dp = [[0] * (length1+1) for _ in range(length2+1)]
        for i in range(length1+1):
            dp[0][i] = i
        for j in range(length2+1):
            dp[j][0] = j
        for i in range(1, length2+1):
            for j in range(1, length1+1):
                a = dp[i-1][j] +1
                b = dp[i][j-1]+1
                c = dp[i-1][j-1]
                if word1[j-1] != word2[i-1]:
                    c += 1
                dp[i][j] = min(a,b,c)
        return dp[-1][-1]

if __name__ == '__main__':
    so = Solution()
    res = so.minDistance("horse", "ros")
    print(res)
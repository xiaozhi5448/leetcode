"""
把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
动态规划：投掷第n颗 骰子的结果，与前面n-1颗的结果有关
"""

class Solution:
    def dicesProbability(self, n: int):
        row_count = n
        col_count = 6*n
        matrix = [[0]  *(6*n+1)]
        for i in range(1, 7):
            matrix[0][i] = 1
        for i in range(2, n+1):
            line = [0] * (n*6 + 1)
            for col_index in range(i, 6*i+1):
                for ran in range(1, 7):
                    if col_index > ran:
                        line[col_index] += matrix[-1][col_index - ran]
                    else:
                        break
            matrix.append(line)
        total_count = 6 ** n
        final_line = [item for item in matrix[-1] if item != 0]
        res = [item/ total_count for item in final_line]
        return res

if __name__ == '__main__':
    so = Solution()
    res = so.dicesProbability(3)
    print(res)
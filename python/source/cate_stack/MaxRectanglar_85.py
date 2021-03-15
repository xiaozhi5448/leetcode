from typing import *
class Solution:
    # timeout
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        rowCount = len(matrix)
        colCount = len(matrix[0])
        leftCounts = [[0] * colCount for _ in range(rowCount)]
        for i in range(rowCount):
            for j in range(colCount):
                if matrix[i][j] == '0':
                    leftCounts[i][j] = 0
                else:
                    leftCounts[i][j] = 1
                    if j > 0:
                        leftCounts[i][j] += leftCounts[i][j-1]
        res = 0
        for i in range(rowCount):
            for j in range(colCount):
                width = leftCounts[i][j]
                res = max(width, res)
                for k in range(i-1, -1, -1):
                    if matrix[k][j] == 0:
                        break
                    else:
                        width = min(width, leftCounts[k][j])
                        res = max(res, width*(i-k+1))
        return res

    def maximalRectangle2(self, matrix: List[List[str]]) -> int:
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        rowCount = len(matrix)
        colCount = len(matrix[0])
        leftCounts = [[0] * colCount for _ in range(rowCount)]
        for i in range(rowCount):
            for j in range(colCount):
                if matrix[i][j] == '0':
                    leftCounts[i][j] = 0
                else:
                    leftCounts[i][j] = 1
                    if j > 0:
                        leftCounts[i][j] += leftCounts[i][j-1]
        res = 0
        for col in range(colCount):
            up = [-1] * rowCount
            stack = list()
            stack.append(-1)
            stack.append(0)
            for row in range(1,rowCount):
                while len(stack) > 1 and leftCounts[row][col] <= leftCounts[stack[-1]][col]:
                    stack.pop(-1)
                up[row] = stack[-1]
                stack.append(row)
            stack.clear()
            stack.append(rowCount)
            stack.append(rowCount-1)
            down = [rowCount] * rowCount
            for row in range(rowCount-2, -1,-1):
                if matrix[row][col] == '0':
                    down[row] = row
                while len(stack) > 1 and leftCounts[row][col] <= leftCounts[stack[-1]][col]:
                    stack.pop(-1)
                down[row] = stack[-1]
            for row in range(rowCount):
                if matrix[row][col] == '0':
                    continue
                res = max(res, leftCounts[row][col]*(down[row]-up[row]-1))
        return res

if __name__ == '__main__':
    so = Solution()
    res = so.maximalRectangle2([["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
)
    print(res)
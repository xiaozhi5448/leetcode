from typing import List
class Solution:
    """
    枚举 height ，查找左边和右边第一个比当前高度小的下标
    """
    def largestRectangleArea(self, heights: List[int]) -> int:
        leftBounds = [-1] * len(heights)
        rightBounds = [len(heights)] * len(heights)
        stack = list()
        stack.append(-1)
        stack.append(0)
        for i in range(1, len(heights)):
            while len(stack)>1 and heights[i] < heights[stack[-1]]:
                stack.pop(-1)
            if len(stack) > 1 and heights[i] == heights[stack[-1]]:
                leftBounds[i] = leftBounds[stack[-1]]
            else:
                leftBounds[i] = stack[-1]
            stack.append(i)
        stack.clear()
        stack.append(len(heights))
        stack.append(len(heights)-1)
        for i in range(len(heights)-2, -1,-1):
            while len(stack)>1 and heights[i] < heights[stack[-1]]:
                stack.pop(-1)
            if len(stack)>1 and heights[i] == heights[stack[-1]]:
                rightBounds[i] = rightBounds[stack[-1]]
            else:
                rightBounds[i] = stack[-1]
            stack.append(i)

        res = 0
        for i in range(len(heights)):
            height = heights[i]
            left = leftBounds[i]
            right = rightBounds[i]
            width = right -left - 1
            res = max(res, height*width)
        return res
if __name__ == '__main__':
    so = Solution()
    tests = [
        [2, 1, 5, 6, 2, 3],
        [1, 2, 2]
    ]
    for test in tests:
        res = so.largestRectangleArea(test)
        print(res)
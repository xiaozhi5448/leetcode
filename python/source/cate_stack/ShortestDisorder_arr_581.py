from typing import *
class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        rightSmaller = [-1] * len(nums)
        leftLarger = [-1] * len(nums)
        if len(nums) < 2:
            return len(nums)
        stack = []
        stack.append(0)
        for i in range(1, len(nums)):
            while len(stack) > 0 and nums[i] < nums[stack[-1]]:
                index = stack.pop()
                rightSmaller[index] = i
            stack.append(i)
        while stack:
            rightSmaller[stack.pop(-1)] = -1

        stack.append(len(nums) - 1)
        for i in range(len(nums) - 2, -1, -1):
            while len(stack) > 0 and nums[i] > nums[stack[-1]]:
                index = stack.pop(-1)
                leftLarger[index] = i
            stack.append(i)
        while stack:
            leftLarger[stack.pop(-1)] = -1
        leftBound = 0
        while leftBound < len(nums):
            if rightSmaller[leftBound] == -1:
                leftBound += 1
            else:
                break

        rightBound = len(nums) - 1
        while rightBound >= 0:
            if leftLarger[rightBound] == -1:
                rightBound -= 1
            else:
                break
        if rightBound >= leftBound:
            return rightBound - leftBound + 1
        return 0

if __name__ == '__main__':
    so = Solution()
    res = so.findUnsortedSubarray([2,6,4,8,10,9,15])
    print(res)
from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:

        if not nums or len(nums) == 0:
            return 0
        pivot = 0
        start = 0
        end = 0
        while end < len(nums):
            while end < len(nums) and nums[end] == nums[start]:
                end += 1
            if end - start >= 2:
                nums[pivot] = nums[start]
                nums[pivot+1] = nums[start]
                pivot += 2
                start = end
            else:
                nums[pivot] = nums[start]
                pivot += 1
                start = end
        return pivot

if __name__ == '__main__':
    solution = Solution()
    nums = [1,1,1,2,2,3]
    print(solution.removeDuplicates(nums))
    print(nums)


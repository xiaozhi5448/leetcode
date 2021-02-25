from typing import List
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        if not nums:
            return []
        nums.sort()
        count = len(nums)
        res = []
        for ptr1 in range(count-3):
            if ptr1!= 0 and nums[ptr1] == nums[ptr1-1]:
                continue
            for ptr2 in range(ptr1+1, count-2):
                if ptr2 != ptr1+1 and nums[ptr2] == nums[ptr2-1]:
                    continue
                left = ptr2+1
                right = count-1
                while left < right:
                    accu = nums[ptr1] + nums[ptr2] + nums[left] + nums[right]
                    if accu == target:
                        res.append([nums[ptr1], nums[ptr2], nums[left], nums[right]])
                        left += 1
                        while left < right and nums[left] == nums[left - 1]:
                            left += 1
                        right -= 1
                        while left < right and nums[right] == nums[right + 1]:
                            right -= 1
                    elif accu > target:
                        right -= 1
                        while left < right and nums[right] == nums[right + 1]:
                            right -= 1
                    elif accu < target:
                        left += 1
                        while left < right and nums[left] == nums[left - 1]:
                            left += 1
        return res

if __name__ == '__main__':
    nums = [1, 0, -1, 0, -2, 2]
    so = Solution()
    res = so.fourSum(nums, 0)
    print(res)
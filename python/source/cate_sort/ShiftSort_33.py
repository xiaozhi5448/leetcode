from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        length = len(nums)
        if length == 0:
            return -1
        elif length == 1:
            return 0 if nums[0] == target else -1
        left = 0
        right = length - 1
        while left <= right:
            if left == right:
                return left if nums[left] == target else -1
            mid = (left + right)//2
            if nums[mid] == target:
                return mid
            # left sorted
            if nums[left] <= nums[mid]:
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid+1
            # right sorted
            else:
                if nums[mid+1] <= target <= nums[right]:
                    left = mid+1
                else:
                    right = mid-1
        return -1

if __name__ == '__main__':
    so = Solution()
    res = so.search([1,3],3)
    print(res)
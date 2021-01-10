class Solution:
    def nextPermutation(self, nums: list) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        length = len(nums)
        if length < 2:
            return nums
        index = length -1
        while index - 1 >= 0 and nums[index] <= nums[index-1]:
            index -= 1
        if index <= 1 and nums[0] >= nums[1]:
            nums.sort()
            return
        left = index - 1
        right = -1

        for i in range( length-1, left, -1):
            if right == -1 and nums[i] > nums[left]:
                right = i
                continue
            if nums[i] > nums[left] and nums[i] - nums[left] < nums[right] - nums[left]:
                right = i
        nums[left], nums[right] = nums[right], nums[left]
        left += 1
        right = length-1
        while left < right:
            nums[left], nums[right] = nums[right], nums[left]
            left += 1
            right -= 1

if __name__ == '__main__':
    so = Solution()
    tests = [[1,2,3], [3,2,1], [1,1,5], [1], [1,3,2], [2, 3, 1, 3,3], [2,3,1]]
    so.nextPermutation([2,3,1])
    for test_nums in tests:
        print("before: {}".format(str(test_nums)))
        so.nextPermutation(test_nums)
        print("after: {}".format(str(test_nums)))


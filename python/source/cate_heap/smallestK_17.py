import heapq
class Solution:

    def smallestK(self, arr, k: int) :
        heapq.heapify(arr)
        count = min(k, len(arr))
        res = [heapq.heappop(arr) for _ in range(count)]
        return res
    def partition(self, nums, start, end):
        if start < end:
            index = start -1
            pivot = nums[end]
            for j in range(start, end):
                if nums[j] <= pivot:
                    index += 1
                    nums[index], nums[j] = nums[j], nums[index]
            nums[index+1], nums[end] = nums[end] , nums[index+1]
            return index+1
        return start
    def quicksort(self, nums, start, end):
        if start <end:
            mid = self.partition(nums, start, end)
            self.quicksort(nums, start, mid-1)
            self.quicksort(nums, mid+1, end)


    def smallestK(self, nums,k):
        if not nums:
            return []
        self.quicksort(nums, 0, len(nums)-1)
        return nums[:k]
import random
if __name__ == '__main__':
    nums = list(range(10))
    random.shuffle(nums)
    so = Solution()
    so.quicksort(nums, 0, 9)
    print(nums)
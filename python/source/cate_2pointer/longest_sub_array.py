from sortedcontainers import SortedList
class Solution:
    def longestSubarray(self, nums, limit):
        length = len(nums)
        if not length:
            return 0
        left = right = ret = 0
        container = SortedList()
        while right < length:
            container.add(nums[right])
            while container[-1] - container[0] > limit:
                container.remove(nums[left])
                left += 1
            ret = max(ret, right-left+1)
            right+=1
        return ret

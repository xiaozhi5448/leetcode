import heapq
from typing import List
class SlidingWindow(object):
    def __init__(self,k):
        self.minor = []
        self.major = []
        self.minor_size = 0
        self.major_size = 0
        self.removed = dict()
        self.window = k

    def insert(self, num:int):
        if self.minor_size == self.major_size == 0:
            heapq.heappush(self.minor, -num)
            self.minor_size += 1
        if num <= self.minor[0]:
            heapq.heappush(self.minor, -num)
            self.minor_size += 1
        else:
            heapq.heappush(self.major, num)
            self.major_size += 1
        self.makeBalance()

        pass

    def erase(self, num:int):
        if num not in self.removed:
            self.removed[num] = 1
        else:
            self.removed[num] += 1
        if  num <= -self.minor[0]:
            self.minor_size -= 1
            self.prune(self.minor)
        else:
            self.major_size -= 1
            self.prune(self.major)
        self.makeBalance()

    def prune(self, heap):
        while heap:
            num = heap[0]
            if heap is self.minor:
                num = -num
            if num in self.removed and self.removed[num] > 0:
                heapq.heappop(heap)
                self.removed[num] -= 1
            else:
                break
        pass
    def makeBalance(self):
        l1 = self.minor_size
        l2 = self.major_size
        if l1 == l2 + 2:
            num = heapq.heappop(self.minor)
            heapq.heappush(self.major, num)
            self.prune(self.minor)
        elif l1 == l2 - 1:
            num = heapq.heappop(self.major)
            heapq.heappush(self.minor, num)
            self.prune(self.major)

    def median(self):
        if self.minor_size == self.major_size:
            return (-self.minor[0] + self.major[0])/2
        else:
            return -self.minor[0]


class Solution:
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        dh = SlidingWindow(k)
        for num in nums[:k]:
            dh.insert(num)

        ans = [dh.median()]
        for i in range(k, len(nums)):
            dh.insert(nums[i])
            dh.erase(nums[i - k])
            ans.append(dh.median())

        return ans



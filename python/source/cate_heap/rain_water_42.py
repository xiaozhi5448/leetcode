from typing import List
import heapq
from collections import defaultdict
class Solution:
    def trap(self, height: List[int]) -> int:
        leftH = [-height[0]]
        rightH = [-item for item in height[2:]]
        heapq.heapify(rightH)
        rightRemoval = defaultdict(int)
        res = 0
        for i in range(1, len(height)-1):
            lh = abs(leftH[0])
            rh = abs(rightH[0])
            if height[i] < rh and height[i] < lh:
                res += min(rh, lh) - height[i]
            heapq.heappush(leftH, -height[i])
            rightRemoval[-height[i+1]] += 1
            while len(rightH) > 0 and rightH[0] in rightRemoval and rightRemoval[rightH[0]] > 0:
                rightRemoval[rightH[0]] -= 1
                heapq.heappop(rightH)
        return res

if __name__ == '__main__':
    so = Solution()
    testCases = [
        [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1],
        [4, 2, 0, 3, 2, 5]
    ]
    for test in testCases:
        print(so.trap(test))
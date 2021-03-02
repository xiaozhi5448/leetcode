from typing import List
from functools import cmp_to_key
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        length = len(intervals)
        intervals.sort(key=cmp_to_key(lambda a,b: a[0]-b[0] if a[0]!= b[0] else a[1] - b[1]))
        index = 0
        res = []

        while index < length:
            current_area = intervals[index].copy()
            index += 1
            while index < length and intervals[index][0] <= current_area[1]:
                current_area[1] = max(current_area[1], intervals[index][1])
                index+= 1
            res.append(current_area.copy())
        return res

if __name__ == '__main__':
    so = Solution()
    intervals = [[1,3],[2,6],[8,10],[15,18]]
    res = so.merge(intervals)
    print(res)




from collections import deque, defaultdict
from typing import *

class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        indig = defaultdict(int)
        edges = defaultdict(list)
        for edge in prerequisites:
            indig[edge[0]] += 1
            edges[edge[1]].append(edge[0])
        q = deque([i for i in range(numCourses) if indig[i] == 0])
        res = []
        while q:
            course = q.popleft()
            res.append(course)
            for neighbour in edges[course]:
                indig[neighbour] -= 1
                if indig[neighbour] == 0:
                    q.append(neighbour)
        if len(res) < numCourses:
            return []
        return res

if __name__ == '__main__':
    so = Solution()
    res = so.findOrder(2,[[1,0]])
    print(res)
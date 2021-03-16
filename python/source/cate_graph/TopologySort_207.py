"""
你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
    例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。

"""
from typing import List

class Solution:

    def dfs(self, visited, cur, edges):
        if visited[cur] == 0:
            visited[cur] = 1
            for node in edges[cur]:
                if visited[node] == 1:
                    self.flag = False
                else:
                    self.dfs(visited, node, edges)
            visited[cur] = 2


    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indeg = [0] * numCourses
        visited = 0
        edges = [[] for _ in range(numCourses)]
        for dep in prerequisites:
            edges[dep[1]].append(dep[0])
            indeg[dep[0]] += 1
        zeroDegs = [i for i in range(numCourses) if indeg[i] == 0]
        while zeroDegs:
            node = zeroDegs.pop(0)
            visited += 1
            for neighbour in edges[node]:
                indeg[neighbour] -= 1
                if indeg[neighbour] == 0:
                    zeroDegs.append(neighbour)
        return visited == numCourses

if __name__ == '__main__':
    so = Solution()
    print(so.canFinish(2, [[1,0], [0,1]]))
    print(so.canFinish(5, [[1,4],[2,4],[3,1],[3,2]]))
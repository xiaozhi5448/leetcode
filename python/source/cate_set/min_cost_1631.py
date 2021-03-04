from typing import List

"""
你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。
一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。
你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。

一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。

请你返回从左上角走到右下角的最小 体力消耗值 。
"""
class Node:
    def __init__(self, pos_row, pos_col, val):
        self.pos_row = pos_row
        self.pos_col = pos_col
        self.val = val
        self.parent = None

"""
使用并查集
"""

class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:

        def parent(node):
            node_ptr = node
            while node_ptr.parent != node_ptr:
                node_ptr = node_ptr.parent
            root = node_ptr
            node_ptr = node
            while node_ptr != root:
                parent = node_ptr.parent
                node_ptr.parent = root
                node_ptr = parent
            return root

        def merge(node1, node2):
            p1 = parent(node1)
            p2 = parent(node2)
            if p1 == p2:
                return False

            else:
                p1.parent = p2
                return True

        row = len(heights)
        col = len(heights[0])
        if row == col == 1:
            return 0
        nodes = []
        for row_index in range(row):
            line = []
            for col_index in range(col):
                line.append(Node(row_index, col_index, heights[row_index][col_index]))
            nodes.append(line)
        edges = []
        for row_index in range(row):
            for col_index in range(col):
                nodes[row_index][col_index].parent = nodes[row_index][col_index]
                if row_index + 1 < row:
                    edges.append((nodes[row_index][col_index], nodes[row_index + 1][col_index],
                                  abs(heights[row_index][col_index] - heights[row_index + 1][col_index])))
                if col_index + 1 < col:
                    edges.append((nodes[row_index][col_index], nodes[row_index][col_index + 1],
                                  abs(heights[row_index][col_index] - heights[row_index][col_index + 1])))
        edges.sort(key=lambda item: item[2])
        for edge in edges:
            if merge(edge[0], edge[1]):
                if parent(nodes[0][0]) == parent(nodes[row - 1][col - 1]):
                    return edge[2]

if __name__ == '__main__':
    test_cases = [
        {'heights': [[1,2,2],[3,8,2],[5,3,5]]},
        {'heights': [[1,2,3],[3,8,4],[5,3,5]]},
        {'heights': [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]}
    ]
    so = Solution()
    for test in test_cases:
        res = so.minimumEffortPath(test['heights'])
        print(res)
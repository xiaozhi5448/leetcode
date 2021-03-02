from typing import List

class Node:
    def __init__(self, pos_row, pos_col, val):
        self.pos_col = pos_col
        self.pos_row = pos_col
        self.val = val
        self.parent = None
    def __str__(self):
        this =  "({},{}): {}".format(self.pos_row, self.pos_col, self.val)
        parent = "({},{}): {}".format(self.parent.pos_row, self.parent.pos_col, self.parent.val)
        return "{} -> {}".format(this, parent)


class Solution:

    def parent(self, node):
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

    def merge(self, node1, node2):
        p1 = self.parent(node1)
        p2 = self.parent(node2)
        if p1 == p2:
            return False
        else:
            p2.parent = p1
            return True

    def swimInWater(self, grid: List[List[int]]) -> int:
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

        row_count = len(grid)
        col_count = len(grid[0])
        nodes = [[Node(row, col, grid[row][col]) for col in range(col_count)] for row in range(row_count)]
        for row in range(row_count):
            for col in range(col_count):
                nodes[row][col].parent = nodes[row][col]
        visited = [[False] * col_count for _ in range(row_count)]
        for t in range(0, int(10000)):
            for row in range(row_count):
                for col in range(col_count):
                    if not visited[row][col]:
                        if nodes[row][col].val <= t:
                            visited[row][col] = True
                        else:
                            continue
                        if row - 1 >= 0 and nodes[row - 1][col].val <= t:
                            self.merge(nodes[row][col], nodes[row - 1][col])
                        if col - 1 >= 0 and nodes[row][col - 1].val <= t:
                            self.merge(nodes[row][col], nodes[row][col - 1])
                        if row + 1 < row_count and nodes[row + 1][col].val <= t:
                            self.merge(nodes[row][col], nodes[row + 1][col])
                        if col + 1 < col_count and nodes[row][col + 1].val <= t:
                            self.merge(nodes[row][col], nodes[row][col + 1])
            p1 = self.parent(nodes[0][0])
            p2 = self.parent(nodes[-1][-1])
            if p1 == p2:
                return t
        return 10000

if __name__ == '__main__':
    so = Solution()
    grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
    res = so.swimInWater(grid)
    print(res)
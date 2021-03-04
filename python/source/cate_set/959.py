from typing import List


class Node:
    def __init__(self, val):
        self.val = val
        self.parent = None


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
            p1.parent = p2
            return True

    def merge_all(self, nodes):
        scale = len(nodes)
        for row in range(scale):
            for col in range(scale):
                if row +1 < scale:
                    self.merge(nodes[row][col][2], nodes[row+1][col][0])
                if col + 1 <scale:
                    self.merge(nodes[row][col][1], nodes[row][col+1][3])

    def regionsBySlashes(self, grid: List[str]) -> int:
        if not grid:
            return 0

        cell_dict = {i: Node(i) for i in range(4)}
        scale = len(grid)
        nodes = [[{i: Node(i) for i in range(4)} for i in range(scale)] for _ in range(scale)]
        for row in range(scale):
            for col in range(scale):
                nodes[row][col][0].parent = nodes[row][col][0]
                nodes[row][col][1].parent = nodes[row][col][1]
                nodes[row][col][2].parent = nodes[row][col][2]
                nodes[row][col][3].parent = nodes[row][col][3]
                if grid[row][col] == ' ':
                    self.merge(nodes[row][col][0], nodes[row][col][1])
                    self.merge(nodes[row][col][1], nodes[row][col][2])
                    self.merge(nodes[row][col][2], nodes[row][col][3])
                if grid[row][col] == '/':
                    self.merge(nodes[row][col][0], nodes[row][col][3])
                    self.merge(nodes[row][col][1], nodes[row][col][2])
                elif grid[row][col] == '\\':
                    self.merge(nodes[row][col][0], nodes[row][col][1])
                    self.merge(nodes[row][col][2], nodes[row][col][3])
        roots = set()
        self.merge_all( nodes)
        for row in range(scale):
            for col in range(scale):
                for i in range(4):
                    roots.add(self.parent(nodes[row][col][i]))
        return len(roots)


if __name__ == '__main__':
    grid = [" \\/ /\\/  /\\////\\////", "\\\\//\\\\/  /// \\//\\//\\", "   \\\\\\/ \\/\\//\\// /  ",
            "\\\\/\\/\\\\\\\\/\\\\/\\/// /\\", "\\\\////\\\\\\  \\// ////\\", "\\\\\\/ /\\/ /\\\\///\\/\\\\/",
            "\\/\\/ \\\\\\\\\\/\\\\// \\///", "/ /  //\\/\\\\\\ \\\\\\\\\\ \\", "\\\\\\\\\\ ///\\  ///\\\\ //",
            " \\\\ \\//\\/\\/ \\/\\/\\  /", "\\\\\\/\\\\/ \\\\ \\ \\\\ //\\ ", "/\\ //\\\\\\/ \\\\\\/ // /\\",
            "/\\\\// /\\\\\\/\\\\\\/// \\ ", "\\// / /////\\ /  \\\\\\ ", " \\\\//\\   \\\\//\\\\ \\\\ \\",
            "/\\//\\/// /\\ ///\\ \\\\\\", "\\\\\\\\\\\\/// \\ \\//\\///\\", "\\//// \\\\/\\// \\ // //",
            " /// \\ //\\///  \\\\// ", " \\\\\\\\/\\\\/\\ \\\\//\\\\///"]
    so = Solution()
    res = so.regionsBySlashes(grid)
    print(res)

class Node:
    def __init__(self, val):
        self.val = val
        self.parent = None


class Solution:
    def findRedundantConnection(self, edges):
        if not edges:
            return []
        count = len(edges)
        nodes = {val: Node(val) for val in range(1, count + 1)}
        self.res = []
        for val in nodes:
            nodes[val].parent = nodes[val]

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
            if p1 != p2:
                p2.parent = p1
            else:
                self.res.append([node1.val, node2.val])

        for edge in edges:
            merge(nodes[edge[0]], nodes[edge[1]])
        return self.res[-1]
if __name__ == '__main__':
    so = Solution()
    edges = [[1,2], [2,3], [3,4], [1,4], [1,5]]
    res = so.findRedundantConnection(edges)
    print(res)

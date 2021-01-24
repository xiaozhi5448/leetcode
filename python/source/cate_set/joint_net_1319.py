class Node:
    def __init__(self, val):
        self.val = val
        self.parent = None
    def __str__(self):
        return "node({}); parent: {}".format(self.val, self.parent.val if self.parent else "None")
class Solution:
    def makeConnected(self, n: int, connections) -> int:
        if len(connections) < n - 1:
            return -1

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

        nodes = {i: Node(i) for i in range(n)}
        for key in nodes:
            nodes[key].parent = nodes[key]
        for edge in connections:
            merge(nodes[edge[0]], nodes[edge[1]])
        roots = set()
        for key in nodes:
            root = parent(nodes[key])
            roots.add(root)
        count = len(roots)
        return count - 1

if __name__ == '__main__':
    so = Solution()
    edges = [[0,1],[0,2],[1,2]]
    res = so.makeConnected(4, edges)
    print(res)
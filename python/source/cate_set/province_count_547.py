class Node:
    def __init__(self, val:int, parent):
        self.val = val
        self.parent = parent
        self.factor = 1
    def __str__(self):
        return "self: {}, parent: {}".format(self.val, self.parent.val if self.parent else None)

class UnionFindSet(object):
    def __init__(self, size):
        self.nodes = [Node(i, None) for i in range(size)]
        for node in self.nodes:
            node.parent = node
        self.size = size

    def parent(self, node:Node):
        # 找到根节点
        node_ptr = node
        while node_ptr.parent != node_ptr:
            node_ptr = node_ptr.parent
        root = node_ptr
        # 路径压缩
        node_ptr = node
        while node_ptr != root:
            parent = node_ptr.parent
            node_ptr.parent = root
            node_ptr = parent
        return root

    def merge(self, node1, node2):
        p1 = self.parent(node1)
        p2 = self.parent(node2)
        p2.parent = p1

    def build(self, isConnected):
        if not isConnected:
            return
        for row in range(self.size):
            for col in range(row+1, self.size):
                if isConnected[row][col] == 0:
                    continue
                self.merge(self.nodes[row], self.nodes[col])

    def count(self):
        return len(set([self.parent(node) for node in self.nodes]))




class Solution:
    def findCircleNum(self, isConnected) -> int:
        if not isConnected:
            return 0
        unionSet = UnionFindSet(len(isConnected))
        unionSet.build(isConnected)
        return unionSet.count()


if __name__ == '__main__':
    so = Solution()
    isConnected = [[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
    res = so.findCircleNum(isConnected)
    print(res)


class Node(object):
    def __init__(self, val, parent, factor):
        self.val = val
        self.parent = parent
        self.factor = factor

class UnionSet(object):
    def __init__(self):
        self.nodes = []


class Solution:
    def calcEquation(self, equations, values, queries):
        def parent(node:Node):
            factor = 1
            node_ptr = node
            while node_ptr.parent != node_ptr:
                factor *= node_ptr.factor
                node_ptr = node_ptr.parent
            node.parent = node_ptr
            node.factor = factor
            return node_ptr, factor
        nodes = {}
        symbols = set()
        for equation in equations:
            for sym in equation:
                if sym not in symbols:
                    nodes[sym] = Node(sym, None, 1.0)
                    nodes[sym].parent = nodes[sym]
                    symbols.add(sym)

        for index, equation in enumerate(equations):
            s1 = equation[0]
            s2 = equation[1]
            node1 = nodes[s1]
            node2 = nodes[s2]
            p1, f1 = parent(node1)
            # p2, f2 = parent(node2)
            p1.parent = node2
            p1.factor = 1.0 /  (values[index]*f1)
        res = []
        for query in queries:
            s1 = query[0]
            s2 = query[1]
            if s1 not in symbols or s2 not in symbols:
                res.append(-1.0)
                continue
            node1 = nodes[s1]
            node2 = nodes[s2]
            p1, f1 = parent(node1)
            p2, f2 = parent(node2)
            if p1 != p2:
                res.append(-1.0)
            else:
                res.append(f2/f1)
        return res






if __name__ == '__main__':
    equations = [["x1", "x2"], ["x2", "x3"], ["x3", "x4"], ["x4", "x5"]]
    values = [3.0, 4.0, 5.0, 6.0]
    querys = [["x1", "x5"], ["x5", "x2"], ["x2", "x4"], ["x2", "x2"], ["x2", "x9"], ["x9", "x9"]]
    so = Solution()
    res = so.calcEquation(equations, values, querys)
    print(res)
    equations = [["a","b"],["b","c"],["bc","cd"]]
    values = [1.5,2.5,5.0]
    querys = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
    res = so.calcEquation(equations, values, querys)
    print(res)


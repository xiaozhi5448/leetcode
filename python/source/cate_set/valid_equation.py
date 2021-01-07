class Node(object):
    def __init__(self, val):
        self.val  = val
        self.parent = None

class Solution:

    def equationsPossible(self, equations):
        def parent(node):
            node_ptr = node
            while node_ptr != node_ptr.parent:
                node_ptr = node_ptr.parent
            root = node_ptr
            node_ptr = node
            while node_ptr.parent != root:
                parent = node_ptr.parent
                node_ptr.parent = root
                node_ptr = parent
            return root

        def merge(node1, node2):
            p1 = parent(node1)
            p2 = parent(node2)
            p1.parent = p2
        def parse_equation(equation):
            spliter = '==' if '==' in equation else '!='
            items = equation.split(spliter)
            return items[0],items[1], spliter
        equation_items = [parse_equation(equation) for equation in equations]
        nodes = dict()
        for equation in equation_items:
            s1 = equation[0]
            s2 = equation[1]
            if s1 not in nodes or s2 not in nodes:
                if s1 not in nodes:
                    nodes[s1] = Node(s1)
                    nodes[s1].parent = nodes[s1]
                if s2 not in nodes:
                    nodes[s2] = Node(s2)
                    nodes[s2].parent = nodes[s2]
                if equation[2] == '==':
                    merge(nodes[s1], nodes[s2])
            p1 = parent(nodes[s1])
            p2 = parent(nodes[s2])
            if equation[2] == '==':
                if p1 != p2:
                    return False
            else:
                if p1 == p2:
                    return False
        return True

if __name__ == '__main__':
    so = Solution()
    equations = ["c==c","f!=a","f==b","b==c"]
    res = so.equationsPossible(equations)
    print(res)


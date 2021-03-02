class Node(object):
    def __init__(self, val):
        self.val = val
        self.parent = None


class Coordinate(object):
    def __init__(self, pos_x, pos_y):
        self.x = pos_x
        self.y = pos_y
        self.parent = None

    def distance(self, coor):
        return abs(self.x - coor.x) + abs(self.y - coor.y)

class Edge(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
        self.distance = self.start.distance(self.end)

class DisJointUnionSet(object):
    def __init__(self):
        self.nodes = []
        self.roots = set()

    def add_node(self, node):
        self.nodes.append(node)
        self.roots.add(node)

    def parent(self, node):
        node_ptr = node
        while node_ptr and node_ptr != node_ptr.parent:
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
            if p1 in self.roots:
                self.roots.remove(p1)
            return True



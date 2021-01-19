class Node:
    def __init__(self, pos_x, pos_y):
        self.x = pos_x
        self.y = pos_y
        self.parent = None

    def distance(self, node):
        return abs(self.x - node.x) + abs(self.y - node.y)

    def __str__(self):
        return "({},{})".format(self.x, self.y)


class Solution:
    def minCostConnectPoints(self, points) -> int:
        if not points:
            return 0
        if len(points) < 2:
            return 0
        def parent(node):
            node_ptr = node
            while node_ptr != node_ptr.parent:
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
            p1.parent = p2
            return True

        nodes = [Node(item[0], item[1]) for item in points]
        for node in nodes:
            node.parent = node
        edges = []
        for start_index in range(0, len(points) - 1):
            for end_index in range(start_index + 1, len(points)):
                edges.append({
                    'start': nodes[start_index],
                    'end': nodes[end_index],
                    'distance': nodes[start_index].distance(nodes[end_index])
                })
        edges.sort(key=lambda item: item['distance'])
        res = 0
        for edge in edges:
            if merge(edge['start'], edge['end']):
                res += edge['distance']

        return res

if __name__ == '__main__':
    points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
    so = Solution()
    res = so.minCostConnectPoints(points)
    print(res)
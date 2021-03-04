from typing import List
class Solution:
    def maxNumEdgesToRemove(self, n: int, edges: List[List[int]]) -> int:
        nodes = list(range(n+1))

        def parent(node, nodes):
            node_ptr = node
            while nodes[node_ptr] != node_ptr:
                node_ptr = nodes[node_ptr]
            root = node_ptr
            node_ptr = node
            while node_ptr != root:
                parent = nodes[node_ptr]
                nodes[node_ptr] = root
                node_ptr = parent
            return root

        def merge(node1, node2, nodes):
            p1 = parent(node1, nodes)
            p2 = parent(node2, nodes)
            if p1 == p2:
                return False
            else:
                nodes[p2] = p1
                return True

        res = 0
        common_edges = [edge for edge in edges if edge[0] == 3]
        for edge in common_edges:
            if not merge(edge[1], edge[2], nodes):
                res += 1
        alice_edges = [edge for edge in edges if edge[0] == 1]
        bob_edges = [edge for edge in edges if edge[0] == 2]
        alice_graph = nodes.copy()
        bob_graph = nodes

        for edge in alice_edges:
            if not merge(edge[1], edge[2], alice_graph):
                res += 1
        for edge in bob_edges:
            if not merge(edge[1], edge[2], bob_graph):
                res += 1
        roots_count = sum([1 for index, item in enumerate(alice_graph) if index == item])-1
        if roots_count != 1:
            return -1
        roots_count = sum([1 for index, item in enumerate(bob_graph) if index == item])-1
        if roots_count != 1:
            return -1
        return res

if __name__ == '__main__':
    tests = [{
        'edges':  [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]],
        'n': 4
    },{
        'edges': [[3,1,2], [3,3,4], [1,1,3],[2,2,4]],
        'n' : 4

    }]
    so = Solution()
    res = so.maxNumEdgesToRemove(tests[1]['n'],tests[1]['edges'])
    print(res)

class Node(object):
    def __init__(self, val):
        self.val = val
        self.parent = None

class Solution:
    def smallestStringWithSwaps(self, s: str, pairs) -> str:
        bounds = set()
        for pair in pairs:
            bounds.add(pair[0])
            bounds.add(pair[1])
        nodes = {val:Node(val) for val in bounds}
        for val in nodes:
            nodes[val].parent = nodes[val]
        def parent(node:Node):
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
        def merge(node1:Node, node2:Node):
            p1 = parent(node1)
            p2 = parent(node2)
            p1.parent = p2
        for pair in pairs:
            merge(nodes[pair[0]], nodes[pair[1]])
        roots = {}
        for val in nodes:
            p = parent(nodes[val])
            if p.val not in roots:
                roots[p.val] = set()
            roots[p.val].add(nodes[val].val)
        chs = list(s)
        for key in roots:
            indexs = list(roots[key])
            indexs.sort()
            loop_chs = [chs[index] for index in indexs]
            loop_chs.sort()
            for i in range(len(loop_chs)):
                chs[indexs[i]] = loop_chs[i]
            # for left in range(len(indexs)):
            #     for right in range(left+1, len(indexs)):
            #         if chs[indexs[left]] > chs[indexs[right]]:
            #             chs[indexs[left]], chs[indexs[right]] = chs[indexs[right]], chs[indexs[left]]
        return "".join(chs)

if __name__ == '__main__':
    so = Solution()
    tests = [{'s': "dcab", 'pairs': [[0,3],[1,2]]},{'s': "dcab", 'pairs': [[0,3],[1,2],[0,2]]}]
    for test in tests:
        res = so.smallestStringWithSwaps(test['s'], test['pairs'])
        print(res)





from typing import List
class Solution:
    def numSimilarGroups(self, strs: List[str]) -> int:
        def same_chs(msg1, msg2):
            ch1 = list(msg1)
            ch1.sort()
            ch2 = list(msg2)
            ch2.sort()
            if "".join(ch1) == "".join(ch2):
                return True
            return False

        def parent(x, p):
            node_ptr = x
            while p[node_ptr] != node_ptr:
                node_ptr = p[node_ptr]
            root = node_ptr
            node_ptr = x
            while p[node_ptr] != root:
                parent = p[node_ptr]
                p[node_ptr] = root
                node_ptr = parent
            return root

        def merge(node1, node2, p):
            p1 = parent(node1, p)
            p2 = parent(node2, p)
            if p1 == p2:
                return False
            else:
                p[p2] = p1

        count = len(strs)
        nodes = list(range(count))
        for i in range(count - 1):
            for j in range(i + 1, count):
                if not same_chs(strs[i], strs[j]):
                    continue
                diff_count = 0
                for index in range(len(strs[i])):
                    if strs[i][index] != strs[j][index]:
                        diff_count += 1
                if diff_count <= 2:
                    merge(i, j, nodes)

        res = sum([1 for node,index in enumerate(nodes) if node == index])
        return res

if __name__ == '__main__':
    strs = ["tars","rats","arts","star"]
    so = Solution()
    res = so.numSimilarGroups(strs)
    print(res)
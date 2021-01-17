# Definition for a binary tree node.
from cate_bst.TreeNode import TreeNode
from cate_bst.build import Solution as BuildUtil
class Solution:
    def find(self, root, val, path):
        if not root:
            return None
        path.append(root)
        if root.val == val:
            # self.path = path.copy()
            return path
        left_res = self.find(root.left, val, path)
        right_res = self.find(root.right, val, path)
        if left_res != None:
            return left_res
        if right_res != None:
            return right_res
        path.pop(-1)
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        p_path = []
        if not root:
            return None
        p_path = self.find(root, p, p_path)
        q_path = self.find(root, q, [])
        if not p_path or not q_path:
            return None
        min_len = min(len(q_path), len(p_path))
        i = 0
        while i < min_len:
            if p_path[i].val == q_path[i].val:
                i+=1
                continue
            else:
                return q_path[i-1]
        return p_path[i-1]

if __name__ == '__main__':
    nums = [3,5,1,6,2,0,8,None,None,7,4]
    util = BuildUtil()
    root = util.build_from_array(nums)
    so = Solution()
    res = so.lowestCommonAncestor(root, 5, 1)
    print(res)

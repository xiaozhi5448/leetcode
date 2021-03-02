from cate_bst.build import  Solution as BuildUtil
from cate_bst.TreeNode import TreeNode

class Solution:
    def find(self, root, val, res):
        if not root:
            return
        res.append(root)
        if root.val == val:

            return
        elif val < root.val and root.left:
            self.find(root.left, val, res)
        elif val > root.val and root.right:
            self.find(root.right, val, res)
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        p_path = []
        self.find(root, p, p_path)
        q_path = []
        self.find(root, q, q_path)
        mini_len = min(len(p_path), len(q_path))
        i = 0
        while i < mini_len:
            if p_path[i].val == q_path[i].val:
                i += 1
                continue
            else:
                return p_path[i-1]
        return p_path[i-1]
if __name__ == '__main__':
    util = BuildUtil()
    root = util.build_from_array([6,2,8,0,4,7,9,None,None,3,5])
    print(root)
    so = Solution()
    res = so.lowestCommonAncestor(root, 2, 4)
    print(res)
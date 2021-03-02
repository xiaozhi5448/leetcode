# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from cate_bst.TreeNode import TreeNode
from cate_bst.build import Solution as BuildUtil
class Solution:
    def find(self, root, val):
        if not root:
            return None
        if root.val == val:
            self.find_res.append(root)
        self.find(root.left,val)
        self.find(root.right,val)

    def recur(self, A, B):
        if A == B == None:
            return True
        elif not A and  B:
            return False
        elif A and not B:
            return True
        if A.val == B.val:
            return self.recur(A.left, B.left) and self.recur(A.right, B.right)
        return False

    def isSubStructure(self, A: TreeNode, B: TreeNode) -> bool:
        self.find_res = []
        if not B:
            return False
        self.find(A, B.val)
        for node in self.find_res:
            if self.recur(node, B):
                return True
        return False

if __name__ == '__main__':
    util = BuildUtil()
    treeA = util.build_from_array([4,2,3,4,5,6,7,8,9])
    treeB = util.build_from_array([4,8,9])
    so = Solution()
    res = so.isSubStructure(treeA, treeB)
    print(res)
from cate_bst.TreeNode import TreeNode
from typing import List
class Solution:
    def buildRecursion(self, preorder, pre_start, pre_end, inorder, in_start, in_end):
        if pre_start == pre_end and pre_start < len(preorder):
            return TreeNode(preorder[pre_start])
        if pre_start > pre_end:
            return None
        root = TreeNode(preorder[pre_start])
        root_index = inorder.index(preorder[pre_start])
        left_length = root_index - in_start
        right_length = in_end - root_index
        root.left = self.buildRecursion(preorder, pre_start+1, pre_start+left_length, inorder, in_start, root_index-1)
        root.right = self.buildRecursion(preorder, pre_start+left_length+1, pre_end, inorder, root_index+1, in_end)
        return root
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder:
            return None
        root = self.buildRecursion(preorder, 0, len(preorder)-1, inorder, 0, len(inorder)-1)
        return root

if __name__ == '__main__':
    preorder = [3,9,20,15,7]
    inorder = [9,3,15,20,7]
    so = Solution()
    root = so.buildTree(preorder, inorder)

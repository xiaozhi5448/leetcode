# Definition for a binary tree node.
from cate_bst.TreeNode import  TreeNode

class Solution:
    def build_from_sorted(self, nums, start, end):
        root = None
        if start == end-1:
            if nums[start] is not None:
                root = TreeNode(nums[start])
            else:
                root = None
        elif start < end-1:
            mid = (end-start)//2 + start
            root = TreeNode(nums[mid])
            root.left = self.build(nums, start, mid)
            root.right = self.build(nums, mid+1, end)
        return root

    def build_from_array(self, nums):
        length = len(nums)
        nodes = []
        for i in range(length):
            nodes.append(TreeNode(nums[i]) if nums[i] is not None else None)
        for i in range(length//2):
            if nodes[i]:
                if 2*i+1 < length:
                    nodes[i].left = nodes[i*2+1]
                if 2*i + 2 < length:
                    nodes[i].right = nodes[i*2+2]
        if nodes:
            return nodes[0]
        return None
    def sortedArrayToBST(self, nums) -> TreeNode:
        root = self.build_from_sorted(nums, 0, len(nums))
        return root

if __name__ == '__main__':
    so = Solution()
    nums = [-10,-3,0,5,9]
    root = so.sortedArrayToBST(nums)
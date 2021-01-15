# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def build(self, nums, start, end):
        root = None
        if start == end-1:
            root = TreeNode(nums[start])
        elif start < end-1:
            mid = (end-start)//2 + start
            root = TreeNode(nums[mid])
            root.left = self.build(nums, start, mid)
            root.right = self.build(nums, mid+1, end)
        return root
    def sortedArrayToBST(self, nums) -> TreeNode:
        root = self.build(nums, 0, len(nums))
        return root

if __name__ == '__main__':
    so = Solution()
    nums = [-10,-3,0,5,9]
    root = so.sortedArrayToBST(nums)
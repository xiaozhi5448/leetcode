from cate_bst.TreeNode import TreeNode
from collections import defaultdict


class Solution:
    def dfs(self, root, pre_sum, target, pre_sum_dict):
        if root is None:
            return 0
        pre_sum += root.val
        res = pre_sum_dict[pre_sum - target]
        pre_sum_dict[pre_sum] += 1
        res += self.dfs(root.left, pre_sum, target, pre_sum_dict)
        res += self.dfs(root.right, pre_sum, target, pre_sum_dict)
        pre_sum_dict[pre_sum] -= 1
        return res

    def pathSum(self, root: TreeNode, target: int) -> int:
        num_counts = defaultdict(int)
        num_counts[0] = 1
        count = self.dfs(root, 0, target, num_counts)
        return count

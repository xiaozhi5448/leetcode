from cate_bst.TreeNode import  TreeNode
from collections import defaultdict

from collections import defaultdict
class Solution:
    def dfs(self, root, preSum, target, preSumDict):
        if root is None:
            return 0
        preSum += root.val
        res = preSumDict[preSum-target]
        preSumDict[preSum] += 1
        res += self.dfs(root.left, preSum, target, preSumDict)
        res += self.dfs(root.right, preSum, target, preSumDict)
        preSumDict[preSum] -= 1
        return res

    def pathSum(self, root: TreeNode, target: int) -> int:
        numCounts = defaultdict(int)
        numCounts[0] = 1
        count = self.dfs(root, 0, target, numCounts)
        return count

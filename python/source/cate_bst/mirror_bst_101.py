class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def recursionUtil(self, t1, t2):
        if t1 == t2 and t1 == None:
            return True
        elif t1 == None or t2 == None:
            return False
        else:
            if t1.val == t2.val:
                return self.recursionUtil(t1.left, t2.right) and self.recursionUtil(t1.right, t2.left)
            else:
                return False
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None:
            return True
        else:
            return self.recursionUtil(root.left, root.right)

    def solution2(self, root):
        nodes = list()
        if not root:
            return True
        nodes.append(root)
        nodes.append(root)
        while nodes:
            node1 = nodes.pop(0)
            node2 = nodes.pop(0)
            if node1 == None and node2 == None:
                continue
            elif node1 == None or node2 == None:
                return False
            else:
                if node1.val == node2.val:
                    nodes.append(node1.left)
                    nodes.append(node2.right)
                    nodes.append(node1.right)
                    nodes.append(node2.left)
                else:
                    return False
        return True
"""
# Definition for a Node.
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def merge(self, node1, node2):
        if node1 and node2:
            t1 = node1.left
            h1 = node1
            h2 = node2
            t2 = node2.left
            t1.right = h2
            h2.left = t1
            t2.right = h1
            h1.left = t2
            return h1
        else:
            return node1 if node1 else node2
    def treeToDoublyList(self, root):
        if not root:
            return None
        elif root.left == None and root.right == None:
            root.left = root
            root.right = root
            return root
        left = self.treeToDoublyList(root.left)
        right = self.treeToDoublyList(root.right)
        root.left = root
        root.right = root
        h1 = self.merge(left, root)
        h2 = self.merge(h1, right)
        return h2


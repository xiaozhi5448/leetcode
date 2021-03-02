class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __str__(self):
        return "TreeNode({}), left:{}, right:{}".format(self.val, self.left.val if self.left else 'None',
                                                        self.right.val if self.right else 'None')

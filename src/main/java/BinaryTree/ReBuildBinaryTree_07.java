package BinaryTree;

public class ReBuildBinaryTree_07 {
    private int findIndex(int[] nums, int num, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] == num) {
                return i;
            }
        }
        return -1;
    }

    private TreeNode buildTreeRecursionUtil(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end) {
        if (pre_start >= preorder.length || in_start >= inorder.length) {
            return null;
        } else if (pre_end - pre_start <= 1) {
            return new TreeNode(preorder[pre_start]);
        } else {
            TreeNode parent = new TreeNode(preorder[pre_start]);
            int parent_index = findIndex(inorder, preorder[pre_start], in_start, in_end);
            int left_len = parent_index - in_start;
            int right_len = in_end - parent_index - 1;
            if (left_len != 0)
                parent.left = buildTreeRecursionUtil(preorder, pre_start + 1, pre_start + left_len + 1,
                        inorder, in_start, in_start + left_len);
            if (right_len != 0)
                parent.right = buildTreeRecursionUtil(preorder, pre_start + left_len + 1, pre_end,
                        inorder, parent_index + 1, parent_index + right_len + 1);
            return parent;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = buildTreeRecursionUtil(preorder, 0, preorder.length,
                inorder, 0, inorder.length);
        return root;
    }
}

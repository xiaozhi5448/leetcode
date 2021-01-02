package simple;

public class MaxDeepth {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int left_height = 1 + maxDepth(root.left);
        int right_height = 1 + maxDepth(root.right);
        return left_height > right_height? left_height:right_height;

    }
}

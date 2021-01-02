package BinaryTree;

public class MinSubstract_783 {
    int min_sub = Integer.MAX_VALUE;
    int prev_val = -100000;
    private void recursionUtil(TreeNode root){
        if(root == null){
            return;
        }
        recursionUtil(root.left);
        min_sub = Math.min(min_sub, root.val - prev_val);
        prev_val = root.val;
        recursionUtil(root.right);
    }
    public int minDiffInBST(TreeNode root) {
        recursionUtil(root);
        return min_sub;
    }
}

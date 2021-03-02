package BinaryTree;

/**
 * 二叉树的最大路径和
 */
public class MaxSumPath_124 {
    private int sum = Integer.MIN_VALUE;
    private int maxGain(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int leftGain = Math.max(this.maxGain(root.left),0);
            int rightGain = Math.max( this.maxGain(root.right),0);
            sum = Math.max(sum, leftGain + rightGain + root.val);
            return root.val + Math.max(leftGain, rightGain);
        }
    }
    public int maxPathSum(TreeNode root) {
        this.sum = Integer.MIN_VALUE;
        this.maxGain(root);
        return this.sum;
    }
}

package BinaryTree;

/**
 * 平衡二叉树的判断，后序遍历，将子树高度保存下来返回
 */

public class BalanceBST_110 {
    private int balanceRecursionUtil(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int height_left = balanceRecursionUtil(root.left);
            int height_right = balanceRecursionUtil(root.right);
            if(height_left == -1 || height_right==-1){
                return -1;
            }else if(Math.abs(height_left - height_right) > 1){
                return -1;
            }else{
                return Math.max(height_left, height_right) + 1;
            }
        }
    }
    public boolean isBalanced(TreeNode root) {
        int height = balanceRecursionUtil(root);
        if(height == -1){
            return false;
        }

        return true;
    }

}

package BinaryTree;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class MirrorBinaryTree_101 {
    private boolean recursionUtil(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == node1){
            return true;
        }
        if((node1 == null || node2 == null) && node1 != node2){
            return false;
        }
        if(node1.val != node2.val){
            return false;
        }
        return recursionUtil(node1.left, node2.right) && recursionUtil(node1.right, node2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return recursionUtil(root.left, root.right);
    }
}

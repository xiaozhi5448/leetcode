package BinaryTree;

public class SumRange_938 {
    int res = 0;
    int low;
    int high;
    private void rangeSumBSTUtil(TreeNode node){
        if(node == null){
            return;
        }
        if(node.val <= high && node.val >= low){
            res += node.val;
        }
        rangeSumBSTUtil(node.left);
        rangeSumBSTUtil(node.right);

    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        rangeSumBSTUtil(root);
        return res;
    }
}

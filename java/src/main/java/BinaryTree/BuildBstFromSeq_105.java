package BinaryTree;

/**
 * 从先序遍历与中序遍历序列中重建二叉树
 */

public class BuildBstFromSeq_105 {
    private int find(int[] nums, int start, int end, int key){
        for(int i = start; i < end+1 && i < nums.length; i++){
            if(nums[i] == key){
                return i;
            }
        }
        return -1;
    }
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                               int[] inorder, int inStart, int inEnd){
        if(preStart == preEnd){
            return new TreeNode(preorder[preStart]);
        }else if(preStart > preEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = find(inorder, inStart, inEnd+1, root.val);
        int leftLen = rootIndex - inStart;
        root.left = buildTree(preorder, preStart+1, preStart+leftLen,
                inorder, inStart, rootIndex-1);
        root.right = buildTree(preorder, preStart+leftLen+1, preEnd,
                inorder, rootIndex+1, inEnd);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = buildTree(preorder, 0, preorder.length-1,
                inorder, 0, inorder.length-1);
        return root;
    }
}

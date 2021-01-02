package BinaryTree;

import junit.framework.TestCase;

public class ReBuildBinaryTree07Test extends TestCase {

    public void testBuildTree() {
        ReBuildBinaryTree_07 obj = new ReBuildBinaryTree_07();
        int[] preorder = {3,9, 20, 15, 7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = obj.buildTree(preorder, inorder);
        preorder = new int[]{1,2};
        inorder = new int[]{1,2};
        root = obj.buildTree(preorder, inorder);
    }
}
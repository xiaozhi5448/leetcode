package BinaryTree;

import junit.framework.TestCase;

import java.util.List;

public class Traversal_level_103Test extends TestCase {

    public void testZigzagLevelOrder() {
        Traversal_level_103 obj = new Traversal_level_103();
        Integer[] nums = new Integer[]{3,9,20,Integer.MAX_VALUE, Integer.MAX_VALUE, 15,7};
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = tree.buildTreeFromArray(nums);
        List<List<Integer>> res = obj.zigzagLevelOrder2(root);
        System.out.println(res);
    }
}
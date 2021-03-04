package BinaryTree;

import java.util.LinkedList;

public class BinarySearchTree {
    TreeNode root = null;


    TreeNode buildTreeFromArray(Integer[] nums) {
        if (nums.length < 1) {
            return null;
        }
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MAX_VALUE) {
                nodes.add(null);
            } else
                nodes.add(new TreeNode(nums[i]));
        }
        TreeNode node;
        for (int i = 0; i <= nums.length / 2; i++) {
            node = nodes.get(i);
            if (2 * i + 1 < nums.length)
                node.left = nodes.get(2 * i + 1);
            if (2 * i + 2 < nums.length)
                node.right = nodes.get(2 * i + 2);
        }
        return nodes.get(0);
    }
}

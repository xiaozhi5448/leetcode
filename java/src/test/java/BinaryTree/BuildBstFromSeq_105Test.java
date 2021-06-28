package BinaryTree;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BuildBstFromSeq_105Test {

    @Test
    public void buildTree() {
        BuildBstFromSeq_105 buildUtil = new BuildBstFromSeq_105();
        Traversal traversalUtil = new Traversal();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root = buildUtil.buildTree(preorder, inorder);
        traversalUtil.clear();
        List<Integer> res = traversalUtil.inorderLoop(root);
        System.out.println(res.toString());
    }

    @Test
    public void testArray(){
        int[] nums = new int[]{9,3,15,20,7};
        System.out.println(Arrays.binarySearch(nums, 0, nums.length, 3));
    }
}
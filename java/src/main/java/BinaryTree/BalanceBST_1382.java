package BinaryTree;

import java.util.LinkedList;

public class BalanceBST_1382 {
    LinkedList<Integer> nums = new LinkedList<>();
    public void traversalInorder(TreeNode root){
        if(root == null)
            return;
        traversalInorder(root.left);
        nums.add(root.val);
        traversalInorder(root.right);
    }
    public TreeNode BuildBST(int start, int end){
        if(start == end){
            return null;
        }else if(end - 1 == start){
            return new TreeNode(nums.get(start));
        }
        int mid = (end-start)/2+start;
        TreeNode node = new TreeNode(nums.get(mid));
        node.left = BuildBST(start, mid);
        node.right = BuildBST(mid+1, end);
        return node;
    }
    public TreeNode balanceBST(TreeNode root) {
        nums.clear();
        traversalInorder(root);
        TreeNode node = BuildBST(0, nums.size());
        return node;

    }
}

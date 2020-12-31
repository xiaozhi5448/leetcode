package BinaryTree;

public class BuildBalanceBSTFromSortedArray_108 {
    private TreeNode BuildTree(int[] nums, int start, int end){
        if(start < nums.length && start == end-1){
            return new TreeNode(nums[start]);
        }else if(start >= nums.length || start == end){
            return null;
        }
        int mid = (end-start) /2 + start;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = BuildTree(nums, start, mid);
        node.right = BuildTree(nums, mid+1, end);
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {

        TreeNode root = BuildTree(nums, 0, nums.length);
        return root;
    }
}

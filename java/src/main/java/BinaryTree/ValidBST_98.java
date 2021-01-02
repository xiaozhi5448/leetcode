package BinaryTree;

import java.util.LinkedList;

public class ValidBST_98 {
    boolean res = true;
    LinkedList<Integer> elements = new LinkedList<>();
    private void traversal(TreeNode root){
        if(root == null){
            return;
        }
        traversal(root.left);
        elements.add(root.val);
        traversal(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        traversal(root);
        for(int i = 1; i< elements.size();i++){
            if(elements.get(i) <= elements.get(i-1)){
                return false;
            }
        }
        return true;
    }
}

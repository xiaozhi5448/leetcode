package BinaryTree;

import com.sun.source.tree.Tree;
import lombok.Data;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class Bst2Blist_offer_36 {

    private TreeNode merge(TreeNode l1, TreeNode l2){
        if(l1 != null && l2 != null){
            TreeNode h1 = l1;
            TreeNode t1 = l1.left;
            TreeNode h2 = l2;
            TreeNode t2 = l2.left;
            h1.left = t2;
            t1.right = h2;
            h2.left = t1;
            t2.right = h1;
            return h1;
        }else if(l1 == null && l2 == null){
            return null;
        }else{
            return l1==null?l2:l1;
        }
    }

    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null){
            return null;
        }
        else{
            TreeNode l = treeToDoublyList(root.left);
            TreeNode r = treeToDoublyList(root.right);
            root.left = root;
            root.right = root;
            l = merge(l, root);
            l = merge(l, r);
            return l;
        }
    }


}
@Data
class Node{
    int val;
    Node left;
    Node right;
}

class Solution {
    Node head, prev;
    private void dfs(Node root){
        if(root == null)
            return;
        if(root.left != null)
            dfs(root.left);
        if(head == null && prev == null){
            head = root;prev = root;
        }else{
            prev.right = root;
            root.left = prev;
            prev = root;
        }

        if(root.right != null)
            dfs(root.right);
    }
    public Node treeToDoublyList(Node root){
        if(root==null){
            return null;
        }
        dfs(root);
        head.left = prev;
        prev.right = head;
        return head;
    }
}


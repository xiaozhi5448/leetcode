package BinaryTree;

import ch.qos.logback.core.pattern.color.WhiteCompositeConverter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

class Pair{
    TreeNode node;
    int type;
    public Pair(TreeNode n,int t){
        node = n;
        type = t;
    }
}

public class TreeToList_17 {
    final static int GRAY = 1;
    final static int WHITE = 0;
    LinkedList<TreeNode> nodes = new LinkedList<>();
    private void traversalInorder(TreeNode root){
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, WHITE));
        while(!stack.isEmpty()){

            Pair pair = stack.pop();
            if(pair.node == null){
                continue;
            }
            if(pair.type == WHITE){
                stack.push(new Pair(pair.node.right, WHITE));
                pair.type = GRAY;
                stack.push(pair);
                stack.push(new Pair(pair.node.left, WHITE));
            }else{
                pair.node.left = null;
                pair.node.right = null;
                nodes.add(pair.node);
            }
        }
    }
    public void traversalInorderRecursion(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode left = root.left, right = root.right;
        traversalInorderRecursion(left);
        root.left = null;root.right = null;
        nodes.add(root);
        traversalInorderRecursion(right);
    }
    public TreeNode convertBiNode(TreeNode root) {
        nodes.clear();
        if(root == null){
            return null;
        }
        traversalInorderRecursion(root);
        for(int i = 0; i< nodes.size() -1;i++){
            TreeNode node = nodes.get(i);
            node.left = null;

            node.right = nodes.get(i+1);
            node.right.right = null;
        }

        return nodes.get(0);
    }
    TreeNode header = new TreeNode(-1);
    TreeNode prev;
    public TreeNode convertBiNode2(TreeNode root) {
        traversalUtil(root);
        return header.right;

    }
    private void traversalUtil(TreeNode root){
        if(root == null) return;
        traversalUtil(root.left);
        if(prev == null){
            header.right = root;
            prev = root;
        }else{
            prev.right = root;
            prev = root;
        }
        root.left = null;
        traversalUtil(root.right);
    }
}

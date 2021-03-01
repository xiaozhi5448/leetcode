package BinaryTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class CommonAncestor_68 {

    void findPath(TreeNode node, TreeNode target, List<TreeNode> path, List<TreeNode> res){
        if(node == null){
            return;
        }
        path.add(node);
        if(node == target) {
            for(TreeNode n: path){
                res.add(n);
            }
        }
        findPath(node.right, target, path, res);
        findPath(node.left, target, path, res);
        path.remove(path.size()-1);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathp = new LinkedList<>();
        List<TreeNode> pathq = new LinkedList<>();
        findPath(root, p, new LinkedList<>(), pathp);
        findPath(root, q, new LinkedList<>(), pathq);
        int minLen = Math.min(pathp.size(), pathq.size());
        int index = 0;
        while(index < minLen){
            if(pathq.get(index) == pathp.get(index)){
                index++;
            }else{
                break;
            }
        }
        return pathp.get(index);
    }
}

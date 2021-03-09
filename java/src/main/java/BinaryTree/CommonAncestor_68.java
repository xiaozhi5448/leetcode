package BinaryTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class CommonAncestor_68 {
    //找到两条路径，再寻找公共祖先
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
    // 二叉搜索树 一次遍历
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ptr = root;
        while(ptr != null){
            if(ptr.val > p.val && ptr.val > q.val){
                ptr = ptr.left;
            }else if(ptr.val < p.val && ptr.val < q.val){
                ptr = ptr.right;
            }else{
                break;
            }
        }
        return ptr;
    }

    // 普通二叉树 递归
    TreeNode res;
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }else{
            boolean lres = dfs(root.left, p, q);
            boolean rres = dfs(root.right, p, q);
            if((lres && rres) || ((root == p || root == q)&&(lres || rres))){
                res = root;
            }
            return lres || rres || root == p || root == q;
        }
    }
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }
}

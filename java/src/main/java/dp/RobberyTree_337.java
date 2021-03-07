package dp;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，
 * 我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，
 * 聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 */
import BinaryTree.TreeNode;

import java.util.HashMap;

/**
 *
 */
public class RobberyTree_337 {
    HashMap<TreeNode, Integer> rob = new HashMap<>();
    HashMap<TreeNode, Integer> unrob = new HashMap<>();
    private void dfs(TreeNode root){
        if(root == null){
            return;
        }else if(root.left == null && root.right == null){
            rob.put(root, root.val);
            unrob.put(root, 0);
        }else{
            dfs(root.left);dfs(root.right);
            rob.put(root, unrob.get(root.left)+unrob.get(root.right) + root.val);
            unrob.put(root, Math.max(rob.get(root.left), unrob.get(root.left)) + Math.max(unrob.get(root.right), rob.get(root.right)));
        }
    }
    public int rob(TreeNode root) {
        rob.clear();
        unrob.clear();
        rob.put(null, 0);
        unrob.put(null, 0);
        dfs(root);
        return Math.max(rob.get(root), unrob.get(root));
    }
}

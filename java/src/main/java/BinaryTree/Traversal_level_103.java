package BinaryTree;


import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Traversal_level_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        int direction = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        queue.addLast(null);
        List<Integer> levelNums = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node;
            if (direction == 1) {
                node = queue.pollFirst();
            } else {
                node = queue.pollLast();
            }

            if (node == null) {
                if (queue.isEmpty()) {
                    res.add(levelNums);
                    break;
                }
                // 当前层遍历结束
                if (direction == 1)
                    queue.addFirst(null);
                else
                    queue.addLast(null);
                // 下次从后往前遍历
                direction = direction == 1 ? 0 : 1;
                res.add(levelNums);
                levelNums = new LinkedList<>();
            } else {
                levelNums.add(node.val);
                // 取左右儿子加入队列
                if (direction == 1) {
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null)
                        queue.addLast(node.right);
                } else {
                    if (node.right != null)
                        queue.addFirst(node.right);
                    if (node.left != null)
                        queue.addFirst(node.left);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        queue.addLast(root);
        queue.addLast(null);
        boolean left2right = true;
        LinkedList<Integer> line = new LinkedList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.pollFirst();
            if(node != null){
                line.add(node.val);
                if(node.left != null)
                    queue.addLast(node.left);
                if(node.right != null)
                    queue.addLast(node.right);
            }else{
                if(!queue.isEmpty())
                    queue.addLast(null);
                if(!left2right){
                    Collections.reverse(line);
                }
                left2right = !left2right;
                res.addLast(line);
                line = new LinkedList<>();
            }
        }
        return res;
    }


}

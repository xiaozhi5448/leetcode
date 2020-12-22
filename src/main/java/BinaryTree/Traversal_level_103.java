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
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int direction = 1;
        queue.addLast(root);
        queue.addLast(null);
        LinkedList<Integer> levelnums = new LinkedList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.pollFirst();
            if(node != null){
                levelnums.add(node.val);
                if(node.left !=null)
                queue.addLast(node.left);
                if(node.right !=null)
                    queue.addLast(node.right);
            }else{
                if(direction == 1){
                    res.add(levelnums);
                }else{
                    Collections.reverse(levelnums);
                    res.add(levelnums);
                }
                if(queue.isEmpty()){

                    break;
                }
                levelnums = new LinkedList<>();
                direction = direction==1? 0:1;

                queue.addLast(null);


            }
        }
        return res;

    }


}

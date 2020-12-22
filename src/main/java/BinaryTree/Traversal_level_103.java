package BinaryTree;


import java.util.LinkedList;
import java.util.List;

public class Traversal_level_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        int direction = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        queue.addLast(null);
        List<Integer> levelNums = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node;
            if(direction == 1){
                node = queue.pollFirst();
            }else{
                node = queue.pollLast();
            }

            if (node == null) {
                if(queue.isEmpty()){
                    break;
                }
                // 当前层遍历结束
                queue.addFirst(null);
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


}

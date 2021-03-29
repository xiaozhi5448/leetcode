package BinaryTree;


import java.util.*;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}

public class Traversal {
    List<Integer> res = new LinkedList<Integer>();

    public void clear() {
        res.clear();
    }

    private void preorderRecursionUtil(TreeNode node) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        this.preorderRecursionUtil(node.left);
        this.preorderRecursionUtil(node.right);
    }

    public List<Integer> preorderRecursion(TreeNode root) {
        this.preorderRecursionUtil(root);
        return this.res;
    }

    public List<Integer> preorderLoop(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> bulk = new Stack<TreeNode>();
        if (root != null) {
            bulk.push(root);
        }

        while (!bulk.empty()) {
            TreeNode tmpnode = bulk.pop();
            res.add(tmpnode.val);
            if (tmpnode.right != null) {
                bulk.push(tmpnode.right);
            }
            if (tmpnode.left != null) {
                bulk.push(tmpnode.left);
            }
        }
        return res;
    }

    public void inorderRecursionUtil(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderRecursionUtil(node.left);
        res.add(node.val);
        inorderRecursionUtil(node.right);
    }

    public List<Integer> inorderRecursion(TreeNode root) {
        inorderRecursionUtil(root);
        return res;
    }

    public List<Integer> inorderLoop(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> bulk = new Stack<TreeNode>();
        TreeNode tmpnode = root;
        while (tmpnode != null) {
            bulk.push(tmpnode);
            tmpnode = tmpnode.left;
        }
        while (!bulk.empty()) {
            tmpnode = bulk.pop();
            res.add(tmpnode.val);
            if (tmpnode.right != null) {
                TreeNode tmpnode2 = tmpnode.right;
                while (tmpnode2 != null) {
                    bulk.push(tmpnode2);
                    tmpnode2 = tmpnode2.left;
                }
            }

        }
        return res;
    }

    private void postorderRecursionUtil(TreeNode root) {
        if (root == null) {
            return;
        }
        this.postorderRecursionUtil(root.left);
        this.postorderRecursionUtil(root.right);
        res.add(root.val);
    }

    public List<Integer> postorderRecursion(TreeNode root) {
        this.postorderRecursionUtil(root);
        return this.res;
    }

    public List<Integer> postorderLoop(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> bulk = new Stack<TreeNode>();
        if (root != null) {
            bulk.push(root);
        }
        TreeNode flag = root;
        while (!bulk.empty()) {
            TreeNode top = bulk.peek();
            if (top.left == flag || top.right == flag || (top.left == null && top.right == null)) {
                flag = bulk.pop();
                res.add(flag.val);
            } else {
                if (top.right != null) {
                    bulk.push(top.right);
                }
                if (top.left != null) {
                    bulk.push(top.left);
                }
            }
        }
        return res;
    }

    public List<Integer> postorderLoop2(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> bulk = new Stack<TreeNode>();
        if (root != null) {
            bulk.push(root);
        }
        TreeNode prev = null;
        TreeNode top = null;
        while (!bulk.empty()) {
            top = bulk.peek();
            while (top != null) {
                bulk.push(top.left);
            }

            top = bulk.peek();
            if (top.right == null || top.right == prev) {
                res.add(top.val);
                prev = bulk.pop();
            } else {
                top = top.right;
            }
        }
        return res;
    }

    public List<List<Integer>> levelorder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> line = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root != null) {
            queue.offer(root);
            queue.offer(null);
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null){
                res.add(new LinkedList<Integer>(line));
                line.clear();
                if(queue.isEmpty()){
                    break;
                }
                queue.offer(null);
            }else{
                line.add(node.val);
                if(node.left!= null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

    class Pair {
        Integer flag;
        TreeNode node;

        public Pair(Integer flag, TreeNode node) {
            this.flag = flag;
            this.node = node;
        }
    }

    // 双色标记法
    // white 表示第一次遍历，gray表示从栈中弹出
    public List<Integer> inorderTraversal(TreeNode root) {
        int white = 0, gray = 1;
        Stack<Pair> bulk = new Stack<Pair>();
        if (root != null) {
            bulk.push(new Pair(white, root));
        }
        List<Integer> res = new LinkedList<Integer>();
        while (!bulk.isEmpty()) {
            Pair pair = bulk.pop();
            TreeNode node = pair.node;
            if (pair.flag == gray) {
                res.add(node.val);
            } else {
                if (node.right != null) {
                    bulk.push(new Pair(white, node.right));
                }
                bulk.push(new Pair(gray, node));
                if (node.left != null) {
                    bulk.push(new Pair(white, node.left));
                }
            }
        }
        return res;
    }

    // morris 遍历
}

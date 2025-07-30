package BinaryTree;

import java.util.*;

public class CommonSolution {
    /**
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> levelQueue = new LinkedList<>();
        List<List<Integer>> results = new ArrayList<>();
        if(root == null){
            return results;
        }
        TreeNode splitor = new TreeNode();
        levelQueue.offer(root);
        levelQueue.offer(splitor);
        List<Integer> levelRes = new ArrayList<>();
        while(!levelQueue.isEmpty()){
            TreeNode node = levelQueue.poll();
            if(node == splitor){
                results.add(levelRes);

                if(levelQueue.isEmpty()){
                    break;
                }
                levelRes = new ArrayList<>();
                levelQueue.offer(splitor);
                continue;
            }
            levelRes.add(node.val);
            if(node.left != null){
                levelQueue.offer(node.left);
            }
            if(node.right != null){
                levelQueue.offer(node.right);
            }

        }
        return results;
    }

    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
     */
    public TreeNode sortedArrayToBSTWithRange(int[] nums, int start, int end) {
        if(end < start){
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode leftRoot = sortedArrayToBSTWithRange(nums, start, mid - 1);
        TreeNode rightRoot = sortedArrayToBSTWithRange(nums, mid + 1, end);
        root.left  = leftRoot;
        root.right = rightRoot;
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTWithRange(nums, 0, nums.length-1);
    }


    /**
     * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     * @param root
     * @return
     */
    private void dfs(TreeNode root, int height, Map<Integer, Integer> record){
        if(root == null){
            return;
        }
        dfs(root.right, height + 1, record);
        if(!record.containsKey(height)){
            record.put(height, root.val);
        }
        dfs(root.left, height+1, record);
    }
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> res = new HashMap<>();
        dfs(root, 0, res);
        List<Integer> arr = new ArrayList<>(res.size());
        for(int i = 0; i < res.size(); i++){
            arr.add(res.get(i));
        }
        return arr;
    }

    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     *
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     */

    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        if(prev == null){
            prev = root;
        }else{
            prev.right = root;
            prev = root;
        }
        flatten(left);
        flatten(right);
    }

    /**
     * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     */
    public TreeNode buildTree(int[] preorder, int preI, int preJ, int[] inorder, int II, int IJ) {
        if(preI > preJ){
            return null;
        }
        int val = preorder[preI];
        TreeNode root = new TreeNode(val);
        int ptr = II;
        while(inorder[ptr] != val){
            ptr++;
        }
        int len = ptr - II;
        root.left = buildTree(preorder, preI + 1, preI + len, inorder, II, ptr-1);
        root.right = buildTree(preorder, preI+len + 1, preJ, inorder, ptr+1, IJ);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    /**
     * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
     *
     * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     */

    private int findPathCount(TreeNode root, Map<Long, Integer> pathPrefixSum, long prefixSum, int targetSum){
        if(root == null){
            return 0;
        }
        long currSum = prefixSum + root.val;
        int ret = pathPrefixSum.getOrDefault(currSum - targetSum, 0); // 前缀和 等于 当前路径和 减去 targetSum 的数量
        pathPrefixSum.put(currSum, pathPrefixSum.getOrDefault(currSum, 0) + 1);
        int leftRet = findPathCount(root.left, pathPrefixSum, currSum, targetSum);
        int rightRet = findPathCount(root.right, pathPrefixSum, currSum, targetSum);
        pathPrefixSum.put(currSum, pathPrefixSum.getOrDefault(currSum, 0) -1 );
        return ret + leftRet + rightRet;
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> pathRecorder = new HashMap<>();
        pathRecorder.put(0L, 1);
        return findPathCount(root, pathRecorder, 0, targetSum);
    }

}

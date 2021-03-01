package BinaryTree;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class SubStructure_26 {
    // 注意B是A的子结构，B可以提前走到叶子节点，需要注意判断条件
    private boolean same(TreeNode A, TreeNode B){
        if(B==null){
            return true;
        }
        if(A==null){
            return false;
        }
        if(A.val == B.val){
            return same(A.left, B.left) && same(A.right, B.right);
        }else{
            return false;
        }
    }
    private boolean recursionUtil(TreeNode A, TreeNode B){
        if(A == B && A == null){
            return true;
        }
        if(A==null || B==null){
            return false;
        }
        boolean root_res = false;
        if(A.val == B.val){
            root_res = same(A, B);
        }
        if(root_res)
            return true;
        return recursionUtil(A.left, B) || recursionUtil(A.right, B);
    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null){
            return false;
        }
        return recursionUtil(A, B);
    }
}

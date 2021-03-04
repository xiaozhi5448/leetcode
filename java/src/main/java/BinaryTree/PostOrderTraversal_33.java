package BinaryTree;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class PostOrderTraversal_33 {
    int index = 0;
    private boolean verify(int[] order,int start, int end){
        if(start >= end-1){
            return true;
        }
        int biggerIndex = start;
        while(biggerIndex < end && order[biggerIndex]<order[end]){
            biggerIndex++;
        }
        for(int i = biggerIndex; i< end; i++){
            if(order[i] < order[end])
                return false;
        }
        return verify(order, start, biggerIndex-1) && verify(order, biggerIndex, end-1);

    }
    public boolean verifyPostorder(int[] postorder) {
        boolean res = verify(postorder, 0, postorder.length-1);
        return res;
    }
}

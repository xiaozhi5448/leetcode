package BinaryTree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BSTSerialize_offer_37Test {

    static Traversal util = new Traversal();

    @Test
    public void serialize() {
        BSTSerialize_offer_37 bstSerializer = new BSTSerialize_offer_37();
        TreeNode root = bstSerializer.deserialize("[1,2,3,null,null,4,5]");
        util.clear();
        List<Integer> res = util.inorderTraversal(root);
        System.out.println(res.toString());
        System.out.println(bstSerializer.serialize(root));
    }
}
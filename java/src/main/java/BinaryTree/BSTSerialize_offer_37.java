package BinaryTree;
import java.util.*;
public class BSTSerialize_offer_37 {
      LinkedList<TreeNode> bfs(TreeNode root){
        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<TreeNode> layerPrev = new LinkedList<>();
        LinkedList<TreeNode> layerNext = new LinkedList<>();
        if(root == null){
            return nodes;
        }
        nodes.add(root);
        layerPrev.add(root);
        while(!layerPrev.stream().allMatch((item)->(item == null))){
            while(!layerPrev.isEmpty()){
                TreeNode node = layerPrev.pollFirst();
                if(node == null){
                    layerNext.addLast(null);
                    layerNext.addLast(null);
                }else{
                    layerNext.addLast(node.left);
                    layerNext.addLast(node.right);
                }
            }
            nodes.addAll(layerNext);
            LinkedList<TreeNode> tmp = layerPrev;
            layerPrev = layerNext;
            layerNext = tmp;
            layerNext.clear();
        }
        return nodes;
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "[]";
        }

        LinkedList<TreeNode> nodes = bfs(root);

        while(nodes.get(nodes.size()-1) == null){
            nodes.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(TreeNode node: nodes){
            if(node == null){
                sb.append("null");
            }else{
                sb.append("" + node.val);
            }
            sb.append(',');
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.trim();
        int startIndex = 0;
        if(data.charAt(startIndex) == '['){
            startIndex++;
        }
        int endIndex = data.length()-1;
        if(data.charAt(endIndex) == ']'){
            endIndex--;
        }
        if(startIndex > endIndex){
            return null;
        }
        data = data.substring(startIndex, endIndex+1);
        String[] items = data.split(",");
        TreeNode[] nodes = new TreeNode[items.length];
        for(int i = 0; i<items.length; i++){
            if(items[i].equals("null")){
                nodes[i] = null;
            }else{
                nodes[i] = new TreeNode(Integer.valueOf(items[i]));
            }
        }
        for(int i = 0; i< nodes.length/2; i++){
            if(nodes[i] == null)
                continue;
            if(2*i +1 < nodes.length){
                nodes[i].left = nodes[2*i+1];
            }
            if(2*i + 2 < nodes.length){
                nodes[i].right = nodes[2*i+2];
            }
        }
        return nodes[0];
    }
}

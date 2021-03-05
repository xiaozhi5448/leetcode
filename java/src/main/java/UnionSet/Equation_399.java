package UnionSet;

import java.util.HashMap;
import java.util.List;

public class Equation_399 {

    private class Node{
        String val;
        int factor;
        Node parent;
    }

    Node parent(HashMap<String, Node> parents, Node node){
        Node nodePtr = node;
        if(parents.get(nodePtr).parent != node){
            nodePtr = parents.get(nodePtr).parent;
        }
        Node root = nodePtr;
        nodePtr = node;
        return null;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        return null;
    }
}

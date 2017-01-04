package programming.datastructure;

// https://www.hackerrank.com/challenges/self-balancing-tree
public class SelfBalancingTree {

    static class Node {
        Node left;
        Node right;
        int val;
        int ht;
    }
    
    // Assumption: node, rightChild cannot be null; parent can be null
    void leftRotate(Node node, Node rightChild, Node parent) {
        node.right = rightChild.left;
        rightChild.left = node;
        
        if (parent != null) {
            if (parent.left == node) {
                parent.left = rightChild;
            } else {
                parent.right = rightChild;
            }
        }
        
    }
    
    // Assumption: node, leftChild cannot be null; parent can be null
    void rightRotate(Node node, Node leftChild, Node parent) {
        node.left = leftChild.right;
        leftChild.right = node;
        
        if (parent != null) {
            if (parent.left == node) {
                parent.left = leftChild;
            } else {
                parent.right = leftChild;
            }
        }
    }
    
    // TODO: if parent is null for left or right rotate, it means node is the root; need to
    // set the root pointer accordingly in these cases.
    
    public static void main(String[] args) {

    }

}

package programming.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

// https://www.hackerrank.com/challenges/self-balancing-tree
public class SelfBalancingTree {

    static class Node {
        Node left;
        Node right;
        int val;
        int ht;
    }
    
    // Assumption: node, rightChild cannot be null; parent can be null
    static void leftRotate(Node node, Node rightChild, Node parent) {
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
    static void rightRotate(Node node, Node leftChild, Node parent) {
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
    
    static void updateHeight(Node node) {
        if (node != null) {
            int leftHeight = -1;
            int rightHeight = -1;

            if (node.left != null) {
                leftHeight = node.left.ht;
            }
            
            if (node.right != null) {
                rightHeight = node.right.ht;
            }
            
            node.ht = Math.max(leftHeight, rightHeight) + 1;
        }
    }
    
    static boolean isNodeBalanced(Node node) {
        if (node == null) {
            return true;
        } else {
            int leftHt = (node.left == null ? -1 : node.left.ht);
            int rightHt = (node.right == null ? -1 : node.right.ht);
            int balanceFactor = leftHt - rightHt;
            return balanceFactor <= 1 && balanceFactor >= -1; 
        }
    }
    
    
    // TODO: if parent is null for left or right rotate, it means node is the root; need to
    // set the root pointer accordingly in these cases.
    
    public static void main(String[] args) {

    }
    

    enum Balance {
        LEFT_LEFT, LEFT_RIGHT, RIGHT_LEFT, RIGHT_RIGHT
    } 

    static void reBalance(Node newNode, Deque<Node> path) {
        Balance balance = null;
        
        Node parent = path.pop();
        Node grandParent = path.pop();
        Node greatGrand = path.isEmpty() ? null : path.pop();
        
        if (grandParent.left.equals(parent)) {
            if (parent.left.equals(newNode)) {
                balance = Balance.LEFT_LEFT;
            } else {
                balance = Balance.LEFT_RIGHT;
            }
        } else {
            if (parent.left.equals(newNode)) {
                balance = Balance.RIGHT_LEFT;
            } else {
                balance = Balance.RIGHT_RIGHT;
            }
        }
        
        rotate(newNode, parent, grandParent, greatGrand, balance);
    }
    
    static void rotate(Node newNode, Node parent, Node grandParent, Node greatGrand, Balance balance) {
        if (balance.equals(Balance.LEFT_LEFT)) {
            rightRotate(grandParent, parent, greatGrand);
        } else if (balance.equals(Balance.LEFT_RIGHT)) {
            leftRotate(parent, newNode, grandParent);
            rotate(parent, newNode, grandParent, greatGrand, Balance.LEFT_LEFT);
        } else if (balance.equals(Balance.RIGHT_LEFT)) {
            
        } else {
            
        }
    }

    static Node insert(Node root, int val)
    {
        Deque<Node> path = new ArrayDeque<>();
        Node newNode = new Node();
        newNode.val = val;
        newNode.ht = 0;
        
        if (root == null) {
            return newNode;
        } else {
            Node currentNode = root;
            
            while (currentNode != null) {
                path.push(currentNode);
                
                if (newNode.val < currentNode.val) {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }
            }
            
            Node parent = path.peek();
            if (parent.val > newNode.val) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            
            
            path.stream().forEach(n -> updateHeight(n));
            
            boolean treeBalanced = true;
            for (Node n : path) {
                if (!isNodeBalanced(n)) {
                    treeBalanced = false;
                    break;
                }
            }
            
            if (!treeBalanced) {
                reBalance(newNode, path);
            }
            
            return root;
        }
    }


}

package programming.datastructure;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/swap-nodes-algo
public class SwapNodes {
    
    private static class Node {
        Node left;
        Node right;
        int value;
        
        public Node getLeft() {
            return left;
        }
        public void setLeft(Node left) {
            this.left = left;
        }
        public Node getRight() {
            return right;
        }
        public void setRight(Node right) {
            this.right = right;
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
    }

    private static class BinaryTree {
        private Node root;
        
        public BinaryTree(Node root) {
            this.root = root;
        }
    }
    
    public static void main(String[] args) {
        Node root = new Node();
        root.setValue(1);
        BinaryTree tree = new BinaryTree(root);
        
        Scanner scanner = new Scanner(System.in);
        int numNodes = scanner.nextInt();
        
        for (int i = 0; i <= numNodes; i++) {
            int leftVal = scanner.nextInt();
            int rightVal = scanner.nextInt();
            
            if (leftVal != -1) {
                Node leftNode = new Node();
                leftNode.setValue(leftVal);
                root.setLeft(leftNode);
            }
            
            if (rightVal != -1) {
                Node rightNode = new Node();
                rightNode.setValue(rightVal);
                root.setRight(rightNode);
            }
        }
    }

}

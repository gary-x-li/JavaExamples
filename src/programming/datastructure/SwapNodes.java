package programming.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/swap-nodes-algo
public class SwapNodes {
    
    static class Node {
        private Node left;
        private Node right;
        private int value;
        private int depth;
        
        public Node(int value) {
            this.value = value;
        }
        
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
        public int getDepth() {
            return depth;
        }
        public void setDepth(int depth) {
            this.depth = depth;
        }
        
    }

    static class BinaryTree {
        private List<Node> nodes = new ArrayList<>();
        private Map<Integer, List<Node>> nodesByDepth = new HashMap<>();
        
        public BinaryTree(int numNodes) {
            for (int i = 0; i < numNodes; i++) {
                nodes.add(new Node(i+1));
                nodesByDepth.put(i+1, new ArrayList<Node>());
            }
        }
        
        public Node getNode(int nodeValue) {
            return nodes.get(nodeValue-1);
        }
        
        public List<Node> getNodesAtDepth(int depth) {
            return nodesByDepth.get(depth);
        }
    }
    
    static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        
        inOrderTraversal(root.getLeft());
        
        System.out.print(root.getValue() + " ");
        
        inOrderTraversal(root.getRight());
    }
    
    static void swap() {
        
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numNodes = scanner.nextInt();
        BinaryTree tree = new BinaryTree(numNodes);
        
        for (int i = 0; i < numNodes; i++) {
            Node node = tree.getNode(i+1);
            node.setDepth(i+1);
            tree.getNodesAtDepth(i+1).add(node);
            
            int leftVal = scanner.nextInt();
            int rightVal = scanner.nextInt();
            
            if (leftVal != -1) {
                node.setLeft(tree.getNode(leftVal));
            }
            
            if (rightVal != -1) {
                node.setRight(tree.getNode(rightVal));
            }
        }
        
        scanner.close();
        
        inOrderTraversal(tree.getNode(1));
    }

}

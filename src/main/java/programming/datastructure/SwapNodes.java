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
        
        public String toString() {
            return "Node " + value;
        }
        
    }

    static class BinaryTree {
        private List<Node> nodes = new ArrayList<>();
        private Map<Integer, List<Node>> nodesByDepth = new HashMap<>();
        
        public BinaryTree(int numNodes) {
            for (int i = 0; i < numNodes; i++) {
                nodes.add(new Node(i+1));
            }
            nodes.get(0).setDepth(1);
            addNodeToDepth(nodes.get(0), 1);
        }
        
        public Node getNode(int nodeValue) {
            return nodes.get(nodeValue-1);
        }
        
        public void addNodeToDepth(Node node, int depth) {
            if (nodesByDepth.get(depth) == null) {
                nodesByDepth.put(depth, new ArrayList<Node>());
            } 
            
            nodesByDepth.get(depth).add(node);
        }
        
        public List<Node> getNodesAtDepth(int depth) {
            return nodesByDepth.get(depth);
        }
        
        public int getDepth() {
            return nodesByDepth.size();
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
    
    static void swap(BinaryTree tree, int depth) {
        List<Node> nodes = tree.getNodesAtDepth(depth);
        
        for (Node node : nodes) {
            Node left = node.getLeft();
            Node right = node.getRight();
            node.setLeft(right);
            node.setRight(left);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numNodes = scanner.nextInt();
        BinaryTree tree = new BinaryTree(numNodes);
        
        for (int i = 0; i < numNodes; i++) {
            Node node = tree.getNode(i+1);
            
            int leftVal = scanner.nextInt();
            int rightVal = scanner.nextInt();
            
            if (leftVal != -1) {
                Node leftNode = tree.getNode(leftVal);
                node.setLeft(leftNode);
                leftNode.setDepth(node.getDepth() + 1);
                tree.addNodeToDepth(leftNode, leftNode.getDepth());
            }
            
            if (rightVal != -1) {
                Node rightNode = tree.getNode(rightVal);
                node.setRight(rightNode);
                rightNode.setDepth(node.getDepth() + 1);
                tree.addNodeToDepth(rightNode, rightNode.getDepth());
            }
        }
        
        int numSwap = scanner.nextInt();
        
        for (int i = 0; i < numSwap; i++) {
            int k = scanner.nextInt();
            
            for (int j = k; j <= tree.getDepth(); j += k) {
                swap(tree, j);
            }
            
            inOrderTraversal(tree.getNode(1));
            System.out.println();
        }
        
        scanner.close();
        
        
    }

}

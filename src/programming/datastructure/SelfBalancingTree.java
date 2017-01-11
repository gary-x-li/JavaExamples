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

    static void reBalance(Node greatGrand, Node grandParent, Node parent, Boolean greatGrandLeft, Boolean grandParentLeft, Boolean parentLeft) {
        if (grandParentLeft == true && parentLeft == true) {
            grandParent.left = parent.right;
            parent.right = grandParent;
            grandParent.ht -= 1;
            parent.ht += 1;
            
            if (greatGrand != null) {
                if (greatGrandLeft) {
                    greatGrand.left = parent;
                } else {
                    greatGrand.right = parent;
                }
            }
            
            return;
        } else if (grandParentLeft == true && parentLeft == false) {
            Node current = parent.right;
            parent.right = current.left;
            current.left = parent;
            grandParent.left = current;
            parent.ht -= 1;
            current.ht += 1;
            
            reBalance(greatGrand, grandParent, current, greatGrandLeft, true, true);
        } else if (grandParentLeft == false && parentLeft == true) {
            Node current = parent.left;
            parent.left = current.right;
            current.right = parent;
            grandParent.right = current;
            parent.ht -= 1;
            current.ht += 1;
            
            reBalance(greatGrand, grandParent, current, greatGrandLeft, false, false);
        } else {
            grandParent.right = parent.left;
            parent.left = grandParent;
            grandParent.ht -= 1;
            parent.ht += 1;
            
            if (greatGrand != null) {
               if (greatGrandLeft) {
                    greatGrand.left = parent;
                } else {
                    greatGrand.right = parent;
                }
            }
            
            return;
        }
    }

    static Node insert(Node root,int val)
    {
        Node newNode = new Node();
        newNode.val = val;
        newNode.ht = 0;
        
        if (root == null) {
            return newNode;
        } else {
            Node currentNode = root;
            Node parent = null;
            Node grandParent = null;
            Node greatGrand = null;
            Boolean parentLeft = null;
            Boolean grandParentLeft = null;
            Boolean greatGrandLeft = null;
            
            while (currentNode != null) {
                greatGrand = grandParent;
                grandParent = parent;
                parent = currentNode;
                currentNode.ht += 1;
                greatGrandLeft = grandParentLeft;
                grandParentLeft = parentLeft;
                if (newNode.val < currentNode.val) {
                    parentLeft = true;
                    currentNode = currentNode.left;
                } else {
                    parentLeft = false;
                    currentNode = currentNode.right;
                }
            }
            
            if (parentLeft) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            
            if (grandParent != null) {
                if (!isNodeBalanced(parent) || !isNodeBalanced(grandParent) || !isNodeBalanced(greatGrand)) {
                    reBalance(greatGrand, grandParent, parent, greatGrandLeft, grandParentLeft, parentLeft);
                }
            }
            
            return root;
        }
    }


}

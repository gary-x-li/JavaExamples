package programming.datastructure;

import java.util.HashMap;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/ctci-contacts
public class Contacts {
    static class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isCompleteContact = false;
    }
    
    static TrieNode root = new TrieNode();
    
    static void add(String contact) {
        TrieNode node = root;
        for (int i = 0; i < contact.length(); i++) {
            char c = contact.charAt(i);
            if (node.children == null) {
                node.children = new HashMap<Character, TrieNode>();
            }
            
            if (node.children.get(c) == null) {
                TrieNode newNode = new TrieNode();
                node.children.put(c, newNode);
            }
            node = node.children.get(c);
            
            if (i == contact.length() - 1) {
                node.isCompleteContact = true;
            }
        }
    }
    
    static int find(String partial) {
        TrieNode node = root;
        for (int i = 0; i < partial.length(); i++) {
            char c = partial.charAt(i);
            if (node.children == null || node.children.get(c) == null) {
                return 0;
            }
            
            node = node.children.get(c);
        }
        
        return recursiveCount(node);
    }
    
    static int recursiveCount(TrieNode node) {
        if (node.children == null) {
            return node.isCompleteContact ? 1 : 0;
        } else {
            int count = 0;
            for (TrieNode n : node.children.values()) {
                count += recursiveCount(n);
            }
            
            if (node.isCompleteContact) {
                count += 1;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String op = in.next();
            String contact = in.next();
            
            if (op.equals("add")) {
                add(contact);
            } else if (op.equals("find")) {
                System.out.println(find(contact));
            }
        }
        
        in.close();
    }

}

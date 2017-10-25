package programming.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/balanced-brackets
public class BalancedBrackets {
    
    static boolean isBalanced(String brackets) {
        if (brackets.length() % 2 != 0) {
            return false;
        }
        
        Deque<String> stack = new ArrayDeque<String>();
        
        for (int i = 0; i < brackets.length(); i++) {
            String currentBracket = String.valueOf(brackets.charAt(i));
            if (currentBracket.equals("{") || currentBracket.equals("[") || currentBracket.equals("(")) {
                stack.push(currentBracket);
            } else {
                if (stack.peek() == null) {
                    return false;
                }
                
                String potentialMatchingBracket = stack.pop();
                if (currentBracket.equals("}") && !potentialMatchingBracket.equals("{")) {
                    return false;
                } else if (currentBracket.equals("]") && !potentialMatchingBracket.equals("[")) {
                    return false;
                } else if (currentBracket.equals(")") && !potentialMatchingBracket.equals("(")) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            String s = in.next();
            if (isBalanced(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        in.close();

    }

}

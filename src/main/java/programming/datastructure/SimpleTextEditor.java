package programming.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.IntStream;

// https://www.hackerrank.com/challenges/simple-text-editor
public class SimpleTextEditor {
    
    private static Deque<String> stack = new ArrayDeque<>();
    
    static void process(Scanner scanner) {
        int operationType = scanner.nextInt();
        String content = stack.peek();
        switch (operationType) {
            case 1:
                String strToAppend = scanner.next();
                stack.push(content + strToAppend);
                break;
            case 2:
                int numCharsToDelete = scanner.nextInt();
                stack.push(content.substring(0, content.length() - numCharsToDelete));
                break;
            case 3:
                int kthCharToPrint = scanner.nextInt();
                System.out.println(content.charAt(kthCharToPrint - 1));
                break;
            case 4:
                stack.pop();
                break;
            default:
                break;
            
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOps = scanner.nextInt();
        stack.push("");
        
        IntStream.rangeClosed(1, numOps)
                 .forEach(i -> process(scanner));
        
        scanner.close();
        
    }

}

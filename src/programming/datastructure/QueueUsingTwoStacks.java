package programming.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class QueueUsingTwoStacks {
    
    static class Queue {
        Deque<Integer> inStack = new ArrayDeque<>();
        Deque<Integer> outStack = new ArrayDeque<>();
        boolean inMode = true;
        
        void enqueue(Integer i) {
            if (!inMode) {
                while (!outStack.isEmpty()) {
                    inStack.push(outStack.pop());
                }
                inMode = true;
            }
            
            inStack.push(i);
        }
        
        Integer dequeue() {
            if (inMode) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
                inMode = false;
            }
            
            return outStack.pop();
        }
        
        void printFirst() {
            if (inMode) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
                inMode = false;
            }
            
            System.out.println(outStack.peek());
        }
    }
    
    static class BetterQueue<T> {
        Deque<T> inStack = new ArrayDeque<>();
        Deque<T> outStack = new ArrayDeque<>();
        
        void enqueue(T i) {
            inStack.push(i);
        }
        
        T dequeue() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            
            return outStack.pop();
        }
        
        void printFirst() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            
            System.out.println(outStack.peek());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOps = scanner.nextInt();
        BetterQueue<Integer> queue = new BetterQueue<Integer>();
        
        for (int i = 1; i <= numOps; i++) {
            int opType = scanner.nextInt();
            switch (opType) {
                case 1:
                    queue.enqueue(scanner.nextInt());
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.printFirst();
                    break;
                default:
                    break;
                
            }
        }
        
        scanner.close();

    }

}

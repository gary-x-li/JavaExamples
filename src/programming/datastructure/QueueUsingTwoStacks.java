package programming.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

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
            }
            
            inStack.push(i);
        }
        
        Integer dequeue() {
            if (inMode) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            
            return outStack.pop();
        }
    }

    public static void main(String[] args) {

    }

}

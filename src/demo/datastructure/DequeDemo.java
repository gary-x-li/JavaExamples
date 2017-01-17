package demo.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {

    public static void main(String[] args) {
        Deque<Integer> numbers = new ArrayDeque<>();
        
        numbers.push(new Integer(1));
        numbers.push(new Integer(2));
        numbers.push(new Integer(3));

        for (Integer n : numbers) {
            System.out.println(n);
        }
        
        numbers.stream().forEach(System.out::println);
    }

}

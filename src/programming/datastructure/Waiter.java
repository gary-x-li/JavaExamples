package programming.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/waiter
public class Waiter {
    
    static List<Integer> primeNumbersUpTo(int n) {
        List<Integer> primeNumbers = new ArrayList<>();
        boolean isPrime[] = new boolean[n+1];
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime
        
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i*2; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primeNumbers.add(i);
            }
        }
        
        return primeNumbers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPlates = scanner.nextInt();
        int numIterations = scanner.nextInt();
        Deque<Integer> a0 = new ArrayDeque<>();
        
        for (int i = 0; i < numPlates; i++) {
            a0.push(scanner.nextInt());
        }
        
        List<Integer> primeNumbers = primeNumbersUpTo(numIterations);
        
        for (int i = 1; i <= numIterations; i++) {
            Deque<Integer> b = new ArrayDeque<>();
            for (Integer num : a0) {
                if (num % primeNumbers.get(i-1) == 0) {
                    b.push(num);
                } else {
                    
                }
            }
        }
        
        scanner.close();
    }

}

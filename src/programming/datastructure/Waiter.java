package programming.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/waiter
public class Waiter {
    
    // Sieve of Eratosthenes. Not used here because we need the list the have n prime numbers,
    // not up to n.
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
    
    static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    static List<Integer> primeNumbersWithCount(int n) {
        List<Integer> primeNumbers = new ArrayList<>();
        int num = 2;
        
        while (primeNumbers.size() < n) {
            if (isPrime(num)) {
                primeNumbers.add(num);
            }
            num++;
        }
        
        return primeNumbers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPlates = scanner.nextInt();
        int numIterations = scanner.nextInt();
        Deque<Integer> aCurrent = new ArrayDeque<>();
        
        for (int i = 0; i < numPlates; i++) {
            aCurrent.push(scanner.nextInt());
        }
        
        List<Integer> primeNumbers = primeNumbersWithCount(numIterations);
        
        for (int i = 1; i <= numIterations; i++) {
            Deque<Integer> aNext = new ArrayDeque<>();
            Deque<Integer> b = new ArrayDeque<>();
            
            while (!aCurrent.isEmpty()) {
                Integer num = aCurrent.pop();
                if (num % primeNumbers.get(i-1) == 0) {
                    b.push(num);
                } else {
                    aNext.push(num);
                }
            }
            
            aCurrent = aNext;
            while (!b.isEmpty()) {
                System.out.println(b.pop());
            }
        }
        
        while (!aCurrent.isEmpty()) {
            System.out.println(aCurrent.pop());
        }
        
        scanner.close();
    }

}

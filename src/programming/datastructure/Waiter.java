package programming.datastructure;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println(primeNumbersUpTo(100));
    }

}

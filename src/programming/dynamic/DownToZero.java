package programming.dynamic;

import java.util.Scanner;
import java.util.stream.IntStream;

// https://www.hackerrank.com/challenges/down-to-zero-ii
public class DownToZero {
    
    static boolean isPrime(int n) {
        return IntStream.rangeClosed(2, (int)Math.sqrt(n))
                        .noneMatch(i -> n % i == 0);
    }
    
    static int higherFactorClosestToSqrt(int n) {
        int sqrt = (int)Math.sqrt(n);
        for (int i = sqrt; i > 1; i--) {
            if (n % i == 0) {
                return n / i;
            }
        }
        
        return n;
    }
    
    static int lowestFactor(int n) {
        int sqrt = (int)Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return i;
            }
        }
        
        return n;
    }
    
    static int downToZero(int n) {
        if (n == 0) {
            return 0;
        } else if (isPrime(n) || n == 1) {
            return downToZero(n-1) + 1;
        } else {
            return downToZero(higherFactorClosestToSqrt(n)) + 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numQueries = scanner.nextInt();
        
        for (int i = 1; i <= numQueries; i++) {
            int n = scanner.nextInt();
            
            if (n > 0) {
                System.out.println(downToZero(n));
            } else {
                System.out.println(downToZero(lowestFactor(-n)) + 1);
            }
        }
        
        scanner.close();
    }

}

// porb: https://www.acmicpc.net/problem/2023

package backjoon.back2023;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

class Back2023 {
    private boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int[] calculateNumber(int digit) {
        if (digit == 0) return new int[]{2, 3, 5, 7};
        int[] subNumbers = calculateNumber(digit - 1);
        List<Integer> numbers = new LinkedList<>();
        for (int subNumber : subNumbers) {
            for (int i = 1; i < 10; i++) {
                int tmp = subNumber * 10 + i;
                if (!isPrime(tmp))
                    continue;
                numbers.add(tmp);
            }
        }
        int[] arr = new int[numbers.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = numbers.get(i);
        }
        return arr;
    }

    public int[] getPrimes(int digit) {
        return calculateNumber(digit - 1);
    }
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        Back2023 back2023 = new Back2023();
        int[] primes = back2023.getPrimes(n);
        for (int prime : primes) {
            writer.write(prime + "\n");
        }
        writer.flush();
    }
}


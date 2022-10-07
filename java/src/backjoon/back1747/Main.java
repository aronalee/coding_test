// prob: https://www.acmicpc.net/problem/1747

package backjoon.back1747;

import java.io.*;
import java.util.Arrays;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static boolean[] getIsPrimes(int n) {
        boolean[] isPrimes = new boolean[n * 10];
        Arrays.fill(isPrimes, true);
        isPrimes[0] = false;
        isPrimes[1] = false;
        for (int i = 2; i < isPrimes.length; i++) {
            if (isPrimes[i]) {
                for (int j = i + i; j < isPrimes.length; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
        return isPrimes;
    }


    private static boolean isPalindrome(int number) {
        char[] strNumber = Integer.toString(number).toCharArray();
        for (int i = 0; i < strNumber.length; i++) {
            if (strNumber[i] != strNumber[strNumber.length - i - 1])
                return false;
        }
        return true;
    }

    private static int getPrimeOfPalindrome(boolean[] isPrimes, int n) {
        for (int i = n; i < isPrimes.length; i++) {
            if (!isPrimes[i])
                continue;
            if (!isPalindrome(i))
                continue;
            return i;
        }
        throw new NullPointerException();
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        boolean[] isPrimes = getIsPrimes(n);
        int number = getPrimeOfPalindrome(isPrimes, n);
        writer.write(number + "\n");
        writer.flush();
    }
}

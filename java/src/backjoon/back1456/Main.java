// prob: https://www.acmicpc.net/problem/1456

package backjoon.back1456;

import java.io.*;
import java.util.Arrays;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static boolean[] getPrimeTable(long start, long end) {
        boolean[] isPrimes = new boolean[(int) Math.ceil(Math.sqrt(end)) + 1];
        Arrays.fill(isPrimes, true);
        for (int i = 2; i < isPrimes.length; i++) {
            if (isPrimes[i]) {
                for (int j = i + i; j < isPrimes.length; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
        return isPrimes;
    }

    private static int countSemiPrime(boolean[] isPrimes, long start, long end) {
        int count = 0;
        for (int i = 2; i < isPrimes.length; i++) {
            if (!isPrimes[i])
                continue;
            int k = 2;
            while ((double) i <= end / Math.pow(i, k - 1)) {
                if ((double) i >= start / Math.pow(i, k - 1)) count++;
                k++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        long start = Long.parseLong(tmp[0]);
        long end = Long.parseLong(tmp[1]);
        boolean[] isPrimes = getPrimeTable(start, end);
        int count = countSemiPrime(isPrimes, start, end);
        writer.write(count + "\n");
        writer.flush();
    }
}

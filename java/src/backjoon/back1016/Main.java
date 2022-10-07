// prob: https://www.acmicpc.net/problem/1016

package backjoon.back1016;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static long countNonNonPowNumber(long min, long max) {
        boolean[] isNonNonPrimes = new boolean[(int) (max - min + 1)];
        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            for (long j = (long) Math.ceil((double) min / pow); j * pow <= max; j++) {
                isNonNonPrimes[(int) ((j * pow) - min)] = true;
            }
        }
        long count = 0;
        for (boolean isNotNonNonPrime : isNonNonPrimes)
            count += isNotNonNonPrime ? 0 : 1;
        return count;
    }


    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        long min = Long.parseLong(tmp[0]);
        long max = Long.parseLong(tmp[1]);
        long count = countNonNonPowNumber(min, max);
        writer.write(count + "\n");
        writer.flush();
    }
}

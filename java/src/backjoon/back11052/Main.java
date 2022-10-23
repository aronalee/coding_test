// https://www.acmicpc.net/problem/11051

package backjoon.back11052;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final long CEIL = 10_007;

    private static long combination(long[][] memoization, int n, int k) {
        if (k < 0 || n < 0)
            return 0;
        if (memoization[n][k] > 0)
            return memoization[n][k];
        memoization[n][k] = combination(memoization, n - 1, k) + combination(memoization, n - 1, k - 1);
        memoization[n][k] %= CEIL;
        return memoization[n][k];
    }

    private static long binomialCoefficient(int n, int k) {
        long[][] memoization = new long[n + 1][n + 1];
        for (int i = 0; i < memoization.length; i++) {
            memoization[i][i] = 1;
        }
        return combination(memoization, n, k);
    }

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);

        long result = binomialCoefficient(n, k);
        writer.write(result + "");
        writer.flush();
    }
}

// prob: https://www.acmicpc.net/problem/1947

package backjoon.back1947;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final long INF = 1_000_000_000;
    private static long[] memoization;

    private static long countCases(int n) {
        if (memoization[n] != 0)
            return memoization[n];
        return memoization[n] = ((n - 1) * (countCases(n - 1) + countCases(n - 2))) % INF;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        memoization = new long[n + 1];
        if (n == 1)
            writer.write("0");
        else if (n == 2)
            writer.write("1");
        else if (n == 3)
            writer.write("2");
        else {
            memoization[1] = 0;
            memoization[2] = 1;
            memoization[3] = 2;
            writer.write(countCases(n) + "\n");
        }
        writer.flush();
    }
}

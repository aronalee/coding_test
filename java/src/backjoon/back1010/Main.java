// prob: https://www.acmicpc.net/problem/1010

package backjoon.back1010;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int[][] memoization = new int[31][31];

    static {
        for (int i = 0; i < memoization.length; i++) {
            memoization[i][i] = 1;
            memoization[i][1] = i;
        }
        for (int i = 2; i < memoization.length; i++) {
            for (int j = 2; j < memoization[i].length; j++) {
                memoization[i][j] = memoization[i - 1][j - 1] + memoization[i - 1][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int testcases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testcases; i++) {
            String[] tmp = reader.readLine().split(" ");
            int west = Integer.parseInt(tmp[0]);
            int east = Integer.parseInt(tmp[1]);
            writer.write(memoization[east][west] + "\n");
        }
        writer.flush();
    }
}

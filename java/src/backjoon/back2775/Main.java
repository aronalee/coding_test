// prob: https://www.acmicpc.net/problem/2775

package backjoon.back2775;

import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int[][] memoization = new int[15][15];

    static {
        for (int i = 0; i < memoization.length; i++) {
            memoization[0][i] = i;
        }
    }

    private static int countRoomInPeople(int n, int k) {
        if (n < 0 || k < 0)
            return 0;
        if (memoization[n][k] != 0)
            return memoization[n][k];
        return memoization[n][k] = countRoomInPeople(n - 1, k) + countRoomInPeople(n, k - 1);
    }

    public static void main(String[] args) throws IOException {
        int testcases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testcases; i++) {
            int n = Integer.parseInt(reader.readLine());
            int k = Integer.parseInt(reader.readLine());
            writer.write(countRoomInPeople(n, k) + "\n");
        }
        writer.flush();
    }
}

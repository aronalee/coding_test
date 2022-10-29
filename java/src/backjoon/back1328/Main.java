// prob: https://www.acmicpc.net/problem/1328

package backjoon.back1328;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final long INF = 1_000_000_007;

    private static long countBuilding(int totalBuilding, int leftBuilding, int rightBuilding) {
        long[][][] m = new long[totalBuilding + 1][rightBuilding + 1][leftBuilding + 1];
        m[1][1][1] = 1;
        for (int n = 2; n <= totalBuilding; n++) {
            for (int right = 1; right <= rightBuilding; right++) {
                for (int left = 1; left <= leftBuilding; left++) {
                    m[n][right][left] += m[n - 1][right - 1][left];
                    m[n][right][left] += m[n - 1][right][left - 1];
                    m[n][right][left] += m[n - 1][right][left] * (n - 2);
                    m[n][right][left] %= INF;
                }
            }
        }
        return m[totalBuilding][rightBuilding][leftBuilding];
    }

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int l = Integer.parseInt(tmp[1]);
        int r = Integer.parseInt(tmp[2]);
        long result = countBuilding(n, l, r);
        writer.write(result + "\n");
        writer.flush();
    }
}

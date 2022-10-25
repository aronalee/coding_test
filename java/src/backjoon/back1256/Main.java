// prob: https://www.acmicpc.net/problem/1256

package backjoon.back1256;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 1_000_000_000;
    private static final int[][] combinations = new int[202][202];

    static {
        for (int i = 0; i < combinations.length; i++) {
            combinations[i][i] = 1;
            combinations[i][1] = 1;
        }
        for (int i = 2; i < combinations.length; i++) {
            for (int j = 2; j < combinations[i].length; j++) {
                combinations[i][j] = combinations[i - 1][j] + combinations[i - 1][j - 1];
                if (combinations[i][j] > INF)
                    combinations[i][j] = INF + 1;
            }
        }
    }

    private static String createString(int n, int m, long k) {
        StringBuilder builder = new StringBuilder();
        int i = n + m;
        int j = n;
        while (i >= 1) {
            if (k > combinations[i][j]) {
                builder.append("z");
                k -= combinations[i][j];
            } else {
                builder.append("a");
                j--;
            }
            i--;
        }
        return builder.toString();
    }

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int k = Integer.parseInt(tmp[2]);
        String answer = combinations[n + m][m] + combinations[n + m][n] >= k ? createString(n, m, k) : "-1";
        writer.write(answer + "\n");
        writer.flush();
    }
}

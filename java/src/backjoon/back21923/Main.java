// prob: https://www.acmicpc.net/problem/21923

package backjoon.back21923;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            input = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        Back21923 back21923 = new Back21923();
        int scoreMax = back21923.computeMaxScore(n, m, map);
        writer.write(scoreMax + " ");
        writer.flush();
    }
}

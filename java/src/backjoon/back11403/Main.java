// prob: https://www.acmicpc.net/problem/11403

package backjoon.back11403;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = Integer.MAX_VALUE / 2;

    private static void floydWarshal(int[][] adjMatrix, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i < adjMatrix.length; i++) {
            String[] tmp = reader.readLine().split(" ");
            for (int j = 0; j < adjMatrix[i].length; j++) {
                int value = Integer.parseInt(tmp[j]);
                adjMatrix[i][j] = value == 0 ? INF : value;
            }
        }
        floydWarshal(adjMatrix, n);
        for (int[] matrix : adjMatrix) {
            for (int value : matrix) {
                if (value == INF) {
                    writer.write("0 ");
                    continue;
                }
                writer.write("1 ");
            }
            writer.write("\n");
        }
        writer.flush();
    }
}

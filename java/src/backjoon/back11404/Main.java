// prob: https://www.acmicpc.net/problem/11404

package backjoon.back11404;

import java.io.*;
import java.util.Arrays;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final long INF = Long.MAX_VALUE / 2;

    private static void floydWarshall(long[][] adjMatrix, int countNode) {
        for (int k = 1; k < countNode; k++) {
            for (int i = 1; i < countNode; i++) {
                for (int j = 1; j < countNode; j++) {
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        long[][] adjMatrix = new long[n + 1][n + 1];
        for (long[] matrix : adjMatrix) {
            Arrays.fill(matrix, INF);
        }
        for (int i = 0; i < adjMatrix.length; i++) {
            adjMatrix[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            String[] tmp = reader.readLine().split(" ");
            int src = Integer.parseInt(tmp[0]);
            int dst = Integer.parseInt(tmp[1]);
            int cost = Integer.parseInt(tmp[2]);
            adjMatrix[src][dst] = adjMatrix[src][dst] != INF ? Math.min(cost, adjMatrix[src][dst]) : cost;
        }
        floydWarshall(adjMatrix, n + 1);
        for (int i = 1; i < adjMatrix.length; i++) {
            for (int j = 1; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] == INF) {
                    writer.write("0 ");
                } else
                    writer.write(adjMatrix[i][j] + " ");
            }
            writer.write("\n");
        }
        writer.flush();
    }
}

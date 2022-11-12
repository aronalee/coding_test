// prob: https://www.acmicpc.net/problem/1238

package backjoon.back1238;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    private static void floydWarshall(int[][] adjMatrix) {
        for (int k = 1; k < adjMatrix.length; k++) {
            for (int i = 1; i < adjMatrix.length; i++) {
                for (int j = 1; j < adjMatrix.length; j++) {
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j]
                        , adjMatrix[k][j] + adjMatrix[i][k]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int x = Integer.parseInt(tmp[2]);
        int[][] adjMatrix = new int[n + 1][n + 1];
        for (final int[] matrix : adjMatrix) {
            Arrays.fill(matrix, Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < m; i++) {
            tmp = reader.readLine().split(" ");
            int src = Integer.parseInt(tmp[0]);
            int dst = Integer.parseInt(tmp[1]);
            int time = Integer.parseInt(tmp[2]);
            adjMatrix[src][dst] = time;
        }
        adjMatrix[x][x] = 0;
        floydWarshall(adjMatrix);
        int maxCost = 0;
        for (int studentId = 1; studentId <= n; studentId++) {
            if (maxCost > adjMatrix[studentId][x] + adjMatrix[x][studentId]) {
                continue;
            }
            maxCost = adjMatrix[studentId][x] + adjMatrix[x][studentId];
        }
        writer.write(maxCost + "\n");
        writer.flush();
    }
}

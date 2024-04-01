// prob: https://www.acmicpc.net/problem/21278

package backjoon.back21278;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] adjMatrix = createAdjMatrix(n, m);
        Back21278 back21278 = new Back21278(adjMatrix);
        back21278.decideChickens();
        List<Integer> chickenIds = back21278.getChickensBuilds();
        int distance = back21278.getMinDistance() * 2;
        writer.write(chickenIds.get(0) + " " + chickenIds.get(1) + " " + distance);
        writer.flush();
    }

    private static int[][] createAdjMatrix(int n, int m) throws IOException {
        int[][] adjMatrix = new int[n + 1][n + 1];
        for (int i = 0; i < adjMatrix.length; i++) {
            Arrays.fill(adjMatrix[i], Back21278.EMPTY);
            adjMatrix[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            String[] input = reader.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            adjMatrix[a][b] = 1;
            adjMatrix[b][a] = 1;
        }
        return adjMatrix;
    }
}

// prob: https://www.acmicpc.net/problem/1389

package backjoon.back1389;

import java.io.*;
import java.util.Arrays;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = Integer.MAX_VALUE / 5000;

    private static void floydWarshal(int[][] adjMatrix, int n) {
        for (int k = 1; k < n; k++) {
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                }
            }
        }
    }

    private static int sum(int[] array) {
        int result = 0;
        for (int i = 1; i < array.length; i++) {
            result += array[i];
        }
        return result;
    }

    private static int getMinKebinBeaconPerson(int[][] adjMatrix, int n) {
        floydWarshal(adjMatrix, n);
        int minValue = INF;
        int person = 0;
        for (int i = 1; i < adjMatrix.length; i++) {
            int beacon = sum(adjMatrix[i]);
            if (beacon >= minValue) {
                continue;
            }
            minValue = beacon;
            person = i;
        }
        return person;
    }

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int[][] adjMatrix = new int[n + 1][n + 1];
        for (int[] matrix : adjMatrix) {
            Arrays.fill(matrix, INF);
        }
        for (int i = 1; i < n; i++) {
            adjMatrix[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            tmp = reader.readLine().split(" ");
            int person1 = Integer.parseInt(tmp[0]);
            int person2 = Integer.parseInt(tmp[1]);
            adjMatrix[person1][person2] = 1;
            adjMatrix[person2][person1] = 1;
        }
        int result = getMinKebinBeaconPerson(adjMatrix, n + 1);
        writer.write(result + "\n");
        writer.flush();
    }
}

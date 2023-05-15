// prob: https://www.acmicpc.net/problem/1240

package backjoon.back1240;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] splitLine = reader.readLine().split(" ");
        int n = Integer.parseInt(splitLine[0]);
        int m = Integer.parseInt(splitLine[1]);
        int[][] adjArray = new int[n + 1][n + 1];
        for (int i = 0; i < n - 1; i++) {
            splitLine = reader.readLine().split(" ");
            int node1 = Integer.parseInt(splitLine[0]);
            int node2 = Integer.parseInt(splitLine[1]);
            int distance = Integer.parseInt(splitLine[2]);
            adjArray[node1][node2] = distance;
            adjArray[node2][node1] = distance;
        }
        Back1240 back1240 = new Back1240();
        back1240.initFloyidWarshall(adjArray, n);
        for (int i = 0; i < m; i++) {
            splitLine = reader.readLine().split(" ");
            int node1 = Integer.parseInt(splitLine[0]);
            int node2 = Integer.parseInt(splitLine[1]);
            int minDistance = back1240.getMinDistance(node1, node2);
            writer.write(minDistance + "\n");
        }
        writer.flush();
    }
}

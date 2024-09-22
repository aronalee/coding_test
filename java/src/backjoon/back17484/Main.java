// prob: https://www.acmicpc.net/problem/17484

package backjoon.back17484;

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
        String[] inputs = reader.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            inputs = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        Back17484 back17484=new Back17484();
        int minCost = back17484.computeMinCost(map,n,m);
        writer.write(minCost + "\n");
        writer.flush();
    }
}

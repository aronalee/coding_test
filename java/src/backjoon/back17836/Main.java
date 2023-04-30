// prob: https://www.acmicpc.net/problem/17836

package backjoon.back17836;

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
        int t = Integer.parseInt(splitLine[2]);
        int[][] castle = new int[n][m];
        for (int i = 0; i < n; i++) {
            splitLine = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                castle[i][j] = Integer.parseInt(splitLine[j]);
            }
        }
        Back17836 back17836 = new Back17836();
        int minTime = back17836.getAnswer(castle, t);
        if (minTime == -1) {
            writer.write("Fail");
            writer.flush();
            return;
        }
        writer.write(minTime + "");
        writer.flush();
    }
}

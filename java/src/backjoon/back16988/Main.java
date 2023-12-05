// prob: https://www.acmicpc.net/problem/16988

package backjoon.back16988;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
            new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String line = reader.readLine();
        String[] splitLine = line.split(" ");
        int n = Integer.parseInt(splitLine[0]);
        int m = Integer.parseInt(splitLine[1]);
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            splitLine = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(splitLine[j]);
            }
        }
        Back16998 back16998 = new Back16998();
        int result = back16998.createKillMaxBaduk2(board);
        writer.write(result + "\n");
        writer.flush();
    }
}

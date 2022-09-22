// https://www.acmicpc.net/problem/11660

package backjoon.back11660;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[][] cell = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= n; j++)
                cell[i][j] = cell[i - 1][j] + cell[i][j - 1] - cell[i - 1][j - 1]
                        + Integer.parseInt(tokenizer.nextToken());
        }
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int y1 = Integer.parseInt(tokenizer.nextToken());
            int x1 = Integer.parseInt(tokenizer.nextToken());
            int y2 = Integer.parseInt(tokenizer.nextToken());
            int x2 = Integer.parseInt(tokenizer.nextToken());
            long result = cell[y2][x2] - cell[y2][x1 - 1] - cell[y1 - 1][x2] + cell[y1 - 1][x1 - 1];
            writer.write(result + "\n");
        }
        writer.flush();
    }
}

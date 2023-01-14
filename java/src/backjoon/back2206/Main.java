// prob: // prob: https://www.acmicpc.net/problem/2206

package backjoon.back2206;

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
        String[] splitBlank = reader.readLine().split(" ");
        int n = Integer.parseInt(splitBlank[0]);
        int m = Integer.parseInt(splitBlank[1]);
        boolean[][] map = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            splitBlank = reader.readLine().split("");
            for (int j = 0; j < splitBlank.length; j++) {
                if (splitBlank[j].equals("1")) {
                    map[i][j] = true;
                }
            }
        }
        Back2206 back2206 = new Back2206(n, m, map);
        writer.write(back2206.getAnswer() + "\n");
        writer.flush();
    }

}

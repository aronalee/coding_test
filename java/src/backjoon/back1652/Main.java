// prob: https://www.acmicpc.net/problem/1652

package backjoon.back1652;

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
        int n = Integer.parseInt(reader.readLine());
        boolean[][] map = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] splitLine = reader.readLine().split("");
            for (int j = 0; j < n; j++) {
                if (splitLine[j].equals("X")) {
                    map[i][j] = true;
                }
            }
        }
        Back1652 back1652 = new Back1652();
        int[] answer = back1652.getAnswer(map);
        writer.write(answer[0] + " " + answer[1] + "");
        writer.flush();
    }
}

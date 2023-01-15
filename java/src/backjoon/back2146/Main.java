// prob: https://www.acmicpc.net/problem/2146

package backjoon.back2146;

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
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] splitLine = reader.readLine().split(" ");
            for (int j = 0; j < splitLine.length; j++) {
                map[i][j] = Integer.parseInt(splitLine[j]);
            }
        }
        Back2146 back2146 = new Back2146(map);
        int answer = back2146.getAnswer();
        writer.write(answer + "\n");
        writer.flush();
    }
}

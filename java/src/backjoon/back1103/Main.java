// prob: https://www.acmicpc.net/problem/1103

package backjoon.back1103;

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
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int y = 0; y < n; y++) {
            splitLine = reader.readLine().split("");
            for (int x = 0; x < splitLine.length; x++) {
                String value = splitLine[x];
                if (value.equals("H")) {
                    map[y][x] = STATUS.HOLE.value();
                    continue;
                }
                map[y][x] = Integer.parseInt(splitLine[x]);
            }
        }
        Back1103 back1103 = new Back1103(map, visited);
        int answer = back1103.createAnswer();
        if (answer == STATUS.CYCLE.value()) {
            writer.write("-1");
            writer.flush();
            return;
        }
        writer.write(answer + "\n");
        writer.flush();
    }
}

// prob: https://www.acmicpc.net/problem/14502

package backjoon.back14502;

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
        String line = reader.readLine();
        String[] splitLine = line.split(" ");
        int n = Integer.parseInt(splitLine[0]);
        int m = Integer.parseInt(splitLine[1]);
        AreaStatus[][] map = readMap(n, m);
        Back14502 back14502 = new Back14502();
        int answer = back14502.getMaxSafetyArea(map, n, m);
        writer.write(answer + "\n");
        writer.flush();
    }

    private static AreaStatus[][] readMap(int n, int m) throws IOException {
        String[] splitLine;
        AreaStatus[][] map = new AreaStatus[n][m];
        for (int y = 0; y < n; y++) {
            splitLine = reader.readLine().split(" ");
            for (int x = 0; x < splitLine.length; x++) {
                int value = Integer.parseInt(splitLine[x]);
                AreaStatus status;
                switch (value) {
                    case 0:
                        status = AreaStatus.EMPTY;
                        break;
                    case 1:
                        status = AreaStatus.BLOCK;
                        break;
                    case 2:
                        status = AreaStatus.VIRUS;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                map[y][x] = status;
            }
        }
        return map;
    }
}


// prob: https://www.acmicpc.net/problem/10026

package backjoon.back10026;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String line = reader.readLine();
        int n = Integer.parseInt(line);
        COLOR[][] map = new COLOR[n][n];
        for (int i = 0; i < n; i++) {
            line = reader.readLine();
            String[] splitLine = line.split("");
            for (int j = 0; j < map.length; j++) {
                if (splitLine[j].equals("R")) {
                    map[i][j] = COLOR.RED;
                    continue;
                }
                if (splitLine[j].equals("G")) {
                    map[i][j] = COLOR.GREEN;
                    continue;
                }
                map[i][j] = COLOR.BLUE;
            }
        }
        Back10026 back10026 = new Back10026();
        int countAreas = back10026.countAreas(map);
        int countAreaRedAndGreenEqual = back10026.countAreasRedAndGreenEqual(map);
        writer.write(countAreas + " " + countAreaRedAndGreenEqual);
        writer.flush();
    }
}

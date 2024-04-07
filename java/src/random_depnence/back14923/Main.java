// prob: https://www.acmicpc.net/problem/14923

package random_depnence.back14923;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Point start = readPoint();
        Point end = readPoint();
        int[][] map = readMap(n, m);
        Back14923 back14923 = new Back14923(map);
        try {
            int costMin = back14923.findPathMinCost(start, end);
            writer.write(costMin + "\n");
        } catch (IllegalArgumentException e) {
            writer.write("-1\n");
        }
        writer.flush();
    }

    private static int[][] readMap(int n, int m) throws IOException {
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        return map;
    }

    private static Point readPoint() throws IOException {
        String[] input = reader.readLine().split(" ");
        return Point.of(Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]) - 1);
    }
}

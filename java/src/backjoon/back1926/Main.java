// prob: https://www.acmicpc.net/problem/1926

package backjoon.back1926;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));
    private static final int[][] DISTANCES = new int[][]{
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int[][] fillInColor = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            tmp = reader.readLine().split(" ");
            for (int j = 0; j < tmp.length; j++) {
                fillInColor[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        int countDraw = 0;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || fillInColor[i][j] == 0) {
                    continue;
                }
                int area = getArea(fillInColor, visited, i, j);
                maxArea = Math.max(maxArea, area);
                countDraw++;
            }
        }
        writer.write(countDraw + "\n");
        writer.write(maxArea + "\n");
        writer.flush();
    }

    private static int getArea(final int[][] fillInColor, final boolean[][] visited, final int i,
        final int j) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{i, j});
        visited[i][j] = true;
        int area = 1;
        while (!queue.isEmpty()) {
            Integer[] now = queue.remove();
            for (final int[] distance : DISTANCES) {
                int nextY = distance[0] + now[0];
                int nextX = distance[1] + now[1];
                if (nextY < 0 || nextY >= fillInColor.length || nextX < 0
                    || nextX >= fillInColor[nextY].length) {
                    continue;
                }
                if (visited[nextY][nextX] || fillInColor[nextY][nextX] == 0) {
                    continue;
                }
                area++;
                visited[nextY][nextX] = true;
                queue.add(new Integer[]{nextY, nextX});
            }
        }
        return area;
    }
}

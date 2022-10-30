// prob: https://www.acmicpc.net/problem/2583

package backjoon.back2583;

import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int[][] distances = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int[][] board;
    private static boolean[][] visited;

    private static void fillInRect(Point start, Point end) {
        for (int i = start.getY(); i < end.getY(); i++) {
            for (int j = start.getX(); j < end.getX(); j++) {
                board[i][j] = 1;
            }
        }
    }

    private static int calArea(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.getY()][start.getX()] = true;
        int area = 1;
        while (!queue.isEmpty()) {
            Point now = queue.remove();
            for (int[] distance : distances) {
                int nextY = now.getY() + distance[0];
                int nextX = now.getX() + distance[1];
                if (nextY >= board.length || nextY < 0 || nextX >= board[nextY].length || nextX < 0)
                    continue;
                if (visited[nextY][nextX] || board[nextY][nextX] != 0)
                    continue;
                visited[nextY][nextX] = true;
                area++;
                queue.add(new Point(nextX, nextY));
            }
        }
        return area;
    }

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int m = Integer.parseInt(tmp[0]);
        int n = Integer.parseInt(tmp[1]);
        int k = Integer.parseInt(tmp[2]);
        board = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < k; i++) {
            tmp = reader.readLine().split(" ");
            Point src = new Point(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
            Point dst = new Point(Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3]));
            fillInRect(src, dst);
        }

        List<Integer> results = new ArrayList<>();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] != 0 || visited[y][x]) {
                    continue;
                }
                results.add(calArea(new Point(x, y)));
            }
        }
        results.sort(Comparator.comparingInt(v -> v));
        writer.write(results.size() + "\n");
        for (Integer result : results) {
            writer.write(result + " ");
        }
        writer.flush();
    }

    private static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}

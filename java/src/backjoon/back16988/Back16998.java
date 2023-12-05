// prob: https://www.acmicpc.net/problem/16988

package backjoon.back16988;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Back16998 {

    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int createKillMaxBaduk2(int[][] board) {
        int maxKillBaduk2 = 0;
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] != 0) {
                    continue;
                }
                Point firstBaduk = new Point(y, x);
                int killedBaduk = createMasKillBadukAboutSelectedFirstBaduk(board, firstBaduk);
                maxKillBaduk2 = Math.max(maxKillBaduk2, killedBaduk);
            }
        }
        return maxKillBaduk2;

    }

    private int createMasKillBadukAboutSelectedFirstBaduk(int[][] board, Point firstBaduk2) {
        board[firstBaduk2.y][firstBaduk2.x] = 1;
        int maxKillBaduk = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        visited[firstBaduk2.y][firstBaduk2.x] = true;
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] != 0 || visited[y][x]) {
                    continue;
                }
                Point secondBaduk = new Point(y, x);
                visited[y][x] = true;
                board[secondBaduk.y][secondBaduk.x] = 1;
                int killedBaduk = simulateKillBaduk(board);
                maxKillBaduk = Math.max(maxKillBaduk, killedBaduk);
                board[secondBaduk.y][secondBaduk.x] = 0;
            }
        }
        board[firstBaduk2.y][firstBaduk2.x] = 0;
        return maxKillBaduk;
    }

    private int simulateKillBaduk(int[][] board) {
        int killedBaduk = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] != 2 || visited[y][x]) {
                    continue;
                }
                int result = bfs(board, visited, new Point(y, x));
                killedBaduk += result;
            }
        }
        return killedBaduk;
    }

    private int bfs(int[][] board, boolean[][] visited, Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        visited[point.y][point.x] = true;
        int killedBaduk = 0;
        boolean isNotRounded = false;
        while (!queue.isEmpty()) {
            Point now = queue.remove();
            killedBaduk++;
            for (int[] direction : directions) {
                int nextY = now.y + direction[0];
                int nextX = now.x + direction[1];
                if (nextY < 0 || nextX < 0 || nextY >= board.length || nextX >= board[nextY].length) {
                    continue;
                }
                if (board[nextY][nextX] == 0) {
                    isNotRounded = true;
                }
                if (board[nextY][nextX] != 2 || visited[nextY][nextX]) {
                    continue;
                }
                visited[nextY][nextX] = true;
                queue.add(new Point(nextY, nextX));
            }
        }
        if (isNotRounded) {
            return 0;
        }
        return killedBaduk;
    }


    private static class Point {
        private final int y;
        private final int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return y == point.y && x == point.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}

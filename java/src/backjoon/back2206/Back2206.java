package backjoon.back2206;

import java.util.LinkedList;
import java.util.Queue;

public class Back2206 {

    private final int n;
    private final int m;
    private final boolean[][] map;
    private final int[][] DIRECTIONS = new int[][]{
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    public Back2206(int n, int m, boolean[][] map) {
        this.n = n;
        this.m = m;
        this.map = map;
    }

    public int getAnswer() {
        boolean[][][] visited = new boolean[2][n][m];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, false));
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            Node now = queue.remove();
            if (now.y == n - 1 && now.x == m - 1) {
                return now.distance;
            }
            for (int[] direction : DIRECTIONS) {
                int nextY = now.y + direction[0];
                int nextX = now.x + direction[1];
                if (isNotRangePoint(nextY, nextX)) {
                    continue;
                }
                if (now.isCrashed) {
                    if (visited[1][nextY][nextX] || map[nextY][nextX]) {
                        continue;
                    }
                    visited[1][nextY][nextX] = true;
                    queue.add(new Node(nextY, nextX, now.distance + 1, true));
                    continue;
                }
                if (visited[0][nextY][nextX]) {
                    continue;
                }
                if (map[nextY][nextX]) {
                    visited[1][nextY][nextX] = true;
                    queue.add(new Node(nextY, nextX, now.distance + 1, true));
                    continue;
                }
                visited[0][nextY][nextX] = true;
                queue.add(new Node(nextY, nextX, now.distance + 1, false));
            }
        }

        return -1;
    }

    private boolean isNotRangePoint(int nextY, int nextX) {
        return nextY < 0 || nextY >= n || nextX < 0 || nextX >= m;
    }


    private static class Node {

        private final int y;
        private final int x;
        private final int distance;
        private final boolean isCrashed;

        public Node(int y, int x, int distance, boolean isCrashed) {
            this.y = y;
            this.x = x;
            this.distance = distance;
            this.isCrashed = isCrashed;
        }
    }
}

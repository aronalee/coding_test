// prob: https://www.acmicpc.net/problem/16174

package random_depence.back16174;

import java.util.LinkedList;
import java.util.Queue;

public class Back16174 {

    private final int[][] DIRECTIONS = new int[][]{
        {0, 1}, {1, 0}
    };

    public boolean isWinGame(int[][] map) {
        Point dst = new Point(map.length - 1, map.length - 1);
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        boolean[][] visited = new boolean[map.length][map.length];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Point now = queue.remove();
            if (now.equals(dst)) {
                return true;
            }
            int moveCount = map[now.y][now.x];
            for (int[] direction : DIRECTIONS) {
                int nextPointY = now.y + direction[0] * moveCount;
                int nextPointX = now.x + direction[1] * moveCount;
                if (nextPointY >= map.length || nextPointX >= map.length || visited[nextPointY][nextPointX]) {
                    continue;
                }
                visited[nextPointY][nextPointX] = true;
                queue.add(new Point(nextPointY, nextPointX));
            }
        }
        return false;
    }

    private class Point {

        private final int y;
        private final int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return y == point.y && x == point.x;
        }

    }
}

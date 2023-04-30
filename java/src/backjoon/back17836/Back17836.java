// prob: https://www.acmicpc.net/problem/17836

package backjoon.back17836;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Back17836 {

    private final int EMPTY = Integer.MAX_VALUE;

    public int getAnswer(int[][] castles, int timeLimit) {
        Point sword = findSwordPoint(castles);
        Point hero = Point.of(0, 0);
        Point prince = Point.of(castles.length - 1, castles[0].length - 1);
        int heroToSwordToPrince = findMinTimeHeroToSwordToPrince(castles, hero, sword, prince);
        int heroToPrince = findMinTimeNotBreakingWall(castles, hero, prince);
        if (heroToSwordToPrince == EMPTY && heroToPrince == -EMPTY) {
            return -1;
        }
        int minTime = Math.min(heroToPrince, heroToSwordToPrince);
        if (minTime > timeLimit) {
            return -1;
        }
        return minTime;
    }

    private int findMinTimeNotBreakingWall(int[][] castles, Point src, Point dst) {
        int[][] DIRECTIONS = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[castles.length][castles[0].length];
        queue.add(Node.of(src, 0));
        visited[src.y][src.x] = true;
        while (!queue.isEmpty()) {
            Node now = queue.remove();
            for (int[] direction : DIRECTIONS) {
                int nextY = now.point.y + direction[0];
                int nextX = now.point.x + direction[1];
                if (nextY < 0 || nextY >= castles.length || nextX < 0
                    || nextX >= castles[0].length) {
                    continue;
                }
                if (visited[nextY][nextX] || castles[nextY][nextX] == 1) {
                    continue;
                }
                if (Point.of(nextY, nextX).equals(dst)) {
                    return now.time + 1;
                }
                visited[nextY][nextX] = true;
                queue.add(Node.of(Point.of(nextY, nextX), now.time + 1));
            }
        }
        return EMPTY;
    }

    private int findMinTimeHeroToSwordToPrince(int[][] castles,
        Point hero,
        Point sword,
        Point prince) {
        int heroToSword = findMinTimeNotBreakingWall(castles, hero, sword);
        int swordToPrince = findMinTimeBreakingWall(sword, prince);
        if (heroToSword == EMPTY) {
            return EMPTY;
        }
        return heroToSword + swordToPrince;
    }

    private int findMinTimeBreakingWall(Point src, Point dst) {
        return Math.abs(src.y - dst.y) + Math.abs(src.x - dst.x);
    }

    private Point findSwordPoint(int[][] castle) {
        for (int y = 0; y < castle.length; y++) {
            for (int x = 0; x < castle[y].length; x++) {
                if (castle[y][x] == 2) {
                    return Point.of(y, x);
                }
            }
        }
        throw new IllegalArgumentException();
    }

    private static class Node {

        private final Point point;
        private final int time;

        private Node(Point point, int time) {
            this.point = point;
            this.time = time;
        }

        public static Node of(Point point, int time) {
            return new Node(point, time);
        }
    }

    private static class Point {

        private final int y;
        private final int x;

        private Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public static Point of(int y, int x) {
            return new Point(y, x);
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

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}
